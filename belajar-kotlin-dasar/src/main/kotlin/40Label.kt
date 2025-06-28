fun main() {

    fun withoutLabel(){
        for(i in 1..10){
            for (j in 1 .. 10){
                println("$i x $j = ${i * j}")
                if(i > 3){
                    break
                }
            }
            print("\n")
        }
    }

    fun withLabel(){
        loopI@ for(i in 1..10){
            loopJ@ for (j in 1 .. 10){
                println("$i x $j = ${i * j}")
                if(i > 3){
                    break@loopI
                }
            }
            print("\n")
        }
    }

//    withoutLabel()
//    withLabel()

    fun continueLabel(){
        loopI@ for(i in 1..10){
            loopJ@ for (j in 1 .. 10){
                if(j == 5){
                    continue@loopI
                }
                println("$i x $j = ${i * j}")
            }
            print("\n")
        }
    }

    continueLabel()
}