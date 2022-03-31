package com.qehuddle.repository;

import java.util.List;

import com.qehuddle.controller.Library;

public interface LibraryRepositoryCustom {
	List<Library> findAllByAuthor(String authorname);

}
