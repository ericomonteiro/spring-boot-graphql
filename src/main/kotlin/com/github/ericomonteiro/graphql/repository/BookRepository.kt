package com.github.ericomonteiro.graphql.repository

import com.github.ericomonteiro.graphql.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, String>