package com.isra.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "animals")
class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var animalid: Long = 0

    var animaltype: String? = null

    @ManyToMany(mappedBy = "animals")
    @JsonIgnoreProperties(value = ["animals"])
    var zoos: List<Zoo> = ArrayList()

    constructor()

    constructor(animaltype: String?) {
        this.animaltype = animaltype
    }


}