package com.java.Final_Nguyen22.Final_Nguyen22;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@Configuration
@ComponentScan(basePackages = {"com.example"})

class FinalNguyen22ApplicationTests {

	@Test
	void contextLoads() {
	}

}
