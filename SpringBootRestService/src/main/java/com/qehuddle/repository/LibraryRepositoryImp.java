package com.qehuddle.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qehuddle.controller.Library;

public class LibraryRepositoryImp implements LibraryRepositoryCustom{
@Autowired
LibraryRepository rep;
	@Override
	public List<Library> findAllByAuthor(String authorname) {
		List<Library>booksWithAuthor=new ArrayList<Library>();
		List<Library> books=rep.findAll();
		for(Library item:books)
		{
			if(item.getAuthor().equalsIgnoreCase(authorname))
			{
				booksWithAuthor.add(item);
			}
		}
		return booksWithAuthor;
	}

}
