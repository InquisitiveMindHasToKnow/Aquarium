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

    println(whatShouldIDoToday("happy"))

    //filter returning true prints everything in decorations
    println(decorations.filter { true })

    //this filter returns every element that begins with the letter p
    //'it' refers to each element in the list that's being filtered
    println(decorations.filter { it[0] == 's' })


    println(swim)

    println(filterTheWater(dirtyWater))

    eagerFilterExample()


    useOfIs()

    funWithRanges()

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

    //call it with 3 parameters in order
    shouldChangeWater(day, 20, 50)

    //calling the function with only required argument(s) which would use default values for temperature and dirty
    shouldChangeWater(day)


    //or setting one or any of the values by specifying thee name of the argument

    shouldChangeWater(day, dirty = 80)

    //best practice to put arguments without default values first and then the ones with default values after

   // shouldChangeWater("Monday") //<<< compiler error

    // shouldChangeWater(day = "Monday") // correct

    if(shouldChangeWater(day)){
        println("Change the water today.")
    }

    dirtyProcessor()
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

//practice problem using default vals for variables
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}

//implement a way to change aquarium water based on certain criteria

//there are 3 ways to call this function.

private fun shouldChangeWater(day: String, temperature : Int = 22, dirty : Int = 20) : Boolean{

    return true

}

//Default values are evaluated at CALL time with Kotlin
//Any in Kotlin can hold any type of object.

//While almost everything in Kotlin is an expression with a value, there are a few exceptions.
//There is no sensitive value for while loops and for loops so they don't have any value.
//Eg: if you try to assign a variable to a for loop, you'll get an error saying it's a statement.


                        //Filters are another control flow construct you can use from the standard

val decorations = listOf("Rocks", "Pebbles", "Plastic Plant", "Pagoda", "Shells", "Flowers", "Sand", "Seaweed")

//                      Lambdas

// An expression that makes a function
//Lambdas are always surrounded by curly brackets in Kotlin and can be called like funtions

val swim = { println("Fast")}()

//Lambda arguments go on the left and the body of the lambda goes on the right of the arrow ->

var dirtyWater = 20
val filterTheWater = {dirtyWater : Int -> dirtyWater / 2}


//Kotlin's syntax for function types. This syntax can be used to cleaning declare a variable that will hold a function

//we don't have to specify thee type of the lambda argument anymore, as it's calculated by type inference
val waterFilter: (Int) -> Int = { dirtyWater -> dirtyWater / 2}


//By default, filtering a list is "eager". Meaning, it creates a new list of the elements that pass through the filter everytime you call filter
//but filtering can be done lazily as well.(more on that later)
private fun eagerFilterExample(){
    val decorations = listOf("Rocks", "Pebbles", "Plastic Plant", "Pagoda", "Shells", "Flowers", "Sand", "Seaweed")


    //for example: eager below will hold a new list containing all the elements beginninng with the letter s
    val eagerFilter = decorations.filter { it[0] == 's' }
    println(eagerFilter)


    //To do filtering lazily, you can use sequencing. When you return as a sequence, a new
    // list won't be created, but rather it would hold a sequence of all the
    //list elements and knowledge of the filter to apple to each element.

    //Whenever you access elements in a sequence, the filter is applied.
    val lazyFilter = listOf("Rocks", "Pebbles", "Plastic Plant", "Pagoda", "Shells", "Flowers", "Sand", "Seaweed")

    println(lazyFilter)

    //If you want to return the sequence to a list, just use .toList()
    println(lazyFilter.toList())

    //after which the filter will be applied and all elements beginning with s will be put into a new list
}

private fun updateDirty (dirty : Int, operation : (Int) -> Int) : Int{

    return operation(dirty)
}

private fun feedFish( dirtyWater: Int) = dirtyWater + 10

//AMS system's "dirty processor that'll be called from feedthefish

//A higher order function is any function that takes a function as an argument
private fun dirtyProcessor(){

    dirtyWater = updateDirty(dirtyWater, waterFilter)

    //because feed fish is a named function and not a lambda, it's passed using ::
    //this way kotlin knows you're not trying to call feedFish, but will let you pass a reference
    dirtyWater = updateDirty(dirtyWater, :: feedFish)


    //when you combine higher order functions with lambdas, kotlin uses the last parameter call syntax

//the lambda is an argument to update dirty but since its passed as the last parameter, it does not have to be in the function parenthesis
    dirtyWater = updateDirty(dirtyWater){
        dirtyWater -> dirtyWater + 80
    }
}

//What's the difference between
//val random1 = random()
//val random2 = {random()}

//random1 has a value assigned at compile time, and the value never changes when the variable is accessed.
//random2 has a lambda assigned at compile time, and the lambda is executed every time the variable is referenced, returning a different value.


private fun useOfIs() {
    //the keyword is is used to see if a variable is an integer, float, boolean or double
//so the line below is checking to see if true is a boolean
    if (false is Boolean) {
        println("false is boolean")
    }

}

private fun funWithRanges(){

    //Define a starting and ending value and allows you to do calculations in between them

    val rangeFromOneToTen = 1..10 //automatically created a range incrementing from 1 to 10

    val alpha = "A".."Z"

    println("R in Alpha? : ${"R" in alpha}") //the keyword in checks to see if a certain item falls in a range or not

    val rangeFromTenToOne = 10.downTo(1) //creates a range from 10 to 1

    val rangeFromTwoToTwenty = 2.rangeTo(20) //creates a range from 2 to 20

    val rangeThree =
        rangeFromOneToTen.step(3) //goes through the rangeFromOneToTen range and adds 3 to every item so it goes from 1 > 4 > 7 > 10


    for (x in rangeThree) println("rangeThree: $x ")//Cycling through a range and printing information out

    println("\n")

    for (x in rangeFromTwoToTwenty)
        print("rangeFromTwoToTwenty: $x, ")

    println("\n")
    for (x in rangeFromTenToOne.reversed())
        println("Reverse rangeFromOneToTen: $x")//reversing a range. 10 to 1 now 1 to 10

}