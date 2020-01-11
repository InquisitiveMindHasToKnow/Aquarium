package org.ohmstheresistance.aquarium.aquarium

fun main (args: Array<String>) {

    buildAquarium()
    makeFish()

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


    val smallAquarium = Aquarium(
        length = 40,
        height = 20,
        width = 10
    )
    println("Small Aquarium Volume: ${smallAquarium.volumeOfWater()} liters")


    val builtAquarium =
        Aquarium(numberOfFish = 9)

    println("Built Aquarium Volume: ${builtAquarium.volumeOfWater()} liters " +
            "Length: ${builtAquarium.length}"  +
            "Width: ${builtAquarium.width}" +
            "Height: ${builtAquarium.height}")
}

fun makeFish(){

    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark Color: ${shark.color} \nPlecostomus Color: ${plecostomus.color}")

    shark.eat()
    plecostomus.eat()
}

//only fish that implement FishAction will pass into feedFish.
fun feedFish( fish : FishAction){

    fish.eat()
}

