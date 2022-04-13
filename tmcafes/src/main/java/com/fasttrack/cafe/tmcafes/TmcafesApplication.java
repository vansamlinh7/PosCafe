package com.fasttrack.cafe.tmcafes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TmcafesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TmcafesApplication.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		//SHA1
		System.out.println(new BCryptPasswordEncoder().encode("admin123"));
	}
}
