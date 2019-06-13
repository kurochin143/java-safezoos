package com.isra.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "zoos")
class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var zooid: Long = 0

    var zooname: String? = null

    @OneToMany(mappedBy = "zoo", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["zoos"])
    var telephones: List<Telephone> = ArrayList()

    @ManyToMany
    @JoinTable(name = "zooanimals",
            joinColumns = [JoinColumn(name = "zooid")],
            inverseJoinColumns = [JoinColumn(name = "animalid")])
    @JsonIgnoreProperties(value = ["zoos"])
    var animals: List<Animal> = ArrayList()

    constructor()

    constructor(name: String?) {
        this.zooname = name
    }


}