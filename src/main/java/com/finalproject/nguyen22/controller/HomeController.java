package com.finalproject.nguyen22.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalproject.nguyen22.entity.Banking;
import com.finalproject.nguyen22.entity.Booking;
import com.finalproject.nguyen22.entity.Momo;
import com.finalproject.nguyen22.entity.Payment;
import com.finalproject.nguyen22.entity.Room;
import com.finalproject.nguyen22.entity.User;
import com.finalproject.nguyen22.service.BankingService;
import com.finalproject.nguyen22.service.BookingService;
import com.finalproject.nguyen22.service.MomoService;
import com.finalproject.nguyen22.service.PaymentService;
import com.finalproject.nguyen22.service.RoomService;
import com.finalproject.nguyen22.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private MomoService momoService;

	@Autowired
	private BankingService bankingService;

	@GetMapping("/customer_info")
	public ModelAndView getCustomerInfo(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("nameOfUser") == null) {
			mav.setViewName("redirect:/login");
		}
		if (session.getAttribute("nameOfUser").toString().equals("admin")) {
			mav.setViewName("redirect:/admin");
		} else {
			String name = session.getAttribute("nameOfUser").toString();
			model.addAttribute("nameOfUser", "Xin chào, " + name);
			model.addAttribute("user", new User());
			String username = session.getAttribute("usernameSession").toString();
			mav.addObject("userInfo", userService.findByUsername(username));
			mav.setViewName("customer_info");
		}

		return mav;
	}

	@PostMapping("/edit_info")
	public String editCustomer(Model model, HttpSession session, @RequestParam("fullName") String fullName,
			@RequestParam("birthday") String birthday, @RequestParam("address") String address,
			@RequestParam("identity") String identity) {
		String username = session.getAttribute("usernameSession").toString();
		User currUser = userService.findByUsername(username);

		if (fullName.equals("") && birthday.equals("") && address.equals("") && identity.equals("")) {
			return "redirect:/customer_info";
		}
		if (!fullName.equals("")) {
			currUser.setFullName(fullName);
			session.setAttribute("nameOfUser", fullName);
		}
		if (!birthday.equals("")) {
			currUser.setBirthday(birthday);
		}
		if (!address.equals("")) {
			currUser.setAddress(address);
		}
		if (!identity.equals("")) {
			currUser.setIdentity(identity);
		}
		userService.save(currUser);
		return "redirect:/customer_info";
	}

	@GetMapping("/admin_userList")
	public ModelAndView showadmin(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		if (session.getAttribute("nameOfUser") == null) {
			mav.setViewName("redirect:/login");
		} else {
			mav.addObject("userList", userService.getAll());
			mav.setViewName("admin_userList");
		}
		return mav;
	}

	@GetMapping("/delete_user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "redirect:/admin_userList";
	}

	@GetMapping("/admin_roomList")
	public ModelAndView getRoomListByAdmin(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		if (session.getAttribute("nameOfUser") == null) {
			mav.setViewName("redirect:/login");
		} else {
			mav.addObject("roomList", roomService.getAll());
			mav.setViewName("admin_roomList");
		}
		return mav;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("nameOfUser") != null) {
			session.invalidate();
		}
		return "redirect:/login";
	}

	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView("/");
		if (session.getAttribute("nameOfUser") != null) {
			mav.setViewName("redirect:/home");
		} else {
//			if(userService.findByUsername("admin")==null) {
//				createAdmin();	
//			}
			mav.addObject("listRooms", roomService.getAll());
			mav.addObject("listRoomsBySix", roomService.getAllBySix(roomService.getAll()));

			mav.setViewName("index");
		}
		return mav;
	}

	@GetMapping("/login")
	public String showLoginPage(HttpSession session) {
		if (session.getAttribute("nameOfUser") == null) {
			return "login";
		}

		else {
			return "redirect:/home";
		}
	}

	@PostMapping("/submit_login")
	public ModelAndView submitLogin(Model model, User user, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		if (userService.findByUsername(user.getUsername()) == null) {
			mav.addObject("error", true);
			mav.setViewName("redirect:/login");

		} else {

			String role = userService.findByUsername(user.getUsername()).getRole();
			String password = userService.findByUsername(user.getUsername()).getPassword();
			String username = userService.findByUsername(user.getUsername()).getUsername();
			boolean checkPass = BCrypt.checkpw(user.getPassword(), password);

			if (role.equals("ROLE_USER") && checkPass == true && username.equals(user.getUsername())) {

				String fullname = userService.findByUsername(user.getUsername()).getFullName();
				session.setAttribute("nameOfUser", fullname);
				session.setAttribute("usernameSession", username);
				mav.addObject("listRooms", roomService.getAll());
				mav.addObject("listRoomsBySix", roomService.getAllBySix(roomService.getAll()));
				mav.setViewName("redirect:/home");
			} else if (role.equals("ROLE_ADMIN") && checkPass && username.equals(user.getUsername())) {
				mav.setViewName("redirect:/admin_userList");
				session.setAttribute("nameOfUser", "admin");
			} else {
				mav.addObject("error", true);
				mav.setViewName("redirect:/login");
			}
		}
		return mav;
	}

	@GetMapping("/register")
	public String showRegisterPage(Model model, HttpSession session) {
		if (session.getAttribute("nameOfUser") == null) {
			model.addAttribute("user", new User());
			return "register";
		} else {
			return "redirect:/home";
		}

	}

	@PostMapping("/submit_register")
	public String submitRegister(Model model, User user) {

		if (userService.findByUsername(user.getUsername()) != null) {
			model.addAttribute("ERROR", "Tên người dùng đã có người sử dụng");
			return "register";
		} else if (userService.findByPhone(user.getPhone()) != null) {
			model.addAttribute("ERROR", "Số điện thoại đã có người sử dụng");
			return "register";
		} else if (userService.findByEmail(user.getEmail()) != null) {
			model.addAttribute("ERROR", "Email đã có người sử dụng");
			return "register";
		} else {

			String encodedPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			if (user.getPassword().equals(user.getConfirmpassword())) {
				user.setPassword(encodedPass);
				user.setConfirmpassword(encodedPass);
			}
			user.setEnabled(1);
			user.setRole("ROLE_USER");
			userService.save(user);
			return "login";
		}
	}

	@PostMapping("/do_changePass")
	public String doChangePass(@RequestParam("old_pass") String oldPass, @RequestParam("new_pass") String newPass,
			@RequestParam("conf_new_pass") String confNewPass, HttpSession session, Model model) {
		String username = session.getAttribute("usernameSession").toString();
		User currUser = userService.findByUsername(username);
		String currPass = userService.findByUsername(username).getPassword();
		if (BCrypt.checkpw(oldPass, currPass)) {
			currUser.setPassword(BCrypt.hashpw(newPass, BCrypt.gensalt(12)));
			userService.save(currUser);
		} else {
			model.addAttribute("err_msg", "Mật khẩu hiện tại của bạn không chính xác");
			return "changePass";
		}

		return "redirect:/home";
	}

	@GetMapping("/changePass")
	public String getChangePass(HttpSession session, Model model) {
		if (session.getAttribute("nameOfUser") == null) {
			return "redirect:/login";
		}
		String name = session.getAttribute("nameOfUser").toString();
		model.addAttribute("nameOfUser", "Xin chào, " + name);
		return "changePass";
	}

	@GetMapping("/home")
	public ModelAndView getHome(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("home");
		if (session.getAttribute("nameOfUser") == null) {
			mav.setViewName("redirect:/login");
		}
		if (session.getAttribute("nameOfUser").toString().equals("admin")) {
			mav.setViewName("redirect:/admin");
		} else {
			String name = session.getAttribute("nameOfUser").toString();
			model.addAttribute("nameOfUser", "Xin chào, " + name);
			mav.addObject("listRooms", roomService.getAll());
			mav.addObject("listRoomsBySix", roomService.getAllBySix(roomService.getAll()));
			mav.setViewName("home");
		}
		return mav;
	}

	@RequestMapping(value = "/filter/{room_type}")
	public String filter(@PathVariable(name = "room_type") String room_type, Model model, HttpSession session) {
//		model.addAttribute("listRooms", service.getAll());
		if (session.getAttribute("nameOfUser") != null) {
			model.addAttribute("nameOfUser", "Xin chào, " + session.getAttribute("nameOfUser").toString());
			if (room_type.equals("phong2nguoi")) {
				model.addAttribute("listRooms", roomService.filterByRoomType("Phòng 2 người"));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomType("Phòng 2 người")));
			} else if (room_type.equals("phong4nguoi")) {
				model.addAttribute("listRooms", roomService.filterByRoomType("Phòng 4 người"));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomType("Phòng 4 người")));
			} else if (room_type.equals("phongvip")) {
				model.addAttribute("listRooms", roomService.filterByRoomType("Phòng VIP"));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomType("Phòng VIP")));
			} else if (room_type.equals("below100k")) {
				model.addAttribute("listRooms", roomService.filterByRoomPrice(0, 100000));
				model.addAttribute("listRoomsBySix", roomService.getAllBySix(roomService.filterByRoomPrice(0, 100000)));
			} else if (room_type.equals("between101kand300k")) {
				model.addAttribute("listRooms", roomService.filterByRoomPrice(100000, 300000));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomPrice(100000, 300000)));
			} else if (room_type.equals("between301kand400k")) {
				model.addAttribute("listRooms", roomService.filterByRoomPrice(301000, 400000));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomPrice(301000, 400000)));
			} else if (room_type.equals("phongtrong")) {
				model.addAttribute("listRooms", roomService.filterByRoomStatus(0));
				model.addAttribute("listRoomsBySix", roomService.getAllBySix(roomService.filterByRoomStatus(0)));
			}
			return "home";
		} else {
			if (room_type.equals("phong2nguoi")) {
				model.addAttribute("listRooms", roomService.filterByRoomType("Phòng 2 người"));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomType("Phòng 2 người")));
			} else if (room_type.equals("phong4nguoi")) {
				model.addAttribute("listRooms", roomService.filterByRoomType("Phòng 4 người"));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomType("Phòng 4 người")));
			} else if (room_type.equals("phongvip")) {
				model.addAttribute("listRooms", roomService.filterByRoomType("Phòng VIP"));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomType("Phòng VIP")));
			} else if (room_type.equals("below100k")) {
				model.addAttribute("listRooms", roomService.filterByRoomPrice(0, 100000));
				model.addAttribute("listRoomsBySix", roomService.getAllBySix(roomService.filterByRoomPrice(0, 100000)));
			} else if (room_type.equals("between101kand300k")) {
				model.addAttribute("listRooms", roomService.filterByRoomPrice(100000, 300000));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomPrice(100000, 300000)));
			} else if (room_type.equals("between301kand400k")) {
				model.addAttribute("listRooms", roomService.filterByRoomPrice(301000, 400000));
				model.addAttribute("listRoomsBySix",
						roomService.getAllBySix(roomService.filterByRoomPrice(301000, 400000)));
			} else if (room_type.equals("phongtrong")) {
				model.addAttribute("listRooms", roomService.filterByRoomStatus(0));
				model.addAttribute("listRoomsBySix", roomService.getAllBySix(roomService.filterByRoomStatus(0)));
			}
			return "index";
		}
	}

	@RequestMapping("/detail/{room_id}")
	public ModelAndView showRoomDetail(@PathVariable(name = "room_id") int room_id, HttpSession session) {
		ModelAndView mav = new ModelAndView("detail");
		if (session.getAttribute("nameOfUser") == null) {
			mav.setViewName("redirect:/login");
		} else {
			String name = session.getAttribute("nameOfUser").toString();
			mav.addObject("nameOfUser", "Xin chào, " + name);
			Room room = roomService.getRoomById(room_id);
			mav.addObject("room", room);
		}
		return mav;
	}

	@RequestMapping(value = "/booking/{room_id}", method = RequestMethod.GET)
	public ModelAndView showBookingForm(@PathVariable(name = "room_id") int room_id, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("booking");
		Room room = roomService.getRoomById(room_id);
		String username = session.getAttribute("usernameSession").toString();
		int user_id = userService.findByUsername(username).getId();

		mav.addObject("user_id", user_id);
		if (session.getAttribute("nameOfUser") == null) {
			mav.setViewName("redirect:/login");
		}
		if (room.getStatus_id() == 1) {
			mav.addObject("errorMessage", "Hết phòng");
			mav.setViewName("redirect:/detail/" + room_id);
			return mav;
		}

		Booking booking = new Booking();
		mav.addObject("booking", booking);
		mav.addObject("room", room);
		return mav;
	}

	@RequestMapping(value = "/booking/payment", method = RequestMethod.POST)
	public String saveBooking(@ModelAttribute Booking booking, Model model, RedirectAttributes redirectAttributes) {
		ArrayList<String> errorMessage = new ArrayList<String>();

		if (booking.getCheckin_date() != null && booking.getCheckout_date() != null
				&& booking.getCheckin_date().compareTo(booking.getCheckout_date()) <= 0) {
			model.addAttribute("booking", booking);
			bookingService.save(booking);
			Room room = roomService.getRoomById(booking.getRoom_id());

			long date_stay = booking.getCheckout_date().getTime() - booking.getCheckin_date().getTime();
			Date date = new Date(date_stay);

			model.addAttribute("price", date.getDate() * room.getPrice());
			return "payment";

		}
		if (booking.getCheckin_date() == null) {
			errorMessage.add("Vui lòng chọn ngày nhận phòng");
		}
		if (booking.getCheckout_date() == null) {
			errorMessage.add("Vui lòng chọn ngày trả phòng");
		}

		redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
		return "redirect:/booking/" + booking.getRoom_id();
	}

	@RequestMapping(value = "/booking/payment/check", method = RequestMethod.POST)
	public String testPaymentCheck(@ModelAttribute Payment payment, Model model, HttpSession session) {
		if (session.getAttribute("nameOfUser") == null) {
			return "redirect:/login";
		}
		Date date = new Date(System.currentTimeMillis());
		payment.setPayment_date(date);
		int method = payment.getPayment_type();

		paymentService.save(payment);
		model.addAttribute("payment", payment);
		if (method == 0) {
			Room room = roomService.getRoomById(bookingService.getById(payment.getBooking_id()).getRoom_id());
			room.setStatus_id(1);
			roomService.save(room);
			model.addAttribute("room", room);
			return "test";
		} else if (method == 1) {
			return "confirmMomo";
		} else if (method == 2) {
			return "confirmBanking";
		}
		return "test";
	}

	@RequestMapping(value = "/booking/payment/momo", method = RequestMethod.GET)
	public String getConfirmMomo(Model model) {
		Payment payment = (Payment) model.getAttribute("payment");

//		paymentService.save(payment);	

		model.addAttribute("payment", payment);

		// Error handler if has error
		model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
		return "confirmMomo";
	}

	@RequestMapping(value = "/booking/payment/momo", method = RequestMethod.POST)
	public String confirmMomo(@RequestParam("phone") String phone, @RequestParam("ccv") String ccv,
			@RequestParam("amount") String price_str, @RequestParam("payment_id") String payment_id_str, Model model,
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (session.getAttribute("nameOfUser") == null) {
			return "redirect:/login";
		}
		long payment_id = Long.parseLong(payment_id_str);
		Payment payment = paymentService.getByPaymentId(payment_id);

		if (phone == null) {
			redirectAttributes.addFlashAttribute("errorMessage", "Vui lòng nhập số điện thoại");
		}
		if (ccv == null) {
			redirectAttributes.addFlashAttribute("errorMessage", "Vui lòng nhập mật khẩu");
		} else {

			long phoneMomo = Long.parseLong(phone);

			int price = Integer.parseInt(price_str);

			if (momoService.isExistMomo(phoneMomo)) {

				Momo checkMomo = momoService.getByPhone(phoneMomo);

				if (Integer.parseInt(ccv) != checkMomo.getCcv()) {
					redirectAttributes.addFlashAttribute("errorMessage", "CCV does not match");
				} else {
					if (price > checkMomo.getWallet()) {
						redirectAttributes.addFlashAttribute("errorMessage", "Your wallet is not enough money");
					} else {
						if (paymentService.isExistsPayment(payment_id) && payment.getStatus() == 1) {
							return "redirect:/";
						}

						payment.setStatus(1);
						checkMomo.setWallet(checkMomo.getWallet() - payment.getPrice());

						// Render room to set status is 1

						Room room = roomService
								.getRoomById(bookingService.getById(payment.getBooking_id()).getRoom_id());
						room.setStatus_id(1);

						roomService.save(room);
						paymentService.save(payment);
						momoService.save(checkMomo);
						model.addAttribute("newPayment", payment);
						model.addAttribute("momoCheck", checkMomo);
						model.addAttribute("room", room);
						model.addAttribute("status", "Booking successful");
						return "test";
					}
				}
			} else {
				redirectAttributes.addFlashAttribute("errorMessage", "Phone does not match");
			}
		}
		redirectAttributes.addFlashAttribute("payment", payment);
		return "redirect:/booking/payment/momo";
	}

	@RequestMapping(value = "/booking/payment/banking", method = RequestMethod.GET)
	public String getConfirmBanking(Model model) {
		Payment payment = (Payment) model.getAttribute("payment");

		model.addAttribute("payment", payment);

		// Error handler if has error
		model.addAttribute("errorMessage", model.getAttribute("errorMessage"));

		return "confirmBanking";
	}

	@RequestMapping(value = "/booking/payment/banking", method = RequestMethod.POST)
	public String confirmBanking(@RequestParam("id_card") String id_card_str, @RequestParam("ccv") String ccv,
			@RequestParam("amount") String price_str, @RequestParam("payment_id") String payment_id_str, Model model,
			RedirectAttributes redirectAttributes) {
		long id_card = Long.parseLong(id_card_str);
		int price = Integer.parseInt(price_str);
		long payment_id = Long.parseLong(payment_id_str);

		Payment payment = paymentService.getByPaymentId(payment_id);

		if (bankingService.isExistBanking(id_card)) {

			Banking banking = bankingService.getByIdCard(id_card);
			if (Integer.parseInt(ccv) != banking.getCcv()) {

				redirectAttributes.addFlashAttribute("errorMessage", "CCV does not match");
			} else {
				if (price > banking.getWallet()) {

					redirectAttributes.addFlashAttribute("errorMessage", "Your wallet is not enough money");
				} else {
					if (paymentService.isExistsPayment(payment_id) && payment.getStatus() == 1) {
						return "redirect:/";
					}

					payment.setStatus(1);
					banking.setWallet(banking.getWallet() - payment.getPrice());

					// Render room to set status is 1

					Room room = roomService.getRoomById(bookingService.getById(payment.getBooking_id()).getRoom_id());
					room.setStatus_id(1);

					roomService.save(room);
					paymentService.save(payment);
					bankingService.save(banking);
					model.addAttribute("newPayment", payment);
					model.addAttribute("banking", banking);
					model.addAttribute("room", room);
					model.addAttribute("status", "Booking successful");
					return "test";
				}
			}
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Id card does not match");
		}

		redirectAttributes.addFlashAttribute("payment", payment);
		return "redirect:/booking/payment/banking";
	}

	@RequestMapping(value = "/lichsudatphong", method = RequestMethod.GET)
	public String confirmBanking(Model model, HttpSession session) {
		String username = session.getAttribute("usernameSession").toString();

		int user_id = userService.findByUsername(username).getId();

		List<Booking> bookings = bookingService.getByUserId(user_id);
		List<Payment> payments = paymentService.getByBookingId(bookings);

		model.addAttribute("bookings", bookings);
		model.addAttribute("payments", payments);
		model.addAttribute("username", session.getAttribute("nameOfUser"));
		return "history";

	}
}
