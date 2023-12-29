package org.in60min;

import org.in60min.entity.Alian;
import org.in60min.repo.AlianRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJdbcApplication.class, args);

		Alian alian = context.getBean(Alian.class);
		alian.setId(121);
		alian.setName("Ramu");
		alian.setTech("AI");

		AlianRepo alianRepo = context.getBean(AlianRepo.class);
		alianRepo.save(alian);

		System.out.println(alianRepo.findAll());
	}

}
