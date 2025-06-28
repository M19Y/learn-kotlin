fun main() {

    var result = "A"

    println("When one option")
    when(result) {
        "A" -> {
            println("Good")
            println("Good")
        }
        "B" -> println("Ok")
        "C" -> println("Bad")
        else -> println("Unknown Value")
    }

    println("\nWhen multiple option")
    result = "B"
    when(result) {
        "A", "B", "C" -> println("Pass")
        else -> println("Failed")
    }

    // in if operation should be like this
    // if(result == "A" || result == "B" || result == "C")
    // ...
    // else
    // ...

    println("\nWhen expression with In")
    val passValues: Array<String> = arrayOf("A", "B", "C")
    result = "D"
    when(result){
        in passValues -> println("Pass")
        !in passValues -> println("Failed")
        else -> println("The heck") // tidak akan pernah di dapatkan
    }

    println("\nWhen expression with Is")
    when(result){
        is String -> println("Yes its a String")
        !is String -> println("No its not a string")
    }

    println("\nWhen expression as an alternative for If, else if and else expression")
    val score = 80
    when {
        score > 90 -> println("Soo good")
        score >= 80 -> println("Good")
        score > 65 -> println("Not bad")
        else -> println("Failed")
    }

}

