package org.ohmstheresistance.aquarium.aquarium

//exploring the init function

class Fish (val friendly: Boolean = true, volumeNeeded : Int){

    //above, volumeNeeded does not have a val or var so Kotlin will not create a property from the argument for you.
    //this class declaration also results in Kotlin creating a constructor from the information provided

    //most classes only specify that one constructor and with default parameters. Constructor overloading is not needed. ie: you
    //don't need to define a constructor for each combination of arguments.

    //in Kotlin, you typically don't need secondary classes but if you do create one, it must include a call to the primary constructor by using "this"
    //and any required arguments

    //TO WRITE GOOD KOTLIN CODE, USE ONE CONSTRUCTOR AND INIT BLOCKS. IF CONSIDERING A SECOND CONSTRUCTOR, USE HELPER METHODS

    constructor() : this(true, 9){
        println("Running secondary constructor")
    }

    val size: Int

    //init blocks can be uses the same as constructor bodies in other languages. YOu can have more than one, they always run before any
    //secondary constructors and they can be almost anywhere in your class. they're executed in ordeer from the top of the class to the bottom

    init {
        println("First init block of Fish class.")
    }

    init {
        if(friendly){
            size = volumeNeeded
        }else{
            size = volumeNeeded * 2
        }
    }

    init {
        println("Constructed a fish class of size $volumeNeeded. Its final size: ${this.size}")
    }

    init {
        println("Last init block in Fish class.")
    }
}
//instead of making a second constructor, consider making a helper method instead. This provides a simpler class and cleaner api.
//
fun makeADefaultFish() = Fish( true, 60)


fun fishExample(){
    val fish = Fish(true, 20)
    println("Is this fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}

