/**
  * Created by along on 17/8/7 10:29.
  * Email:466210864@qq.com
  */
object CollectTest {
  def main(args: Array[String]): Unit = {
    val test = 9::5::2::Nil
    println(test)
    //创建一个不可变的集合
    val list1 = List(1,3,4)
    //将0插入到list1前生成一个新的list
    val list2 = 0::list1
    val list3 = list1.::(0)
    val list4 = 0+:list1
    val list5 = list1.+:(0)
    //将元素添加到list1后面生成一个新的集合
    val list6 = list1 :+3
    val list0 = List(44,55,66)
    //将两个list合并生成一个新的List
    val list7 = list1 ++ list0
    //将list1插入到list0前生成一个新的集合
    val list8 = list1 ++: list0
    //将list0插入到list1前生成一个新的集合
    val list9 = list1.:::(list0)
    println(list9)
  }
}
