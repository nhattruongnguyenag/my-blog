package com.nhattruongnguyen;

import com.nhattruongnguyen.entity.RoleEntity;
import com.nhattruongnguyen.entity.UserEntity;
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

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("Nguyễn Nhật Trường");
		userEntity.setEmail("nhattruongnguyenag@gmail.com");
		userEntity.setAvatar("http://localhost:8080/resources/admin/img/img.jpg");
		List<RoleEntity> roles = new ArrayList<>();
		RoleEntity role = new RoleEntity();
		role.setId(1L);
		List<UserEntity> userEntities = new ArrayList<>();
		userEntities.add(userEntity);
		role.setUsers(userEntities);
		roles.add(role);
		userEntity.setRoles(roles);
		userEntity.setActive(1);
		userEntity.setPassword(passwordEncoder.encode("123456"));
//		userRepository.save(userEntity);
		System.out.println("hello world, I have just started up");
	}
}
