package com.isra.zoos.repository

import com.isra.zoos.model.Telephone
import org.springframework.data.repository.CrudRepository

interface TelephoneRepository : CrudRepository<Telephone, Long>