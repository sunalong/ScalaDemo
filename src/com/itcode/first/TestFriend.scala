package com.itcode.first

trait Listen {
  val name: String

  def listen() = {
    println("You friend " + name + " is listening")
  }
}

trait Speak {
  val name: String

  def speak() = {
    println("You friend " + name + " is speaking.")
  }
}

class Animal(val name: String) {
}

//class Cat(override val name: String) extends Animal(name: String) with Speak with Listen {
class Cat(override val name: String) extends Speak with Listen {
  override def toString(): String = " hello " + name + "! "
}

object TestFriend {
  def main(args: Array[String]) {
    val cat = new Cat("hello kitty")
    cat.listen();
    cat.speak()
    println(cat)
  }
}

