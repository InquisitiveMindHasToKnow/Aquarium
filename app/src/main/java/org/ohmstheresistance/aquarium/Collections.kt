package org.ohmstheresistance.aquarium

import android.annotation.SuppressLint

@SuppressLint("NewApi")
fun main(args: Array<String>){

    //Immutable collections are particularly useful in threaded environments where it could be troublesome if multiple threads
    //come in contact with the same collection

    //listOf gives us an immutable/unchangeable list
    val testList = listOf(5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

    println(reverseList(testList))

    println(reverseListKotlinVersion(testList))


    //Instead of having to create a new method , in Kotlin, you can just ask a list for its reversed version by using .reversed()
    //NOTE: The list is not mutable. reversed returns a new list
    //It's apparently good style to use listOf but mutableListOf when you absolutely have to (?!)

    println(testList.reversed())


    //Going back to Aquariums

    //mutableListOf gives us a list we can change
    val sickFishSymptoms = mutableListOf("white spots", "red spots", "not eating", "belly up", "bloated")
    sickFishSymptoms.add("white fungus")
    sickFishSymptoms.remove("white fungus")

    sickFishSymptoms.contains("bloated")//true
    sickFishSymptoms.contains("orange spots") //false

    //sublist creates a list from the index at the first argument to and excluding the index in the second argument
    println(sickFishSymptoms.subList(4, sickFishSymptoms.size)) //bloated


    //you can do math on lists
    println(listOf(3, 7, 15).sum()) // 25

    //if the list is not something kotlin can calculate the sum of, you can use sumby
    //the it is the default name for lambda arguments and in this argument, refers to each element of the list as it's traversed

    println(listOf("a", "b", "cc").sumBy { it.length }) //4

    //There are many more options to use on lists, read up in documentations


    //MAPPING
    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    //you can get the disease value based on the symptom key using .get or []
    println(cures.get("white spots"))
    println(cures["white spots"])

    //you can specify what to do if a key is not in the list and provide a default value
    println(cures.getOrDefault("spinning in circles", "sorry, I don't know"))


    //if we need to do more than just get the default value, use getOrElse where
    //if the value you're lookingn for isn't found, whatever is in the curly brackets will be executed
    println(cures.getOrElse("spinning in circles"){"There is no cure for this."})

    //just like there's mutableListOf, you can use mutableMapOf

    val inventory = mutableMapOf("fishing rod" to 1)
    inventory.put("tank scrubber", 2)
    inventory.remove("fishing rod")
}

//Normally when reversing a list, you create a function like the one below:

fun reverseList(list: List<Int>) : List<Int>{

    val result = mutableListOf<Int>()

    //you can use the until keyword interchangeably with ranges so for(i in 0 until list.size - 1) and for(i in 0..list.size - 1)
    //both do the same thing
    for(i in 0 until list.size - 1){
        result.add(list[list.size - i - 1])
    }

    return result
}

//Kotlin makes the task simpler in that you can use the "downTo" keyword to do something similar to above
fun reverseListKotlinVersion(list: List<Int>) : List<Int>{

    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0){
        result.add(list.get(i))
    }

    return result
}















