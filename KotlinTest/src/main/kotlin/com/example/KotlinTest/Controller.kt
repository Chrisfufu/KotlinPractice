package com.example.KotlinTest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

/*
* This section is the first part of the sample log,
* I have a post method and a get method.
* Post method is to post a sessionId and userId that is shown in the Sample Log
*/
@RestController
@RequestMapping("/session")
class SessionController(val sessionRepository: SessionRepository){

    @GetMapping("/all")
    @Autowired
    fun all(): MutableIterable<Session> = this.sessionRepository.findAll()

    @PostMapping("/addSession")
    fun addSession(@RequestBody request: SessionRequest) {
        val userId = request.userId
        val sessionId = request.sessionId
        val session = Session(userId.toString(), sessionId.toString())
        this.sessionRepository.save(session)
    }

    @GetMapping("/{id}")
    fun byName(@PathVariable(value = "id") id: Long): Optional<Session> {
        val hotelsByName = this.sessionRepository.findById(id)
        return hotelsByName
    }
}

/*
* This section is the second part of the sample log,
* I have a post method and a get method.
* For post method
* action Entity has ManytoOne relationship to Session Entity.
* So I need to add session repository in the arguments
*/
@RestController
@RequestMapping("/action")
class ActionsController(val actionsRepository: ActionsRepository, val sessionRepository: SessionRepository){

    @GetMapping("/all")
    @Autowired
    fun all(): MutableIterable<Actions> = this.actionsRepository.findAll()

    @PostMapping("/addAction")
    fun addAction(@RequestBody request: ActionRequest) {
        val type = request.type

        val session= this.sessionRepository.findBySessionId(request.session)[0]
        val action = Actions(LocalDateTime.now(),type.toString(), session)
        this.actionsRepository.save(action)
    }
}

/*
* This section is the third part of the sample log,
* I have a post method and a get method.
* For post method
* property Entity has ManytoOne relationship to action Entity.
* So I need to add action repository in the arguments
*/
@RestController
@RequestMapping("/properties")
class PropertiesController(val actionsRepository: ActionsRepository, val propertiesRepository: PropertiesRepository){
    @GetMapping("/all")
    fun all(): MutableIterable<Properties> = this.propertiesRepository.findAll()

    @PostMapping("/addProperty")
    fun addProperty(@RequestBody request: PropertyRequest) {
        var locationX: Int? = request.locationX
        var locationY: Int? = request.locationY
        var viewedId: String? = request.viewedId
        var pageFrom: String? = request.pageFrom
        var pageTo: String? = request.pageTo

        val actionId= this.actionsRepository.findById(request.actionId)[0]
        val properties = Properties(locationX, locationY, viewedId, pageFrom, pageTo, actionId)
        this.propertiesRepository.save(properties)
    }
}