package com.isra.zoos.service

import com.isra.zoos.repository.AnimalRepository
import com.isra.zoos.views.CountAnimalsInZoos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class AnimalServiceImpl : AnimalService{

    @Autowired
    lateinit var animalRepository: AnimalRepository

    override fun delete(id: Long) {

        if (animalRepository.existsById(id)) {
            animalRepository.deleteAnimalsFromZooanimals(id) // delete from zooanimals table
            animalRepository.deleteById(id) // delete from animals table
        } else {
            throw EntityNotFoundException("Animal id $id cannot be found!")
        }
    }

    override fun getCountAnimalsInZoos(): MutableList<CountAnimalsInZoos> {
        return animalRepository.getCountAnimalsInZoos()
    }

}