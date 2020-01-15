package org.ohmstheresistance.aquarium.aquarium.generics

import org.ohmstheresistance.aquarium.aquarium.Fish

class MyIntList{

    fun get(pos: Int): Int{
        return 0
    }

    fun addItem(item:Int){}
}


class MyShortList{

    fun get(pos: Int): Short{
        return 0
    }

    fun addItem(item: Short){}
}

//We would have to create a class for long, double etc etc
//generic classes allow us to make 1 class and substitute the generic value for the one we actually want.

//you can use whatever name value you want, but the convention for generics is T
class MyList<T>{
    fun geet(pos:Int): T{

        TODO("implement")
    }

    fun addItem(item: T){}
}


//To use a generic class, you specify the type you want to use in angle brackets when you instantiate the class.

fun workWithMyList(){

    val intList: MyList<String>
    val fishList: MyList<Fish>
}
