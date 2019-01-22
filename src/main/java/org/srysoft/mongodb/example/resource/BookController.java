package org.srysoft.mongodb.example.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.srysoft.mongodb.example.model.Book;
import org.srysoft.mongodb.example.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/books")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added book with id : [" + book.getId() + "]";
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		//List<Book> books = new ArrayList<Book>();
		//Book book = bookRepository.findByName("Java");		
		//books.add(book);
		//return books;
				
		return bookRepository.findAll();		
	}

	@GetMapping("/books/{bookId}")
	public Optional<Book> getBook(@PathVariable("bookId") int id) {
		return bookRepository.findById(id);
	}

	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable("bookId") int id) {
		bookRepository.deleteById(id);
		return "Deleted book with id : [" + id + "]";
	}

	@PutMapping("/books/{bookId}")
	public String updateBook(@PathVariable("bookId") int id, @RequestBody Book book) {
		bookRepository.save(book);
		return "Update book with id :[" + book.getId() + "]";
	}
}
