package org.ohmstheresistance.aquarium.aquarium.decorations

//In addition to Data classes, there are three types of special purpose classes you can make in Kotlin.

//#1 Singletons

//To create a singleton, use the object keyword  to declare your class. That's it!

//Anytime you're defining a class that should not be instantiated multiple times, you can use the object keyword in place of class.

//There can only be 1 man u!
object ManchesterUnited{

    val bestManager = "Sir Alex Ferguson"

    fun plays(){

        //.......
    }
}


//#2 Enums

//Enums let you enumerate items. Declare an enum by using enum in front of class

//Enums actually define a class and you can give them properties or even methods.
//In the below example, only 1 RED, 1 GREEN and 1 BLUE item will be created.  So enums are similar to singletons(?)

enum class  Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)

}

//#3 Sealed Classes
//Sealed classes can be subclassed but only inside the file in which it is declared. If you try to subclass a sealed class in a different file,
//you will get an error!

//Because the class and subclasses are in the same file, Kotlin will be able to know all subclasses statically (at compile time).

//Sealed classes are great to represent a fixed number of types. (They're great for returning success or errors from a network API for eg.

sealed class Seal

class SeaLion: Seal()

class Walrus: Seal()

fun matchSeal(seal: Seal):String{
    return when (seal){
        is Walrus -> "Walrus"
        is SeaLion -> "Sea Lion"
    }
}