package org.ohmstheresistance.aquarium

//Extension functions allow you to add functions to an existing class without having access to its source code.

//Once you define an extension function, it's available as if it was declared in the class it's called in

//Extension classes are a great way to add helpful functionality to classes you don't own and also to separate the core API
//from helper methods in classes you do own

fun main(args: Array<String>) {

    extensionExample()

    println(staticExample())

    println(nullableExample())
}

fun String.hasSpaces(): Boolean {
    val found: Char? = this.find { it == ' ' }

    return found != null
}

//Simpler, more concise Kotlin version of calling hasSpaces()
fun String.hasSpacesV2() = find { it == ' ' } != null

fun extensionExample() {
    "Does this string have spaces?".hasSpaces() // true
}

open class AquariumPlant(val color: String, private val size: Int)

//extension functions are defined outside of the class they extend so they do not get access to private variables.
//they are always resolved statically based on the variable they're applied to.(at compile time)
fun AquariumPlant.isRed() = color == "Red"


class GreenLeafyPlant(size: Int) : AquariumPlant("Green", size)

fun AquariumPlant.print() = println("Aquarium Plant")
fun GreenLeafyPlant.print() = println("Green Leafy Plant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print() //Green Leafy Plant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() //Aquarium Plant
}

//You can define extension properties, too!
//Specify the class you're extending, followed by a . then followed by the property name.

//in this example, we're extending aquarium plant, declaring isGreen then using a getter to check if the color is Green
//we can use isGreen just like a regular property
val AquariumPlant.isGreen: Boolean
get() = color == "Green"


//this function uses getter of isGreen and returns green as the color is set to green below
fun propertyExample(){
    val plant = AquariumPlant("Green", 50)
    plant.isGreen //true
}


//You can also make the class you're extending, sometimes referred to as the receiver, nullable!
//if you do that, this can be null
fun AquariumPlant?.pull(){
    this?.apply {
        println("removing $this")

    }
}

//the object in which the pull method is called can be null. This is indicated by the ? after AquariumPlant but before the .

//inside the body, we can check for null by using ?.apply()
fun nullableExample(){

    val plant:AquariumPlant? = null
    plant.pull() //ok
}

//You want to take a nullable receiver if you expect the caller will want to call your extension function on nullable variables
//Or if you want to provide a default behavior when your function is applied to null