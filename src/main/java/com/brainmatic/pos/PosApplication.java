package com.brainmatic.pos;

import com.brainmatic.pos.core.*;
import com.brainmatic.pos.core.entity.Employee;
import com.brainmatic.pos.core.entity.Product;
import com.brainmatic.pos.core.entity.Sale;
import com.brainmatic.pos.core.entity.SaleLineItem;
import com.brainmatic.pos.core.entity.repo.entityrepo.ProductRepo;
import com.brainmatic.pos.infra.data.jdbc.EmployeeJdbcRepo;
import com.brainmatic.pos.infra.data.jdbc.ProductJdbcRepo;
import com.brainmatic.pos.infra.data.jdbc.SaleJdbcRepo;
import com.brainmatic.pos.infra.data.mongodb.ProductMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void run(String... strings) throws Exception{
		//initDb();
		//jdbcTemplate.execute("CREATE TABLE Employee (id int primary key, name varchar (100))");
		//jdbcTemplate.execute("INSERT INTO Employee (id , name ) values (1,'Michael Suyama')");
		//jdbcTemplate.execute("INSERT INTO Employee (id , name ) values (2,'Nancy Davolio')");
		//jdbcTemplate.execute("INSERT INTO Employee (id , name ) values (3,'Janet Leverling')");
//		List<Employee> empl = jdbcTemplate.query("SELECT id, name from Employee where id=?", new Object[]{1}, (rs, rowNum) -> {
//			Employee e = new Employee();
//			e.setId(rs.getInt("id"));
//			e.setName(rs.getString("name"));
//			return e;
//		});

//		for (Employee e:empl){
//			System.out.println(e.getName());
//		}

//		List<Employee> empl2 = jdbcTemplate.query("SELECT * from Employee ", (rs, rowNum) -> {
//			Employee f = new Employee();
//			f.setId(rs.getInt("id"));
//			f.setName(rs.getString("name"));
//			return f;
//		});

//		for (Employee e:empl2){
//			System.out.println("SELECT ALL =" + e.getName());
//		}
//        ProductJdbcRepo repo = new ProductJdbcRepo(jdbc);

       // Product p = repo.getAll();
//        for (Product x : repo.getAll()){
//            System.out.println(x.getName());
//        }
//        System.out.println(repo.getCount());
        //System.out.println(p.getName());

//        SaleJdbcRepo repoSale = new SaleJdbcRepo(jdbc);
//        Sale s = repoSale.getById(1);
//        for (SaleLineItem sli : s.getLineItems()) {
//            System.out.println(sli.getQuantity());
//        }
//
//        Sale s1 = repoSale.getByIdEager(1);
//        for (SaleLineItem sli : s1.getLineItems()) {
//            System.out.println(sli.getProduct().getName());
//        }

	}
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

		List<Product> prods = repo.getAll();
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


	public void initDb() {
		EmployeeJdbcRepo employerepo = new EmployeeJdbcRepo(jdbc);
		Employee  employee1 = employerepo.getById(1);
		Employee  employee2 = employerepo.getById(2);
		Employee  employee3 = employerepo.getById(3);

		ProductJdbcRepo productrepo = new ProductJdbcRepo(jdbc);
		Product product1 = productrepo.getById(1);
		Product product2 = productrepo.getById(2);
		Product product3 = productrepo.getById(3);

		SaleJdbcRepo selarepo = new SaleJdbcRepo(jdbc);
		Sale sale1 = selarepo.getById(1);

		sale1.setCasher(employee1);
		sale1.addlineItems(product1,4);

		SaleJdbcRepo saleJRepo = new SaleJdbcRepo(jdbc);
		saleJRepo.save(sale1);
		System.out.println("BERHASIL COY");


	}
}
