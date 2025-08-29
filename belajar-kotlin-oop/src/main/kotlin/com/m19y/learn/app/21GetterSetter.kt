package com.m19y.learn.app

import com.m19y.learn.data.BigNote
import com.m19y.learn.data.Note

fun main() {

    val note = Note("Bro")
    println(note.name)
    note.name = "Sis"
    println(note.name)
    note.name = "" // ignore
    println(note.name)

    val bigNote = BigNote("Simple Big")
    println(bigNote.bigTitle)

}