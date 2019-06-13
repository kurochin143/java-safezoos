package com.isra.zoos.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "telephones")
class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var phoneid: Long = 0

    var phonetype: String? = null
    var phonenumber: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zooid", nullable = false)
    @JsonIgnoreProperties("telephones")
    var zoo: Zoo? = null

    constructor()

    constructor(phonetype: String?, phonenumber: String?, zoo: Zoo?) {
        this.phonetype = phonetype
        this.phonenumber = phonenumber
        this.zoo = zoo
    }


}