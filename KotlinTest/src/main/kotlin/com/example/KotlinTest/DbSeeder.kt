package com.example.KotlinTest

import org.springframework.boot.CommandLineRunner
import org.springframework.data.repository.support.Repositories
import org.springframework.stereotype.Component

@Component
class DbSeeder(val sessionRepository: SessionRepository) : CommandLineRunner {
    override fun run(vararg p0: String?) {
        this.sessionRepository.deleteAll()

        val ABC123XYZ = Session("ABC123XYZ", "XYZ456ABC")
        val ABC123XYC = Session("ABC123XYC", "XYZ456ABD")

        val sessions = mutableListOf<Session>()
        sessions.add(ABC123XYZ)
        sessions.add(ABC123XYC)

        this.sessionRepository.saveAll(sessions)
        println(" -- Database has been initialized")
    }
}