package com.m19y.learn.data

public open class Teacher(public val name:String) {
    public fun teach() = println("teach!")
    private fun angry() = println("Angry!")
    protected open fun sad() = println("Sad :(")
    public fun emotion(): Unit {
        angry()
        sad()
    }
}

class SuperTeacher(name:String) : Teacher(name){
    fun simpleEmotion(){
        super.sad() // protected bisa diakses di child classnya
        // super.angry() // private tidak bisa diakses di child classnya
    }

    fun superEmotion(){
        super.emotion();
        println("Super emotion")
    }

}

