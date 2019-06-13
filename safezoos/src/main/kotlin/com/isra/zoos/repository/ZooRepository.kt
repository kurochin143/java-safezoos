package com.isra.zoos.repository

import com.isra.zoos.model.Zoo
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ZooRepository : CrudRepository<Zoo, Long> {

    @Modifying
    @Query("DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    fun deleteZooFromZooanimals(zooid: Long)

}