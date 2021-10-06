package com.coding_dojo.all_books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding_dojo.all_books.models.bookModel;

//...
@Repository
public interface bookRepository extends CrudRepository<bookModel, Long>{
 // this method retrieves all the books from the database
 List<bookModel> findAll();
 // this method finds books with descriptions containing the search string
 List<bookModel> findByDescriptionContaining(String search);
 // this method counts how many titles contain a certain string
 Long countByTitleContaining(String search);
 // this method deletes a book that starts with a specific title
 Long deleteByTitleStartingWith(String search);
}


