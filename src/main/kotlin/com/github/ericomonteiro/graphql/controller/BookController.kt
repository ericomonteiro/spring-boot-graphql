package com.github.ericomonteiro.graphql.controller

import com.github.ericomonteiro.graphql.model.Book
import com.github.ericomonteiro.graphql.service.BookCrudService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.time.LocalDate

@Controller
class BookController(
    private val bookCrudService: BookCrudService
) {

    @QueryMapping
    fun getBook(@Argument isbn: String): Book = bookCrudService.getBook(isbn = isbn)!!

    @QueryMapping
    fun getAllBooks(): List<Book> = bookCrudService.getAllBooks()

    @MutationMapping
    fun addBook(
        @Argument isbn: String,
        @Argument title: String,
        @Argument publisher: String,
        @Argument author: String,
    ): Book {
        val book = Book(
            isbn = isbn,
            title = title,
            publisher = publisher,
            authors = arrayListOf(author),
            LocalDate.now()
        )

        return bookCrudService.addBook(book)
    }

    @MutationMapping
    fun deleteBook(@Argument isbn: String): String {
        bookCrudService.deleteBook(isbn)
        return "Book deleted"
    }

}