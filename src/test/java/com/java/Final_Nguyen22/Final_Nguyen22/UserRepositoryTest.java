package com.java.Final_Nguyen22.Final_Nguyen22;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.finalproject.nguyen22.entity.User;
import com.finalproject.nguyen22.repositories.UserRepository;

@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = FinalNguyen22ApplicationTests.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFullName("Phat");
		user.setUsername("phat123");
		user.setAddress("HCM");
		user.setBirthday("2002");
		user.setPhone("0144725836");
		user.setEmail("aaa@gmail.com");
		user.setPassword("123456789");
		user.setConfirmpassword("123456789");
		user.setIdentity("0147258369");
//		user.setRole("0");
		
		User savedUser = repo.save(user);

		User existUser = entityManager.find(User.class,savedUser.getId());
		assertThat(existUser.getUsername()).isEqualTo(user.getUsername());
	}
	
	@Test
	public void TestFindUserByUsername() {
		String username = "driss123";
		User user = repo.findByUsername(username);
		
		assertThat(user).isNotNull();
	}
	
}