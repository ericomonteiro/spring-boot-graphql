package com.github.ericomonteiro.graphql.service

import com.github.ericomonteiro.graphql.extension.toNullable
import com.github.ericomonteiro.graphql.model.Book
import com.github.ericomonteiro.graphql.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookCrudService(
    private val bookRepository: BookRepository
) {

    fun getBook(isbn: String): Book? = bookRepository.findById(isbn).toNullable()

    fun getAllBooks(): List<Book> = bookRepository.findAll()

    fun addBook(book: Book): Book = bookRepository.save(book)

    fun deleteBook(isbn: String) = bookRepository.deleteById(isbn)

}