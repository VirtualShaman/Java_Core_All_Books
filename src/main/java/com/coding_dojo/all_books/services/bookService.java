package com.coding_dojo.all_books.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.coding_dojo.all_books.models.bookModel;
import com.coding_dojo.all_books.repositories.bookRepository;

@Service
public class bookService {
 // adding the book repository as a dependency
	private final bookRepository repository;
 
 public bookService(bookRepository repository) {
     this.repository = repository;
 }
 // returns all the books
 public List<bookModel> allBooks() {
     return repository.findAll();
 }
 // creates a book
 public bookModel createBook(bookModel b) {
     return repository.save(b);
 }
 // retrieves a book
 public bookModel findBook(Long id) {
     Optional<bookModel> optionalBook = repository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
public bookModel updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	bookModel book = new bookModel(title, desc, lang, numOfPages);
	book.setId(id);
	repository.save(book);
	return null;
}
public void deleteBook(Long id) {
	repository.deleteById(id);
	
}
}


