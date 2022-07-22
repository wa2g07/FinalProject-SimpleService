package com.example.simpleservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SimpleServiceApplication

fun main(args: Array<String>) {
    runApplication<SimpleServiceApplication>(*args)
}

@Configuration
@ConfigurationProperties("controller")
class ControllerProperties(){
    lateinit val msg:String
}

@RestController
class MainController(val controllerProperties: ControllerProperties){

    @GetMapping("/api/hello")
    fun hello(): String{
        return controllerProperties.msg
    }
}