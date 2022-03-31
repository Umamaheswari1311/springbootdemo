package com.qehuddle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.qehuddle.controller.Library;
import com.qehuddle.controller.LibraryController;
import com.qehuddle.service.LibraryService;

@SpringBootTest

class SpringBootRestServiceApplicationTests {
@Autowired
LibraryService service;
@Autowired
LibraryController libCon;
	@Test
	void contextLoads() {
	}
	
    @Test
    public void checkBuildId()
    {
    	String id=service.buildId("check", 45);
    	assertEquals(id,"check45");	
    }
    @Test
    public void addBookTest()
    {
    	ResponseEntity reponse=libCon.addBookImplementation(buildLibrary());
    }
    public Library buildLibrary()
    {
    	Library lib=new Library();
    	lib.setAisle(322);
    	lib.setBook_name("Testing");
    	lib.setIsbn("sert");
    	lib.setAuthor("uma");
    	lib.setId("sert322");
		return lib;
    	
    }
}
