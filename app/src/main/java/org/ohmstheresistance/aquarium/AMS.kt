package org.ohmstheresistance.aquarium

import java.util.*

fun main (args: Array<String>){

    println("Hello, ${args[0]}!")

    dayOfWeek()
    //Every function in Kotlin returns something even when not explicitly specified.
    //A function like main returns a type "Unit", Kotlins ways of saying "No value". When returned as unit, you don't have to specify it explicitly.

    isFishSafeOfNot()

    morningOrNight()

}

fun dayOfWeek(){

    println("What day is it today?")

    var dayOfWeekIs = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    var day = "Today is: "


    println(day + when  (dayOfWeekIs){


        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped."
    })

}

fun isFishSafeOfNot(){

    val temperature = 240

    val isHot = if ( temperature > 60) true else false
    println(isHot)

    val message = "The fish is ${ if (temperature > 60) "safe to eat." else "not safe to eat"}"
    println(message)
}

fun morningOrNight(){

    val time = 5
    val greeting = if (time < 12) "Good morning" else "Good night"

    println(greeting)
}