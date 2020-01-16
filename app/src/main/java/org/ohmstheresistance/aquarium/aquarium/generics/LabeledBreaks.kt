package org.ohmstheresistance.aquarium.aquarium.generics

fun labels(){

    loop@ for (i in 1..100){
        for(j in 1..100){
            if (i > 10)break@loop
        }
    }
}

//a break with a label jumps to the execution point right after the loop marked with that label

//in the above function, if i > 10, we break and resume execution at the label.

// This gives us more power over nested loops

//ANY EXPRESSION in kotlin may be marked with a label

//labels have the form of an identifier, followed by the @ sign