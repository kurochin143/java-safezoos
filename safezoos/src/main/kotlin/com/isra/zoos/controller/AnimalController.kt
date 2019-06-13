package com.isra.zoos.controller

import com.isra.zoos.model.Role
import com.isra.zoos.service.AnimalServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AnimalController(private val animalServiceImpl: AnimalServiceImpl) {

    @PreAuthorize("hasAuthority('"+Role.ROLE_ADMIN+"') or hasAuthority('"+Role.ROLE_ANIMALDATA+"')")
    @GetMapping("/animals/count")
    fun getCountAnimalsInZoos(): ResponseEntity<*> {
        return ResponseEntity(animalServiceImpl.getCountAnimalsInZoos(), HttpStatus.OK)
    }

}