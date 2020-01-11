package org.ohmstheresistance.aquarium.aquarium.decorations

fun main(args: Array<String>){

    makeDecorations()
}

fun makeDecorations(){

    //printing the object prints the values of properties instead of just an address of the object/object pointer.
    //Because of the use of data class
    val decorationOne = Decorations("Granite")
    println(decorationOne)

    val decorationTwo = Decorations("Slate")
    println(decorationTwo)

    val decorationThree = Decorations("Slate")
    println(decorationThree)

    println(decorationOne.equals(decorationTwo))
    println(decorationTwo.equals(decorationThree))


    //you can copy data objects using the copy method. This will create a new object with the same property values.
    val decorationFour = decorationOne.copy()
    println(decorationFour)

    //To get to the properties of a data class and assign them to variables, Kotlin allows us to use a process called Decomposition.
    val decorationFive = ExtraDecorations("Crystal", "Oak", "Deep-Diver")
    println(decorationFive)

    val(rock: String, wood: String, diver: String) = decorationFive
    println(rock)
    println(wood)
    println(diver)

    //above, Kotlin assigns the value of each variable to each variable from the data class
    //rocks = Crystal, wood = Oak etc

    //NOTE: You do need to put parenthesis around your vaariables for decomposition
    //The number of variables must match the number of properties or you will get a compiler error

    //NOTE 2: Variables are assigned in the order they are declared in the data class
}

//In Kotlin, classes that just hold data are prefixed with "data class"

data class Decorations(val rocks : String)


data class ExtraDecorations(val rocks: String, val wood: String, val diver: String)

