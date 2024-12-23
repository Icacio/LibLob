package com.example.LibLob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String title;
	public String author;
	public String isbn;

	public Book (String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	public Book () {}

	@Override
	public String toString() {
		return "Book{id=" + id + ", title='" + title + "', author='" + author + "', isbn='" + isbn + "'}";
	}

	public void setId(Long id2) {
		id = id2.longValue();
	}
}
