package com.m19y.learn.app

import com.m19y.learn.data.SuperTeacher
import com.m19y.learn.data.Teacher

fun main() {

    // kotlin memiliki 4 visibility modifier
    // public       => semua bias menaksesnya
    // private      => hanya bisa diakses oleh internal class
    // protected    => hanya bisa diakses oleh turunan dari class
    // internal     => hanya bisa diakses oleh internal project
    // ! semua defaultnya public

    println("\nTeacher")
    val teacher = Teacher("Bro")
    teacher.teach()
    // teacher.sad() Tidak bisa diakses karena protected

    println("\nSuper Teacher")
    val superTeacher = SuperTeacher("Sis")
    superTeacher.teach()
    superTeacher.simpleEmotion()
    superTeacher.superEmotion()
}