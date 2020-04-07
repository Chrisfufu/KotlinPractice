package com.example.KotlinTest

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

/*
* In this entity file, I had experienced a bug, where I want to add a new action to a Session,
* it always self referring itself, which means that it has the infinite depth when fetching.
* I searched online, the result would be adding @JsonIgnore to ManyToOne relationship, then
* the problem is solved.
*/

/*
* Actions entity is the second layer. it has multiple children of Properties.
*/
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

/*
* Session entity is the first layer. it has multiple children of Actions.
*/
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

/*
* Session entity is the third layer. it has many to one relationship to actions.
*/
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