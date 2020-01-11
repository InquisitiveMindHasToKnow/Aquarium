package org.ohmstheresistance.aquarium

fun main(args: Array<String>){

    delegate()
}

fun delegate(){
    val plecostomus = Plecostomus()

    println("Fish color is ${plecostomus.color}")
}

interface FishAction{
    fun eat()
}

interface FishColor{
    val color: String
}


//using the keyword by after FishColor allows you to remove the override as it defers all calls to the object GoldColor
class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("a lot of alggae"),
    FishColor by fishColor


//A class of which you can have only ONE instance is an object.
// The instance will be called GoldColor and you cannot make another instance of it.
//This is similar to using Singletons
object GoldColor: FishColor{
    override  val color = "Gold"
}

object RedColor: FishColor{
    override  val color = "Red"

}


class PrintingFishAction(val food: String): FishAction{
    override fun eat(){
        println(food)
    }
}




































































