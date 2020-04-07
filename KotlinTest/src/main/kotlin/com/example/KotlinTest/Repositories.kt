package com.example.KotlinTest

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface SessionRepository : CrudRepository<Session, Long> {
    fun findBySessionId(sessionId: String?): List<Session>
    fun findById(id: Long?): List<Session>
}

@Repository
interface ActionsRepository : CrudRepository<Actions, Long> {
    fun findByType(type: String?): List<Actions>
    fun findById(id: Long?): List<Actions>
}

@Repository
interface PropertiesRepository : CrudRepository<Properties, Long> {
}