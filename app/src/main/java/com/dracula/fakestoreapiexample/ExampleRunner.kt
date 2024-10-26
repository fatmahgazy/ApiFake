package com.dracula.fakestoreapiexample

fun main() {
	val person = Person("Hassan")
	person.myMethod()
//correct

	val ahmed = Ahmed()
	val mohamed = Mohammed()
	val fatma = Fatma()

}

class Ahmed(){
	init {
		println("Ahmed")
	}
}

class Mohammed(){
	init {
		println("Mohamed")
	}
}

class Fatma(){
	init {
		println("Fatma")
	}
}

class Person(
	val name: String
){
	fun myMethod(){
		println(name)
	}
	init {

	}

//	val firstProperty = "First property: $name".also{
//		println(it)
//	}
//
//
//
//	init {
//		println("First name: $firstProperty")
//	}
//	init {
//		println("Second name: $name")
//	}


}
