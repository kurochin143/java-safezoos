package com.isra.zoos.service

import com.isra.zoos.model.Telephone
import com.isra.zoos.model.Zoo
import com.isra.zoos.repository.ZooRepository
import com.isra.zoos.views.CountAnimalsInZoos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
class ZooServiceImpl : ZooService {

    @Autowired
    lateinit var zooRepository: ZooRepository

    override fun findAll(): MutableList<Zoo> {
        val outZoos = mutableListOf<Zoo>()
        zooRepository.findAll().toCollection(outZoos)
        return outZoos
    }

    override fun findById(id: Long): Zoo {
        return zooRepository.findById(id)
                .orElseThrow { EntityNotFoundException("Zoo id $id cannot be found!") }
    }

    @Transactional
    override fun update(zoo: Zoo, id: Long): Zoo {
        val currentZoo = zooRepository.findById(id)
                .orElseThrow { EntityNotFoundException("Zoo id $id cannot be found!") }

        if (zoo.zooname != null) currentZoo.zooname = zoo.zooname

        return zooRepository.save(currentZoo)
    }

    override fun save(zoo: Zoo): Zoo {
        val newZoo = Zoo(zoo.zooname)

        val newTelephones = mutableListOf<Telephone>()
        zoo.telephones.forEach {
            newTelephones.add(Telephone(it.phonetype, it.phonenumber, newZoo))
        }
        newZoo.telephones = newTelephones

        return zooRepository.save(newZoo)
    }

    @Transactional
    override fun delete(id: Long) {
        if (zooRepository.existsById(id)) {
            zooRepository.deleteZooFromZooanimals(id)
            zooRepository.deleteById(id)
        } else {
            throw EntityNotFoundException("Zoo id $id cannot be found!")
        }

    }

}