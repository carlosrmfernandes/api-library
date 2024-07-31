package com.library.api.Infrastructure.Repository

import com.library.api.Domain.Entities.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
}