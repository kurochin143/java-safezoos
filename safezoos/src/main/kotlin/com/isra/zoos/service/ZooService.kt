package com.isra.zoos.service

import com.isra.zoos.model.Zoo

interface ZooService {

    fun findAll(): MutableList<Zoo>
    fun findById(id: Long): Zoo
    fun update(zoo: Zoo, id: Long): Zoo
    fun save(zoo: Zoo): Zoo
    fun delete(id: Long)

}