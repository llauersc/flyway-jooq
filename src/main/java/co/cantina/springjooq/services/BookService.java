package co.cantina.springjooq.services;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.cantina.spring.jooq.sample.model.Tables;

import co.cantina.springjooq.domain.Book;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

	private final ModelMapper mapper;
	private final DSLContext dsl;

	public List<Book> getBooks() {
		return dsl
				.selectFrom(Tables.BOOKS)
				.fetch()
				.stream()
				.map(e -> mapper.map(e, Book.class))
				.collect(Collectors.toList());
	}
}
