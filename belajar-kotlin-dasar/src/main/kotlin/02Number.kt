fun main() {
    // bilangan bulat (Byte, Short, Int, Long)
    var byte: Byte = 120
    var short: Short = 100
    var int : Int = 10
    var long: Long = 2000L

    println(byte)
    println(short)
    println(int)
    println(long)

    // bilangan pecahan
    var float: Float = 10.5F
    var double: Double = 11.1

    println(float)
    println(double)

    // literal
    var hexadecimal:Int = 0XFF
    var binary:Int = 0b0011
    println(hexadecimal)
    println(binary)

    // number dengan underscore
    var price = 10_000_000
    println(price)

    // conversion (toDataTypeConversion ex toInt, ToShort ect.)
    var score = 100

    var finalScore: Double = score.toDouble()
    println(finalScore)

}