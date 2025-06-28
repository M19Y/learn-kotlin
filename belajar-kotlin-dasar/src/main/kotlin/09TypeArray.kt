fun main() {

    val members: Array<String> = arrayOf("Son Goku", "Son Goha", "Picollo")
    val values: Array<Int> = arrayOf(100, 200, 300)
    val balances: Array<Long> = arrayOf(10_000, 20_000, 30_000)

    // array index start with 0 and with array.size - 1
    println(members.size)
    println(members.get(0))
    println(members[1])

    // setter
    members.set(2, "Abilal")
    println(members[2])

    members[0] = "Apon"
    println(members[0])


}