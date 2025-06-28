fun main() {

    val names: Array<String?> = arrayOfNulls(5)
    names.set(0, "Son Goku")
    names[1] = null
    names[2] = "Crilin"
    names[3] = null
    names.set(4, "Dragon Ball")

    names.forEach { name -> println(name) }

}