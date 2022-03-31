package com.qehuddle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.qehuddle.repository.LibraryRepository;
import com.qehuddle.service.LibraryService;

@RestController
public class LibraryController {
	@Autowired
	LibraryRepository rep;
	@Autowired
	LibraryResponse add;
	@Autowired
	LibraryService service;
	//Logger is static and we can call logger method using classname
	private static final Logger logger=LoggerFactory.getLogger(LibraryController.class);
	@PostMapping("/addBook")
	public ResponseEntity addBookImplementation(@RequestBody Library lib)
	{	
		String id=service.buildId(lib.getIsbn(),lib.getAisle());//mock
		if(!service.checkBookAlreadyExist(id))//mock
		{
			logger.info("Create New Entry of Book details");
		lib.setId(id);
		rep.save(lib);
		HttpHeaders head=new HttpHeaders();
		head.add("unique", id);
		add.setMsg("Book is added sucessfully" );
		add.setId(id);	
		return  new ResponseEntity<LibraryResponse>(add,head,HttpStatus.CREATED);
	    }
	   else
		{
		   logger.info("Book is already exist with same id");
			add.setMsg("Book is already Exist" );
			add.setId(id);	
			return  new ResponseEntity<LibraryResponse>(add,HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/getBooks")
	public List<Library> getBookById()
	{
		try {
			 logger.info("Fetch all Available Books details");
		List<Library> lib=rep.findAll();
	    return lib;	
		}
		catch(Exception e)
		{
			 logger.info("Empty Book details");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/getBooks/{id}")
	public Library getBookById(@PathVariable(value="id")String id)
	{
		try {
			 logger.info("Get Book by id "+ id);
		Library lib=rep.findById(id).get();
	    return lib;	
		}
		catch(Exception e)
		{
			logger.info("Not avle to found Book by id "+ id);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/getBooks/author")
	public  List<Library> getBookByAuthor(@RequestParam(value="authorname")String authorname)
	{
		try
		{
			logger.info("Get Book by author name "+ authorname);
		return rep.findAllByAuthor(authorname);
		}	
		
		catch(Exception e)
		{
			logger.info("Not able to found Book by author name "+ authorname);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<LibraryResponse> updateBook(@PathVariable(value="id")String id,@RequestBody Library lib)
	{
		logger.info("Update Book details by id "+ id);
		Library existing=rep.findById(id).get();
		existing.setAisle(lib.getAisle());
		existing.setAuthor(lib.getAuthor());
		existing.setBook_name(lib.getBook_name());
		rep.save(existing);
		add.setMsg("Book is Updated sucessfully" );
		add.setId(id);
	    return new ResponseEntity<LibraryResponse>(add,HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable(value="id")String id,@RequestBody Library lib)
	{
		logger.info("Delete Book by id "+ id);
		Library del=rep.findById(lib.getId()).get();
		rep.delete(del);
	    return new ResponseEntity<>("Book is Deleted sucessfully",HttpStatus.CREATED);
}
}