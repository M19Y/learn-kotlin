fun String.hello():String = "Hello $this"
fun String.askName():Unit = println("My name is $this, what's your?")

fun main() {

    println("Bro".hello())
    "Sis".askName()
}