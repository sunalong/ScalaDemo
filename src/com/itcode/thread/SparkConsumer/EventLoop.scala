package com.itcode.thread.SparkConsumer

import java.util
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}

/**
  * 底层分发任务的类
  *
  * @param name
  * @tparam E
  */
abstract class EventLoop[E](name: String) {
  //Java中的消息队列
  val eventQueue: BlockingQueue[E] = new LinkedBlockingQueue[E]()
  val resultQueue = new util.ArrayList[E]()
  val atomicStopped = new AtomicBoolean(false)
  /**
    * Todo:此处可写线程池来分发任务
    */
  private val eventThread = new Thread(name) {

    override def run(): Unit = {
      while (!atomicStopped.get()) {
        //从阻塞队列中拿出第一个任务，如果没有拿到会阻塞
        val event = eventQueue.take()
        //利用偏某一类型的任务交给某一类型的去处理
        onReceive(event) //把任务传给onReceive,在子类中有实现，TaskProcessEventLoop,打印event
      }
    }
  }

  private val resultThread = new Thread(name) {

    override def run(): Unit = {
      while (resultQueue.size() != 0) {
        val resultEvent = resultQueue.remove(0)
        onReceive(resultEvent)
      }
    }
  }

  /**
    * 相当于thread的start，供外界调用，里面调用eventThread的start()方法
    */
  def start(): Unit = {
    if (atomicStopped.get) {
      //Todo:应该放开下面一行代码，否则一旦停止之后无法再次开启
      //      atomicStopped.compareAndSet(true,false)
      throw new IllegalArgumentException(name + " has already been stopped")
    }
    onStart()
    eventThread.start()
    resultThread.start()
  }


  def stop(): Unit = {
    if (atomicStopped.compareAndSet(false, true)) {
      //如果atomeicStopped的值为false则将其设置为true,设置成功返回true
      //false意味着第一个参数值与给定的值不相等，
      //即如果原来atomicStopped.get的值为true,这里给的是false，不相等，返回false
      eventThread.interrupt()
      var onStopCalled = false
      eventThread.join()
      //在eventThread退出之后调用onStop，以确保onReceive在onStop之前发生
      onStopCalled = true
      onStop()
    }
  }

  /**
    * 把事件放到事件队列中。eventThread会稍后执行这些事件
    *
    * @param event
    */
  def post(event: E): Unit = {
    if (event.isInstanceOf[TaskSubmitted])
      eventQueue.put(event)
    else
      resultQueue.add(event)
  }


  //  protected def onReceive(event: E): PartialFunction[E,Unit]
  /**
    * 当轮询到任务队列中有任务，调用这个方法来将消息发给实现了此方法的子类
    *
    * @return
    */
  protected def onReceive: PartialFunction[E, Unit]

  def onStart() = {}

  def onStop() = {}

}
