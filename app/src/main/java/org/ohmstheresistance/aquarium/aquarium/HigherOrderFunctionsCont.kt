package org.ohmstheresistance.aquarium.aquarium

data class Fishes (var name: String)

fun main(args: Array<String>){

    fishExamples()

    fishExamplesV2()

}

//higher order functions with extension lambdas is possibly the most advanced part of the Kotlin language.


//fun fishExamples(){
//    val fish = Fishes("splashy")
//
        //With
//    //with fish name, call this.capitalize.
//    //WITH is a higher order function
//
//    with(fish.name){
//        this.capitalize()
//
//        //we dont NEED the this as it is implicit so just capitalize is fine
//        capitalize()
//
//    }
//}

fun fishExamples(){
    val fishes = Fishes("splashy")


    //fish.name is the name argument
    myWith(fishes.name){

        //capitalize() is the block function
        println(capitalize())

        //capitalize() returns a copy of the passed in string, it does NOT change the original
    }

    //Run
    //run is an extension of all data types. It takes one lambda as its argument and returns the result of executing that lambda
    println(fishes.run { name })


    //Apply
    //apply is similar to run and is an extension of all data types. unlike run, apply returns the object after the lambda is applied.
    println(fishes.apply {  })

    //apply is especially useful for calling functions on a newly created object.
    val fishesV2 = Fishes(name = "splashy").apply { name = "Sharky" }
    println(fishesV2.name) //Sharky


    //let returns a copy of the changed object and is particularly useful for chaining manipulations together.

    println(fishes.let { it.name.capitalize() }
        .let { it + "goldfish" }
        .let { it.length }
        .let { it + 40 })
}




//the receiver  object is extended and returns unit as we are not returning anything

//below, inside the function body of myWith, block is now an extension on a string object and we can apply it to a string
//After creating this function, with in fishExamples() can be replaced with myWith
fun myWith(name: String, block: String.() -> Unit){

    name.block()
}

//Lambdas ARE objects. A lambdas expression is an instance of a function interface which is itself a subtype of Object

fun fishExamplesV2(){

    val fishes = Fishes("splashy")


    //this is writing out everything the lambda in fishExamples() does.
    //without inline, an object is created EVERY call to myWith
    //basically, an instance of Function1 is called every time myWith is called. This takes up a lot of CPU time and memory.

    myWithInlineVersion(fishes.name, object: Function1<String, Unit>{
        override  fun invoke(name: String){
            name.capitalize()
        }
    })

    //with inlinne, no object is created, and lambda body is inlined here
    //Kotlin lets us define lambda based APIs with zero overhead. It won't even pay the cost of calling the myWith function
    //since it gets inlined

    //NOTE: Inlining large functions WILL increase code size so it's best used for simple functions like it was in the myWith example
    fishes.name.capitalize()
}

//Inlines
//Kotlin gives us the ability to use inline to basically promise that everytime myWith (myWithInlineVersion) is called,  it will
//transform the source code to inline the function. ie, the compiler will change the code to replace the lambda with the instructions inside
//the lambda

inline fun myWithInlineVersion(name: String, block: String.() -> Unit){

    name.block()
}
