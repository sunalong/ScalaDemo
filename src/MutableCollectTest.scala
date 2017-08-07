import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by along on 17/8/7 10:48.
  * Email:466210864@qq.com
  */
object MutableCollectTest {
  def main(args: Array[String]): Unit = {
    listBufferTest
    setTest
  }

  private def setTest = {
    //创建一个可变的HashSet
    val set1 = new mutable.HashSet[Int]()
    //向HashSet中添加元素
    set1 += 2
    //add等价于+=
    set1.add(4)
    set1 ++= Set(1, 3, 5)
    //删除一个元素
    set1 -= 5
    set1.remove(3)
    println(set1.getClass)
    println(set1)
  }

  private def listBufferTest = {
    //构建一个可变列表，初始有3个元素
    val list1 = ListBuffer[Int](1, 3, 5)
    //创建一个空的可变列表
    val list2 = new ListBuffer[Int]
    //向list2中追加元素，注意：没有生成新的集合
    list2 += 4
    list2.append(5)
    //将list1中的元素追加到list2中，注意：没生成新的集合
    list2 ++= list1
    //将list2和list1合并成一个新的ListBuffer,此时生成了一个集合
    val list3 = list1 ++ list2
    //将元素追加到list1后面生成一个新的集合
    val list4 = list1 :+ 5
    println(list4)
  }
}
