fun main() {
    fun sayHello(name:String = ""):String{
        /* old code
        if(name == ""){
            return "Hello Bro"
        }else{
            return "Hello $name"
        }*/

        // simple code
        return if(name == ""){
            "Hello Bro!"
        }else{
            "Hello $name"
        }
    }

    fun sayMorning(name:String = ""):String{
        /*old code
        when(name) {
        "" -> return "Hello Bro"
        else -> return "Hello $name"
        }*/

        // simple code
        return when(name){
            "" -> "Morning Bro"
            else -> "Morning $name"
        }

    }

    println(sayHello("Sis"))
    println(sayHello())

    println(sayMorning("Unc"))
    println(sayMorning())




}