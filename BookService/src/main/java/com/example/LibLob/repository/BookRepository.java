package com.example.LibLob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibLob.model.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

}
