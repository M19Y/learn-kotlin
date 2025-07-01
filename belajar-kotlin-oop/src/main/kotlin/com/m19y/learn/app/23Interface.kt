package com.m19y.learn.app

import com.m19y.learn.data.Human
import com.m19y.learn.data.Interaction

fun main() {

    val interaction: Interaction = Human("Bro")
    println(interaction.name)
    interaction.sayHello("Sis")
    interaction.sayMorning("Unc")

    val human: Human = Human("Sis")
    human.move()
}