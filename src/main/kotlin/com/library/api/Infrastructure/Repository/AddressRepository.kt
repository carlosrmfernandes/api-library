package com.library.api.Infrastructure.Repository

import com.library.api.Domain.Entities.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, Long>{
}



