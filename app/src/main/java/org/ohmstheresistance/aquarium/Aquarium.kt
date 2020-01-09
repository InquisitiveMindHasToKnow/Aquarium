package org.ohmstheresistance.aquarium

//Classes
class Aquarium {

    var length: Int = 100
    var height: Int = 40
    var width: Int = 25


     fun volumeOfWater(): Int {
        return length * width * height / 1000
    }

    //The about function can also be written more concisely like:
    fun volumeOfWaterInAquarium() = length * width * height / 1000
}


