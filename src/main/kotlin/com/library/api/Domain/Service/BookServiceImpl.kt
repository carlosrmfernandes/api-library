package com.library.api.Domain.Service

import com.library.api.Domain.Entities.Author
import com.library.api.Domain.Entities.Book
import com.library.api.Domain.DTOs.Request.AuthorRequestDto
import com.library.api.Domain.Exception.AddressNotFoundException
import com.library.api.Infrastructure.Repository.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookServiceImpl(
    val bookRepository: BookRepository
) : BookServiceInterface {
    override fun saveAll(authorRequestDto: AuthorRequestDto, author: Author): MutableIterable<Book> {
        val books: List<Book> = authorRequestDto.books.map { dto ->
              return@map Book(
                    description = dto.description,
                    author = author
                )

        }
        return bookRepository.saveAll(books)
    }

    override fun findById(id: Long): Book {
        val book = bookRepository.findById(id).orElseThrow {
            AddressNotFoundException("Book not found")
        }
        return Book.toDomain(book);
    }
}