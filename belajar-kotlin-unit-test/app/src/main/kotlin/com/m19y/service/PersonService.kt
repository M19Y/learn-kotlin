package com.m19y.service

import com.m19y.model.Person
import com.m19y.repository.PersonRepository
import java.util.UUID

class PersonService(val personRepository: PersonRepository){

    fun get(id: String) : Person {
        if(id.isBlank()) throw IllegalArgumentException("Person id is not valid!")

        val person: Person? = personRepository.selectById(id)

        if(person != null){
            return person
        }else{
            throw Exception("Person was not found!")
        }
    }

    fun register(name: String): Person{
        if(name.isBlank() || name.isEmpty()) throw IllegalArgumentException("Invalid person name!")
        val person = Person(name, UUID.randomUUID().toString())
        personRepository.insert(person)
        return person
    }

}