package org.ohmstheresistance.aquarium.aquarium


//Interfaces and Abstract Classes

//Interfaces and Abstract Classes can not be instantiated on their own. The difference btw Interfaces and Abstract Classes is that
//Abstract Classes have constructors and Interfaces don't

//Because AquariumFish is abstract, you can not make instances of it directly. You need to make subclasses that implement its missing functionality
abstract class AquariumFish{
    abstract val color : String
}

class Shark: AquariumFish(), FishAction{
    override val color = "Gray"

    override fun eat() {
        println("Hunts and eats prey")
    }
}

class Plecostomus: AquariumFish(), FishAction{
    override val color = "Gold"
    override fun eat() {
        println("Munches on algae")
    }
}

interface FishAction{
    fun eat()
}

//Both interfaces andd abstract classes can contain implementations of methods,
//on Interfaces we can then default implementations.

//Use interfaces if you have many methods and one or 2 default implementations

interface AquaruimAction{
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()

    fun swim(){
        println("Swim")
    }
}

//Use an AC if you can't complete a class

abstract class AquariumFishAC: FishAction{

    abstract val color: String
    override fun eat() = println("Tasty")
}

//Interface delegation lets you add features to a class via composition.
//Composition when you use an instance of another class as opposed to inheriting from it
//Instead of requiring the caller to subclass an entire AC, give them a small Interface
// and let them delegate those interfaces to an object.
//
// This is called INTERFACE DELEGATION

//Use whenever you might consider using an AC in other languages as it let's you use Composition to plug in certain behaviors instead
//of a loot oof subclasses, each specialized in a different way.


