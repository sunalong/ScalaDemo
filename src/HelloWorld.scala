/**
  * Created by ${USER} on ${DATE} ${HOUR}:${MINUTE}.
  * Email:466210864@qq.com
  */

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello 2World")
    variable
  }

  def variable = {
    //使用val定义的变量值是不可变的，相当于java中用final修饰的变量
    val i = 1
    //使用var定义的变量是可变得，在scala中鼓励使用val
    var s = "hello"
    //scala编译器会自动推断变量的类型，必要的时候可以指定类型
    //格式是：变量名：类型
    var str: String = "fuckme"
    println("i:"+i+" s:"+s+" str:"+str)
  }
}
