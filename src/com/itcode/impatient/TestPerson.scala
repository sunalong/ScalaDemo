package com.itcode.impatient

/**
  * Created by along on 17/8/25 18:40.
  * Email:466210864@qq.com
  */
//class TestPerson private(val id: Int, val name: String) {//即使去掉private也没什么区别
class TestPerson private(val id: Int, val name: String) {//

  def descirtion: Unit = {
    println("id:" + id + " name:" + name)
  }
}

object TestPerson {
  def main(args: Array[String]): Unit = {
    val person = new TestPerson(11, "fuck")
    person.descirtion
    println(person.id + " " + person.name)
  }
}

//public class com.itcode.impatient.TestPerson {
//  public static void main(java.lang.String[]);
//  public int id();
//  public java.lang.String name();
//  public void descirtion();
//  public com.itcode.impatient.TestPerson(int, java.lang.String);
//}

//public class com.itcode.impatient.TestPerson {
//  public static void main(java.lang.String[]);
//  public int id();
//  public java.lang.String name();
//  public void descirtion();
//  public com.itcode.impatient.TestPerson(int, java.lang.String);
//}