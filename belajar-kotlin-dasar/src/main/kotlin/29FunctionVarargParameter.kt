
fun countInArray(array: Array<Int>):Int {
    var count = 0;

    for (data in array){
        count += data
    }
    return count
}

fun countInVararg(vararg args: Int):Int {
    var count = 0;

    for (data in args){
        count += data
    }
    return count
}

//fun countWithNameWrong(vararg args:Int, name:String):Unit{
//    var score = 0;
//    for (count in args){
//        score += count
//    }
//
//    println("Score for $name is $score")
//}

fun countWithName(name:String, vararg args:Int):Unit{
    var score = 0;
    for (count in args){
        score += count
    }
    score = score / args.size

    println("Score for $name is $score")
}


fun main() {
    val countInArray = countInArray(arrayOf(1, 2, 3, 4, 5))
    println(countInArray)
    val countInVarargs = countInVararg(1, 2, 3, 4, 5)
    println(countInVarargs)

    // tidak bisa dilakukan
    // vararg harus di taruh di akhir marameter
    // countWithNameWrong(name = "Otong",  args = 2,3,4,5)
    countWithName("Bro", 90, 80, 30, 50, 65)
}