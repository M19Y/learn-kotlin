fun main() {

    var i = 0;
    while (true){
        println("Hallo - $i")
        // akan berhenti jika i sudah lebih besar dari 10
        if(i > 10){
            break
        }
        i++
    }

    println("\nContinue")
    for (j in 1 .. 10){

        // akan skip perulangan jika j habis di bagi dengan 2 => 2, 4, 6, ... dst
        if(j % 2 == 0){
            continue
        }
        println(j)
    }
}