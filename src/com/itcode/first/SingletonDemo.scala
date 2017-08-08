package com.itcode.first

/**
  * Created by along on 17/8/8 11:11.
  * Email:466210864@qq.com
  */
object SingletonDemo {
  def main(args: Array[String]): Unit = {
    //单例对象，不需要new ,用类名.方法 来调用对象中的方法
    val session1 = SessionFactory.getSession();
    println("first1:"+session1)
    val session2 = SessionFactory.getSession();
    println("first2:"+session2)
    val session3 = SessionFactory.getSession();
    println("first3:"+session3)
  }
}

object SessionFactory{
  val session = new Session
  def getSession():Session={
    session
  }
}
class Session{

}
