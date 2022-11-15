package com.github.ericomonteiro.graphql.model

import java.time.LocalDate
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Book(
    @Id
    val isbn: String,
    val title: String,
    val publisher: String,
    @ElementCollection
    val authors: List<String>,
    val publishedDate: LocalDate
)