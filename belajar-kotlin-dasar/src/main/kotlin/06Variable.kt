fun main() {
    // sangat direkomendasikan menggunakan val dibanding menggunakan var

    // var => mutable (bisa di ubah ubah)
    // var => immutable (tidak bisa di ubah ubah)

    var name = "Anto";
    println(name);
    name ="Budi";
    println(name);

    val country = "Japan";
    // country = "Australia"; won't work
    println(country)
}