package org.ohmstheresistance.aquarium

//Classes


//Constructors

//by passing the variables in the class constructor arguments, it creates the member properties for you and assigns the passed in or default values for
//you
class Aquarium(var length: Int = 100, var height: Int = 40, var width: Int = 25) {



     fun volumeOfWater(): Int {
        return length * width * height / 1000
    }

    //The about function can also be written more concisely like:
    fun volumeOfWaterInAquarium() = length * width * height / 1000


    var water = volumeOfWater() * 0.9


    //in case a constructor is needed that's not the default (or may hold values that the default one does not)
    //NOTE: You can't mix arguments from both constructors. Arguments have to match exactly with one of the two constructors

    constructor(numberOfFish : Int): this(){

        val water :Int = numberOfFish * 2000 //cm3
        val tank :Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }

}


