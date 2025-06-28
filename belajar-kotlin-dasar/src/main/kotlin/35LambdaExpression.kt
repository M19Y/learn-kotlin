fun main() {

    // membuat function
    fun functionExample(param1: String):String{
        return param1
    }

    // membuat lambda
    val lambdaExample: (String) -> String = {value:String ->
        value.uppercase()
    }

    println(lambdaExample("Bro"))

                        // param type   // return value  // input params
    val lambdaExample2: (String, String) -> String = {param1:String, param2:String ->
        val result = "$param1 $param2"
        result // auto return
    }
    println(lambdaExample2("Bro", "Sis"))

    // struktur lambda
    // val varName: (param type) -> return value = { param: type -> return value }
    // baris terakhir akan menjadi return value
}