package com.example.KotlinTest

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Actions(
        var time: LocalDateTime = LocalDateTime.now(),
        var type: String,

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "session_id")
        val session: Session? = null
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "actions")
    val properties = mutableListOf<Properties>()
}

@Entity
class Session(
        var userId: String,
        var sessionId: String
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "session")
    val actions = mutableListOf<Actions>()
}

@Entity
class Properties(
        var locationX: Int? = null,
        var locationY: Int? = null,
        var viewedId: String? = null,
        var pageFrom: String? = null,
        var pageTo: String? = null,

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "action_id")
        val actions: Actions
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}