package com.library.api.Infrastructure.Repository

import com.library.api.Domain.Entities.Author
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface AuthorRepository : CrudRepository<Author, Long>{

    fun findByName(name:String): List<Author>

 @Query(value = "SELECT authors.id as id_author, authors.name as name_author, books.id as id_book, books.description as description_book, books.author_id as book_author_id FROM authors LEFT JOIN books ON authors.id = books.author_id WHERE authors.id = :id", nativeQuery = true)
    fun getAuthorsByBooks(@Param("id") id: Long): Optional<Author>
}



