package com.library.api.Domain.Entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

import javax.*
import org.aspectj.util.FileUtil.ALL


@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @OneToMany(mappedBy = "author")
    var books: List<Book>? = mutableListOf(),

    @OneToMany(mappedBy = "author")
    var address: List<Address>? = arrayListOf(),
){
    companion object {
        fun fromDomain(author: Author): Author {
            return Author(
                id = author.id,
                name = author.name,
                books = author.books?.map { Book.toDomain(it) }
            )
        }
    }
}


