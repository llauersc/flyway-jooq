package co.cantina.springjooq.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.cantina.springjooq.services.BookService;
import lombok.AllArgsConstructor;
import co.cantina.springjooq.domain.Book;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ApiController {

	private final BookService bookService;

	@GetMapping(value = "/books", produces = "application/json")
	@ResponseBody
	public List<Book> getBooks() {
		return this.bookService.getBooks();
	}

}