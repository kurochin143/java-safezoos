package com.isra.zoos.controller

import com.isra.zoos.model.Zoo
import com.isra.zoos.service.ZooServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class ZooController(private val zooServiceImpl: ZooServiceImpl) {

    @GetMapping("/zoos/zoos")
    fun getZoos(): ResponseEntity<*> {
        return ResponseEntity(zooServiceImpl.findAll(), HttpStatus.OK)
    }

    @PutMapping("/admin/zoos/{id}")
    fun updateZoo(@RequestBody zoo: Zoo, @PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(zooServiceImpl.update(zoo, id), HttpStatus.OK)
    }

    @PostMapping("/admin/zoos")
    fun addZoo(@RequestBody zoo: Zoo): ResponseEntity<*> {
        return ResponseEntity(zooServiceImpl.save(zoo), HttpStatus.OK)
    }

    @DeleteMapping("/admin/zoos/{id}")
    fun deleteZoo(@PathVariable("id") id: Long): ResponseEntity<*> {
        zooServiceImpl.delete(id)

        return ResponseEntity("""{"message":"Zoo id $id deleted"}""", HttpStatus.OK)
    }

    @GetMapping("/zoos/zoos/{id}")
    fun getZooById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(zooServiceImpl.findById(id), HttpStatus.OK)
    }

}