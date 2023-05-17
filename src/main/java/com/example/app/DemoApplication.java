package com.example.app;

import com.example.app.Files.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}
}
