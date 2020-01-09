package org.ohmstheresistance.aquarium

fun main (args: Array<String>) {

    buildAquarium()

}

private fun buildAquarium(){

    //calling Aquarium as if it was a function does the same thing as the new keyword in java.
    //It creates a new instance of aquarium by using its constructor
    val myNewAquarium = Aquarium()

    println("Length: ${myNewAquarium.length} " +
            "Width: ${myNewAquarium.width} " +
            "Height: ${myNewAquarium.height}")


    myNewAquarium.height = 60
    println("Height: ${myNewAquarium.height}cm")

   println("Volume: ${myNewAquarium.volumeOfWater()} liters")



}
