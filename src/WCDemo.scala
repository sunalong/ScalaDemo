/**
  * Created by along on 17/8/7 14:20.
  * Email:466210864@qq.com
  *
  * 求给定内容的每个单词个数并排序
  */
object WCDemo {
  def main(args: Array[String]): Unit = {
    val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
    val flatMap = lines.flatMap(_.split(" "))
    println("flatMap:"+flatMap)
    //flatMap:List(hello, tom, hello, jerry, hello, jerry, hello, kitty)
    val mapTuple = flatMap.map((_,1))
    println("mapTuple:"+mapTuple)
    //mapTuple:List((hello,1), (tom,1), (hello,1), (jerry,1), (hello,1), (jerry,1), (hello,1), (kitty,1))
    val groupMap = mapTuple.groupBy(_._1)
    println("groupMap:"+groupMap)
    //groupMap:Map(tom -> List((tom,1)), kitty -> List((kitty,1)), jerry -> List((jerry,1), (jerry,1)), hello -> List((hello,1), (hello,1), (hello,1), (hello,1)))
    val mapValues = groupMap.mapValues(_.foldLeft(0)(_+_._2))
    println("mapValues:"+mapValues)
    //mapValues:Map(tom -> 1, kitty -> 1, jerry -> 2, hello -> 4)
    val sortMap = mapValues.toList.sortBy(_._2)
    println("sortMap:"+sortMap)
    //sortMap:List((tom,1), (kitty,1), (jerry,2), (hello,4))

    //以上可集中在一行完成：
    val result = lines.flatMap(_.split(" ")).map((_,1)).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2)).toList.sortBy(_._2)
    println("result:"+result)
  }
}
