package com.m19y.mockito

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MockingTest {


    @Test
    fun listMockTest() {

        // create mock object
        @Suppress("UNCHECKED_CAST")
        val listMock: List<String> = Mockito.mock(List::class.java) as List<String>

        // menambahkan behaviour di mock object
        Mockito.`when`<String>(listMock.get(0)).thenReturn("Bro")
        Mockito.`when`<String>(listMock.get(1)).thenReturn("Sis")

        // test mock
        Assertions.assertEquals("Bro", listMock.get(0))

        // verify mock
        Mockito.verify(listMock, Mockito.times(1)).get(0)
        Mockito.verify(listMock).get(0)


        listMock.get(1)
        listMock.get(1)

        Mockito.verify(listMock, Mockito.times(2)).get(1)

    }
}