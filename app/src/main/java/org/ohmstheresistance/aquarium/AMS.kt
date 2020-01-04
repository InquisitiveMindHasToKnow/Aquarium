package org.ohmstheresistance.aquarium

import java.util.*

//AMS - Aquarium Maintenance System
fun main (args: Array<String>){

    println("Hello, ${args[0]}!")

    dayOfWeek()
    //Every function in Kotlin returns something even when not explicitly specified.
    //A function like main returns a type "Unit", Kotlins ways of saying "No value". When returned as unit, you don't have to specify it explicitly.

    isFishSafeOfNot()
    morningOrNight()


    feedTheFish()

    println("\nYour fortune is: ${getFortuneCookie()}")


    println(getFortuneCookieForBirthday())


}

private fun dayOfWeek(){

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

private fun isFishSafeOfNot(){

    val temperature = 240

    val isHot = if ( temperature > 60) true else false
    println(isHot)

    val message = "The fish is ${ if (temperature > 60) "safe to eat." else "not safe to eat"}"
    println(message)
}

private fun morningOrNight(){

    val time = 5
    val greeting = if (time < 12) "Good morning" else "Good night"

    println(greeting)
}

//Feed fish on a random day of the week and give it a different food each day
private fun feedTheFish(){

    var day = randomDay()
    val food = fishFood(day)

    val foodForV2 = fishFoodV2(day)

    println("Today is $day and the fish should eat $food on ${day+ "s" }.")

    println("Today is $day and the fish should eat $foodForV2 on ${day+ "s" }.")
}

//function below selects a random day and returns a String.  >>>  : String <<<
private fun randomDay() : String {


    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    return week[Random().nextInt(7)]
}

private fun getFortuneCookie() : String{

    val fortunes = listOf("You will have a great day!", "Things will go well for you today.", "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.", "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    return fortunes[Random().nextInt(7)]
}


//Hint: In Kotlin, you can use toIntOrNull() to convert a number as a String to an Integer numeric.
// If the user enters "", toIntOrNull returns null.

//Check for null using the ? operator and use the ?: operator to handle the null case.
fun getFortuneCookieForBirthday() : String {
    val fortunes = listOf( "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends, because they are your greatest fortune.")
    print("\nEnter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
}

//Takes a day as a parameter and returns a string
private fun fishFood(day: String) : String{

    var food = "fasting"

    //when is like a switch statement. Doesn't need a break statement
    when(day){

        "Monday" -> food = "Lettuce"
        "Tuesday" -> food = "Worms"
        "Wednesday" -> food = "Mosquitoes"
        "Thursday" -> food ="Flakes"
        "Friday" -> food = "Pellets"
        "Saturday" -> food = "Granules"
        "Sunday" -> food = "Plankton"

    }
    return food
}

//does the same as fish food but more concisely. Else statement needed here though as a catch all in case none of the criteria met.
//For example, if any day is removed from the list below, the fish will fast for that day.
private fun fishFoodV2(day: String) : String{

    return when (day) {

        "Monday" -> "Lettuce"
        "Tuesday" -> "Worms"
        "Wednesday" -> "Mosquitoes"
        "Thursday" -> "Flakes"
        "Friday" -> "Pellets"
        "Saturday" -> "Granules"
        "Sunday" -> "Plankton"
        else -> "fasting"
    }
}