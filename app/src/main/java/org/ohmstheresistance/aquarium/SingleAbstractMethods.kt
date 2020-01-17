package org.ohmstheresistance.aquarium


//Single Abstract Methods (SAMs) - An interface with 1 method on it
//Expect to run into SAMs a lot on APIs written in java

//Runnable and Callable are 2 examples

interface Runnable{
    fun run()
}

interface  Callable<T>{
    fun call() : T
}

//Alllll this just to call print line
fun exampleOne(){
    val runnable = object: Runnable{
        override fun run(){
            println("I'm a runnable")
        }
    }

    JavaRun.runNow(runnable)
}

//In kotlin, we can pass a lambda in place of a SAM and it will take care of making the right kind of object for us

//if you take the sam as the last parameter, as below, we can use the last parameter call syntax to specify the lambda outside of the
//params

//fun exampleTwo(){
//
//    JavaRun.runNow {
//        println("Passing a lambda as a runnable")
//    }
//}















