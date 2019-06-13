package com.isra.zoos.controller

import com.isra.zoos.service.AnimalServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AnimalController(private val animalServiceImpl: AnimalServiceImpl) {

    @GetMapping("/animals/count")
    fun getCountAnimalsInZoos(): ResponseEntity<*> {
        return ResponseEntity(animalServiceImpl.getCountAnimalsInZoos(), HttpStatus.OK)
    }

}