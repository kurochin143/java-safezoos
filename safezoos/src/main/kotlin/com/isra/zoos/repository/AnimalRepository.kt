package com.isra.zoos.repository

import com.isra.zoos.model.Animal
import com.isra.zoos.views.CountAnimalsInZoos
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AnimalRepository : CrudRepository<Animal, Long> {

//    SELECT za.animalid, animaltype, COUNT(za.zooid) as countzoos
//    FROM zooanimals za
//    INNER JOIN animals a
//    ON za.animalid = a.animalid
//    GROUP BY za.animalid, a.animaltype

    // nativeQuery = true, because zooanimals is a generated table
    @Query("SELECT za.animalid, animaltype, COUNT(za.zooid) as countzoos FROM zooanimals za INNER JOIN animals a ON za.animalid = a.animalid GROUP BY za.animalid, a.animaltype", nativeQuery = true)
    fun getCountAnimalsInZoos(): MutableList<CountAnimalsInZoos>

//    DELETE
//    FROM zooanimals
//    WHERE animalid =

    @Modifying
    @Query("DELETE FROM zooanimals WHERE animalid = :animalid", nativeQuery = true)
    fun deleteAnimalsFromZooanimals(animalid: Long)


}