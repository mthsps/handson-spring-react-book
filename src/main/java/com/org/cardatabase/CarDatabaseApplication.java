package com.org.cardatabase;

import com.org.cardatabase.model.Car;
import com.org.cardatabase.model.Owner;
import com.org.cardatabase.model.User;
import com.org.cardatabase.repository.CarRepository;
import com.org.cardatabase.repository.OwnerRepository;
import com.org.cardatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class CarDatabaseApplication {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner () {
		return args -> {

			Owner owner1 = ownerRepository.save(new Owner("John" , "Johnson"));
			Owner owner2 = ownerRepository.save(new Owner("Mary" , "Lameness"));
			Owner owner3 = ownerRepository.save(new Owner("John" , "Johnson"));
			Owner owner4 = ownerRepository.save(new Owner("Norbert" , "Alm"));
			Owner owner5 = ownerRepository.save(new Owner("Lara" , "Lorem"));
			Owner owner6 = ownerRepository.save(new Owner("Hebert" , "Albert"));

			Car car1 = carRepository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000));

			Car car2 = carRepository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000));

			Car car3 = carRepository.save(new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000));


			owner1.getCars().addAll(Arrays.asList(car1, car3));
			ownerRepository.save(owner1);

			owner2.getCars().addAll(Arrays.asList(car1, car2));
			ownerRepository.save(owner2);

			owner3.getCars().addAll(Arrays.asList(car2, car3));
			ownerRepository.save(owner3);

			userRepository.save(new User("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					"USER"));

			userRepository.save(new User("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					"ADMIN"));
		};

	}
}
