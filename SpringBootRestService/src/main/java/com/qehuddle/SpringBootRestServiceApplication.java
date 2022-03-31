package com.qehuddle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qehuddle.controller.Library;
import com.qehuddle.repository.LibraryRepository;

@SpringBootApplication
public class SpringBootRestServiceApplication implements CommandLineRunner {
@Autowired
LibraryRepository rep;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceApplication.class, args);
	}
@Override
public void run(String[] arg)
{
//	Library lib= rep.findById("dsddfs343").get();
//	
//	//Retrive data fro DB
//	System.out.println(lib.getAuthor());
//	Library entity = new Library(); 
//	entity.setAisle(123);
//	entity.setAuthor("San");
//	entity.setBook_name("AWS");
//	entity.setIsbn("hai");
//	entity.setId("hai123");
//	//rep.save(entity);
//	rep.delete(entity);
//	List<Library> records=rep.findAll();
//	
//	for (int i=0;i<records.size();i++)
//	{
//		System.out.println(records.get(i).getBook_name());
//	}
//	
}
}
