package com.example.LibLob.service;

import com.example.LibLob.model.Book;
import com.example.LibLob.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	public Book updateBook(Long id, Book book) {
		if (!bookRepository.existsById(id)) {
			return null;
		}
		book.setId(id);
		return bookRepository.save(book);
	}
	public boolean deleteBook(Long id) {
		if (!bookRepository.existsById(id)) {
			return false;
		}
		bookRepository.deleteById(id);
		return true;
	}
}
