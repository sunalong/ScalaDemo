import scala.collection.mutable.ArrayBuffer

/**
  * Created by along on 17/8/6 18:30.
  * Email:466210864@qq.com
  */
object MultType {

  def main(args: Array[String]): Unit = {
//    invariableArray
    val ab = ArrayBuffer[Int]()
    //+=向尾部追加元素
//    variableArray(ab)
//    tarversalArray
//    changeArray
    methodsArray
  }
  def methodsArray: Unit ={
    val arr = Array(1,3,4,9)
    println("sum:"+arr.sum)
    println("max:"+arr.max)
    println("sorted:"+arr.sorted.toBuffer)
  }
  def changeArray: Unit ={
    val arr = Array(1,3,4,9)
    val ret1=for(e<-arr) yield e*2
    println("ret1="+ret1.toBuffer)
    val ret = arr.map(_*3)
    println("ret="+ret.toBuffer)

    //将奇数取出来乘以10后再生成一新的数组
    val res = for(e<-arr if e%2!=0) yield e*10
    println("res:"+res.toBuffer)
    //filter是过滤，接收一个返回值为boolean的函数
    //map相当于将数组中的每一个元素取出来，应用传进去的函数
    val r = arr.filter(_%2!=0).map(_*10)
    println("r="+r.toBuffer)
  }

  private def tarversalArray: Unit ={
    var arr = Array(1,3,5,7)
    //增强for循环打印数组
    for(i<-arr)
      println(i)
    //使用until生成一个Range,可带有下标
    for(i<-(0 until arr.length).reverse)
      println("arr("+i+")="+arr(i))
  }
  private def variableArray(ab: ArrayBuffer[Int]) = {
    ab += 2
    //追加多个元素
    ab += (3, 4, 5)
    //++=追加一个数组
    ab ++= Array(77, 88)
    //++=追加一个数组缓冲
    ab ++= ArrayBuffer(66, 99)
    //在数组某个位置插入元素用insert
    ab.insert(3, 222, 333, 444)
    println(ab)
    //删除数组某个位置的元素用remove
    ab.remove(4, 3)
    println(ab)
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
