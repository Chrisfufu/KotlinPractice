package com.example.KotlinTest

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/*
* it has two methods,
* 1. find by sessionId
* 2. find by Id, this is not in use.
* return: list of sessions
*/
@Repository
interface SessionRepository : CrudRepository<Session, Long> {
    fun findBySessionId(sessionId: String?): List<Session>
    fun findById(id: Long?): List<Session>
}

/*
* it has two methods,
* 1. find by type, this is not in use.
* 2. find by Id.
* return: list of Actions
*/
@Repository
interface ActionsRepository : CrudRepository<Actions, Long> {
    fun findByType(type: String?): List<Actions>
    fun findById(id: Long?): List<Actions>
}
/*
* it does not have any method because property is the third part
* of the sample log. It does not have child.
*/
@Repository
interface PropertiesRepository : CrudRepository<Properties, Long> {}