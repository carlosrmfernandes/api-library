package com.library.api.Domain.Service

import com.library.api.Domain.Entities.Author
import com.library.api.Domain.DTOs.Request.AuthorRequestDto
import com.library.api.Domain.Entities.Book
import com.library.api.Domain.Exception.UserNotFoundException
import com.library.api.Infrastructure.Repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    val authorRepository: AuthorRepository,
    val bookServiceInterface: BookServiceInterface
) : AuthorServiceInterface {
    override fun save(authorRequestDto: AuthorRequestDto): Author {

        val author: Author = authorRepository.save(
            Author(
                name = authorRequestDto.name,
            )
        )
        if (author.id != null) {
            val book: MutableIterable<Book> = bookServiceInterface.saveAll(authorRequestDto, author)
            author.books = book.toList();
        }
        return Author.fromDomain(author);
    }

    override fun findById(id: Long): Author {
        val author: Author =
            authorRepository.findById(id).orElseThrow { UserNotFoundException("User not found with id $id") }
        return Author.fromDomain(author);
    }

    override fun findByName(names: String): List<Author> {
        return authorRepository.findByName(names)
    }

    override fun getAuthorsByBooks(id: Long): Author {
        val authorWithBook: Author = authorRepository.getAuthorsByBooks(id).orElseThrow {
            UserNotFoundException("User not found with id $id")
        };
        return Author.fromDomain(authorWithBook)
    }
}