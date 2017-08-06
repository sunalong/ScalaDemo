import scala.collection.mutable.ArrayBuffer

/**
  * Created by along on 17/8/6 18:30.
  * Email:466210864@qq.com
  */
object MultType {

  def main(args: Array[String]): Unit = {
    invariableArray
  }


  /**
    * 定长数组
    */
  private def invariableArray = {
    //如果new ,相当于调用数组的apply方法，直接为数组赋值
    //初始化一个长度为3的定长数组，其所有元素均为0
    var arr1 = new Array[Int](3)
    println(arr1) //打印数组的hashcode值
    //将数组转换成数组缓冲，可看到原数组中的内容
    //toBuffer会将数组转换成数组缓冲
    println(arr1.toBuffer)

    //初始化一个长度为1的定长数组
    val arr2 = Array[Int](3)
    println(arr2.toBuffer)
    //定义一个长度为3的定长数组
    val arr3 = Array[Int](3, 4, 5)
    println("arr3=" + arr3.toBuffer)
    //使用()来访问元素
    println("arr3(2)=" + arr3(2))
  }
}
