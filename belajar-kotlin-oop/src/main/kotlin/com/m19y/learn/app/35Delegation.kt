package com.m19y.learn.app

import com.m19y.learn.data.MyBase
import com.m19y.learn.data.MyBaseDelegate
import com.m19y.learn.data.MyBaseDelegateBy

fun main() {

    val base = MyBase();
    base.sayMorning("Bro")
    base.sayHi("Sis")

    val delegateBase = MyBaseDelegate(base)
    delegateBase.sayMorning("Unc")
    delegateBase.sayHi("Aunty")

    val myBaseDelegateBy = MyBaseDelegateBy(base)
    myBaseDelegateBy.sayMorning("Unc") // membuat base baru
    myBaseDelegateBy.sayHi("Aunty") // tetap reference ke basenya
}