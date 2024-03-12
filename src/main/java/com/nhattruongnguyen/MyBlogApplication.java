package com.nhattruongnguyen;

import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.entity.RoleEntity;
import com.nhattruongnguyen.entity.UserEntity;
import com.nhattruongnguyen.repository.CategoryRepository;
import com.nhattruongnguyen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}
}
