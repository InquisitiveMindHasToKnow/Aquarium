package org.ohmstheresistance.aquarium

//we can make top level constants and assign them a value at compile time using const val
const val rocks = 4

//const val's value is decided at compile time while val's value can be determined during program execution
const val number = 5
val num = 5


//for val, we can set the return value of a function as its value
fun complexFunctionCall(){}
val result = complexFunctionCall()

//const val only works at the top level and with classes only declared with object, not with regular classes declared with class
//Kotlin does not have a concept of class-level constants

object Constants {
    const val CONSTANT_TWO = "object constant"
}

val foo = Constants.CONSTANT_TWO


//to define constants in a class, you have to wrap them in a companion object


//the difference btw a companion object and the regular one is that
//companion object are initialized from the static constructor of the containing class(They are created when the object is created) while
//plain objects are initialized on the first access to that object(when they are first used.)
class TesterClass{
    companion object{
        const val CONSTANT_THREE = "constant inside a class"
    }
}



















