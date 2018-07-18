package com.brainmatic.pos;

import com.brainmatic.pos.core.*;
import com.brainmatic.pos.infra.data.mongodb.ProductMongoRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class PosApplication {

	public static void mainCoba(String[] args) {
		Product pl = new Product();
		pl.setId(1);
		pl.setName("Momogi");
		pl.setPrice(BigDecimal.valueOf(500));

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("Pepsi");
		p2.setPrice(BigDecimal.valueOf(5000));

		Product p3 = new Product();
		p3.setId(3);
		p3.setName("Ayam");
		p3.setPrice(BigDecimal.valueOf(50000));


		ProductRepo repo = new ProductMongoRepo();
		repo.save(pl);
		repo.save(p2);
		repo.save(p3);

		Product prd2 = repo.getById(2);
		System.out.println(prd2.getName());

		ArrayList<Product> prods = repo.getAll();
		for(Product p:prods){
			System.out.println(p.getName()); // hasilnya Momogi,Pepsi, Ayam
		}

//		ProductService service = new ProductService();
//		System.out.println(service.generateId()); // hasilnya 4

		ProductService service = new ProductService(new ProductMongoRepo());
		System.out.println(service.generateId()); // hasilnya 4
	}

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
//		ApplicationContext ctx = SpringApplication.run(PosApplication.class, args);
//		ProductService service = ctx.getBean(ProductService.class);
//		System.out.println(service.generateCode());
	}
	public static void mainmain(String[] args) {

		// Scenario
		// Object Diagram
		// Class Diagram
		// Implementasi ke code

		//->
		// Ada Sebuah Penjualan S01, dijual Michael Suyama,
		// Beli momogi 500 dua,
		// Pepsi 5000 satu
		// Total 6000
		//<-

		//->
		// Ada Sebuah Penjualan S02, dijual Nancy Davolio,
		// Beli momogi 500 satu,
		// Ayam 50000 satu
		// Total 50500
		//<-

		SpringApplication.run(PosApplication.class, args);
		Employee el = new Employee();
		el.setId(1);
		el.setName("Michael Suyama");
		el.setBirdDate(LocalDate.of(1970,3,2));

		Employee e2 = new Employee();
		e2.setId(1);
		e2.setName("Nancy Davolio");
		e2.setBirdDate(LocalDate.of(1960,2,2));

		Product pl = new Product();
		pl.setId(1);
		pl.setName("Momogi");
		pl.setPrice(BigDecimal.valueOf(500));

		Product p2 = new Product();
		p2.setId(1);
		p2.setName("Pepsi");
		p2.setPrice(BigDecimal.valueOf(5000));

		Product p3 = new Product();
		p3.setId(1);
		p3.setName("Ayam");
		p3.setPrice(BigDecimal.valueOf(50000));

		Sale s1 = new Sale();
		s1.setLineItems(new ArrayList<>());
		//s1.setPrd(new ArrayList<>());
		s1.setId(1);
		s1.setTime(LocalDateTime.now());
		s1.setCasher(el);
		s1.addlineItems(pl,1);
		s1.addlineItems(p2,1);
//		s1.getPrd().add(pl);
//		s1.getPrd().add(p2);

		Sale s2 = new Sale();
		s2.setId(2);
		s2.setCasher(e2);

		System.out.println(s1.getCasher().getName()); // Ambil Nama Penjual pertama

		ArrayList<Employee> arrEmp = new ArrayList<>();
		arrEmp.add(el);
		arrEmp.add(e2);

		for (Employee n: arrEmp){
			System.out.println(n.getName());
		}
	}
}
