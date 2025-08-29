package com.m19y.repository

import com.m19y.model.Person

interface PersonRepository {

    fun selectById(id: String): Person?
    fun insert(person: Person)
}