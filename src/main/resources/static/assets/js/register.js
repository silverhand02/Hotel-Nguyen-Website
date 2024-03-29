let inputGroup = document.querySelectorAll(".form-control");

let password = inputGroup[6];
let confirmPassword = inputGroup[7];
let formCheckInput = document.querySelector(".form-check-input");
let submitBtn = document.querySelector(".submit-btn");
let errMsg = document.querySelector("#err-msg");
let phone = inputGroup[5];
let email = inputGroup[3];
let identity = inputGroup[8];
submitBtn.onclick = function handleRegister() {
    for(input of inputGroup) {
        if(input.value === ""){
            errMsg.innerText = "Vui lòng nhập đầy đủ thông tin";
            input.style.border="1px solid red";
            return false;
        }
        else if(!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)){
            errMsg.innerText = "Vui lòng nhập đúng email"
            return false;
        }
        else if(!phone.value.match(/^\d+$/) || phone.value.length!==10){
            errMsg.innerText = "Vui lòng nhập đúng số điện thoại";
            return false;
        }
        else if(password.value.length <8){
            password.style.border = "1px solid red";
            errMsg.innerText = "Vui lòng nhập mật khẩu ít nhất 8 kí tự";
            return false;
        }
        else if(password.value !==confirmPassword.value){
            password.style.border = "1px solid red";
            errMsg.innerText = "Xác nhận mật khẩu không trùng khớp";
            return false;
        }
        else if(!formCheckInput.value==="on"){
            errMsg.innerText = "Vui lòng đánh dấu vào ô xác nhận";
            return false;
        }else if(identity.value.length !==11){
        	errMsg.innerText = "Vui lòng nhập đúng kiểu CCCD/CMND";
            return false;
        }
        else{
            input.style.border="unset";
        }
        return true;
    }
}




let navLinks = document.getElementById("nav-links");
function showMenu() {
    navLinks.style.right = "0";
}

function hideMenu() {
    navLinks.style.right = "-400px";
}