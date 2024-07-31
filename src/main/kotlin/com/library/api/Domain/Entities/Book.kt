package com.library.api.Domain.Entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Table(name = "books")
@Entity
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id: Long? = null,

    @Column(name = "description", nullable = false)
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: Author? = null
){
    companion object {
        fun toDomain(book: Book): Book{
            return Book(
                id = book.id,
                description = book.description,
            )
        }
    }
}