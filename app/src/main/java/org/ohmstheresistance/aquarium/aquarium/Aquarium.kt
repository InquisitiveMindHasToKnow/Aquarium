package org.ohmstheresistance.aquarium.aquarium

import kotlin.math.PI

//Classes


//Constructors

//by passing the variables in the class constructor arguments, it creates the member properties for you and assigns the passed in or default values for
//you
open class Aquarium(var length: Int = 100, var height: Int = 40, var width: Int = 25) {



     fun volumeOfWater(): Int {
        return length * width * height / 1000
    }


   open var volume : Int

    get() = length * width * height / 1000
    set(value) {
        height = (value * 1000) / (width * length)
    }

    //The about function can also be written more concisely like:
    fun volumeOfWaterInAquarium() = length * width * height / 1000


   open var water = volume * 0.9


    //in case a constructor is needed that's not the default (or may hold values that the default one does not)
    //NOTE: You can't mix arguments from both constructors. Arguments have to match exactly with one of the two constructors

    constructor(numberOfFish : Int): this(){

        val water :Int = numberOfFish * 2000 //cm3
        val tank :Double = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }

}


// Inheritance

//In order to be able to inherit from a class, it has to be declared open
//By default, classes are not "sub-classable", we have to explicitly allow it.

//The parent class comes after the : when using inheritance
// Just like classes, member variables are not available for subclassing by default. override will cause an error unless water and volume are declared
//open
class TowerTank(): Aquarium(){

    override var water = volume * 0.8

    override  var volume: Int

    get() = (length * width * height / 1000 * PI).toInt()
    set(value) {

        height = (value * 1000)/(width * length)
    }
}

