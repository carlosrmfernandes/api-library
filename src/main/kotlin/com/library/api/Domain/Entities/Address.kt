package com.library.api.Domain.Entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Table(name = "address")
@Entity
data class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id: Long? = null,

    @Column(name = "cep", nullable = false)
    var cep: String? = null,

    @Column(name = "neighborhood", nullable = false)
    var neighborhood: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: Author? = null
){
    companion object {
        fun fromDomain(address: Address): Address{
            return Address(
                id = address.id,
                cep = address.cep,
                neighborhood = address.neighborhood,
                author = address.author
            )
        }
    }
}