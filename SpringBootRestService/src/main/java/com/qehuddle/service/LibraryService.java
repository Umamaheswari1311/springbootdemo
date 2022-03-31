package com.qehuddle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qehuddle.controller.Library;
import com.qehuddle.repository.LibraryRepository;
@Service
public class LibraryService {
	@Autowired
	LibraryRepository rep;
	
	public String buildId(String isbn,int i)
	{
		if(isbn.startsWith("c"))
		{
			return "OLD"+isbn+i;
		}
		return isbn+i;
		
	}
	public boolean checkBookAlreadyExist(String id)
	{
		Optional<Library> lib=rep.findById(id);
		
		if(lib.isPresent())
		{
		return true;
		}
		return false;
			
	}

}
