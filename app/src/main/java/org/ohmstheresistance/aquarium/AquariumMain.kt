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


    val smallAquarium = Aquarium(length = 40, height = 20, width = 10 )
    println("Small Aquarium Volume: ${smallAquarium.volumeOfWater()} liters")


    //note that this aquarium
    val builtAquarium = Aquarium(numberOfFish = 9)

    println("Built Aquarium Volume: ${builtAquarium.volumeOfWater()} liters " +
            "Length: ${builtAquarium.length}"  +
            "Width: ${builtAquarium.width}" +
            "Height: ${builtAquarium.height}")
}

