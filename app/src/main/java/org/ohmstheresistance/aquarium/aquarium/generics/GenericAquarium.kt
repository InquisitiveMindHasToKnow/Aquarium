package org.ohmstheresistance.aquarium.aquarium.generics

fun main(args: Array<String>){

    println(genericExample())
}
open class WaterSupply(var needsProcessed: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true){
    fun filter(){
        needsProcessed = false
    }
}

//class Aquarium<T> (val waterSupply: T)//possible to pass null as T
//class Aquarium<T: Any>(val waterSupply: T) //impossible to pass null as T

//we can be as specific as we want with the generic constraint and replace anny with the top of any type hierarchy we want to use.
//below, we are saying : T MUST be of type water supply
class Aquarium<out T: WaterSupply>(val waterSupply: T){
    fun addWaterTwo(cleaner: Cleaner<T>){

        if(waterSupply.needsProcessed){
            cleaner.clean(waterSupply)
        }
               println("Addding water from $waterSupply")


    }
        //check is a built in kotlin library that checks state of your classes. it will throw an illegal exception if argument is false

        //if the water supply doesn't need to be processed, go on to the next statement,
        // otherwise, throw an exception with the provided message
    fun addWater(){
        check(!waterSupply.needsProcessed){
            "Water supply needs to be processed."
        }
        println("Addding water from $waterSupply")
    }



}


fun genericExample(){
    val aquarium = Aquarium<TapWater>(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    //because of type inference, there's no need to say TapWater twice in line 22
    //val aquarium = Aquarium(TapWater())//does the same thing with less code

    //I'm able to set a string as water supply because type T has no bounds. T can be set to any type
//    val aquarium2 = Aquarium("String")
//    println(aquarium2.waterSupply)

    //It's also possible for T to be null even though it's of type T and not T?.
    // This is because T stands for a nullable any type. The type at the top of the type hierarchy
//    val aquarium3 = Aquarium(null)
//    aquarium3.waterSupply

    val aquarium5 = Aquarium(LakeWater())
    aquarium5.waterSupply.filter()// if water isn't filtered before added, there'll be an illegal argument printed
    aquarium5.addWater()


    val cleaner = TapWaterCleaner()
    val aquarium6 = Aquarium(TapWater())
    aquarium6.addWaterTwo(cleaner)


}

//Out Types

//Out types are type parameters that only ever occur inn return values of functions or on val properties.
//If we try to pass an out type as the parameter of a function, Kotlin will give us a compiler error
//Once a generic type is declared an out type, Kotlin can infer extra info about where they're safe to use

//Aquarium class declared an outType on line 28. if that out is removed, line 75 returns a compiler error.

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("Item Added")

fun genericExampleTwo(){
    val aquarium = Aquarium(TapWater())

    addItemTo(aquarium)

}


//In Types
//In types are used anytime the generic is only used as an  argument to functions.

//In types can only be passed INTO an object and Out types can only be passed OUT of an object, or returned.

//Constructors can take out types as arguments but functions cannot.

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{

    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

//Generic Functions

//you can make a function generic by adding <> after the fun keyword

//we can use generic functions for methods, too. Even in classes that have their own generic type.
fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>){

    println("Aquarium water is cleann: ${aquarium.waterSupply.needsProcessed}")

}

//In order to use R in this function, we have to tell Kotlin that it's reified(real).
//To make a generic type reified, you need to use the inline keyword before fun and reified before the type.

//We don't really care what kind of aquarium hasWaterSupplyOfType is called on and we show that by using <*> as the generic (star projections)

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

//we can use reified types for regular and extension functions and not just members.

inline fun <reified  T: WaterSupply> WaterSupply.isOfType() = this is T

fun genericExampleThree(){

    val aquarium = Aquarium(TapWater())
    isWaterClean(aquarium)

    aquarium.hasWaterSupplyOfType<TapWater>() //true

    aquarium.waterSupply.isOfType<LakeWater>() //false


}


//All generic types are only used at compile time in kotlin. However, at runtime, all generic types are erased.


//Reflection

@ImAPlant class Plant{
    fun trim(){}

    fun fertilize(){}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}

//:: represents reflection in kotlin

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class  OnGet


@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections(){
    val classObj = Plant::class

    //print all annotations
    for (annotation in classObj.annotations){

        println(annotation.annotationClass.simpleName)
    }

    //find one annotation, or null
   // val annotated = classObj.findAnnotation<ImAPlant>

//    annotated?.apply{
//        println("Found a plant annotation!")
//    }
}







