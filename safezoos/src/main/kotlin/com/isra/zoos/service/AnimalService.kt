package com.isra.zoos.service

import com.isra.zoos.views.CountAnimalsInZoos

interface AnimalService {

    fun delete(id: Long)
    fun getCountAnimalsInZoos(): MutableList<CountAnimalsInZoos>

}