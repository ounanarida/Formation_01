package fr.randstaddigital.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.randstaddigital.BookStore.entities.Book;

public interface  BookRepository extends JpaRepository<Book, Long>{

}
