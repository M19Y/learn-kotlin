package com.m19y.service

import com.m19y.model.Person
import com.m19y.repository.PersonRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension


@Extensions(
    value = [
        ExtendWith(MockitoExtension::class)
    ]
)
class MockingPersonServiceTest {

    @Mock
    lateinit var personRepository: PersonRepository

    lateinit var personService: PersonService

    @BeforeEach
    fun setUp() {
        personService = PersonService(personRepository)
    }

    @Test
    fun `Throw IllegalArgumentException when id is blank`() {
        // java Assertions
        Assertions.assertThrows<IllegalArgumentException>(IllegalArgumentException::class.java) {
            personService.get("        ")
        }
    }

    @Test
    fun `Success get person when id is valid`() {
        Mockito.`when`<Person>(
            personRepository.selectById("bro")
        ).thenReturn(Person("Pemerintah", "bro"))

        val person: Person = personService.get("bro")

        Assertions.assertEquals("Pemerintah", person.name)
        Assertions.assertEquals("bro", person.id)

        // Memastikan bahwa selectById itu di panggil
        Mockito.verify<PersonRepository>(
            personRepository,
            Mockito.times(1)
        ).selectById("bro")
    }

    @Test
    fun `Throw Exception when id is not exists`() {
        // kotlin assertions
        val message = assertThrows<Exception> {
            personService.get("Noting")
        }.message

        Assertions.assertEquals("Person was not found!", message)
    }

    @Test
    fun `Throw IllegalArgumentException when name is blank or empty`() {
        val message = assertThrows<IllegalArgumentException> {
            personService.register("")
        }.message

        Assertions.assertEquals("Invalid person name!", message)
    }

    @Test
    fun `Success register a new person, with verifying method insert`() {

        val registeredPerson = personService.register("Uncle")

        Assertions.assertEquals("Uncle", registeredPerson.name)
        Assertions.assertNotNull(registeredPerson.id)

        Mockito.verify<PersonRepository>(
            personRepository,
            Mockito.times(1)
        ).insert(Person("Uncle", registeredPerson.id))

    }
}