package org.ohmstheresistance.aquarium

fun main(args: Array<String>){

    usingPairs()
}


// Pairs
//Kotlin data type that allows us to define a generic pair of values

//NOTE: THERE ARE ALSO TRIPLETS.(Read up on those more)

//eg: we can associate equipment with what they're used for
fun usingPairs(){
    val equipment = "Fishing Net" to "Catching fish"

    println(equipment.first)//prints first argument of the pair
    println(equipment.second)//prints second argument


    //you can chain call pairs --> Kotlin will input the parenthesis for you

    val equipmentTwo = "Fishing Net" to "Catching fish" to "That are huge and healthy" to "And strong!"
    println(equipmentTwo)

    println(equipmentTwo.first)
    println(equipmentTwo.second)
    println(equipmentTwo.first.first)
    println(equipmentTwo.first.second)

    //Since pairs can be put together, they can bee broken apart. This process is called Destructuring.
    //We use it to tear apart an object and assign it to multiple variables.

    val fishNet = "Fishnet" to "catching fish"
    val (tool, use) = fishNet

    println("The $tool is used for $use.")//tool is mapped to the first argument and use is mapped to the second.

    //pairs can be turned into strings
    val fishNetString = fishNet.toString()
    println(fishNetString)

    //pairs can be turned into lists
    val fishNetList = fishNet.toList()
    println(fishNetList)


    //This gives you the ability to return more than one values from a function. Have the function return a pair and de-structure it on arrival
    fun giveMeATool(): Pair<String, String>{

        return "fishing rod" to "hooking"
    }

    val (toolToUse, useOfTool) = giveMeATool()

    println(toolToUse)
    println(useOfTool)
}