/**
  * Created by along on 17/8/6 20:41.
  * Email:466210864@qq.com
  */
object MapTest {
  def main(args: Array[String]): Unit = {
    createMap
  }
  //创建map的两行形式
  def createMap: Unit ={
    val scores1 = Map("tom"->98,"jerry"->89,"kitty"->97)
    println("scores1:"+scores1)

    val scores2 = Map(("tom",98),("jerry",89),("kitty",90))
    println("scores2:"+scores2)

  }
}
