package com.itcode.thread.SparkConsumer

trait TaskEvent

case class TaskSubmitted(name: String) extends TaskEvent

case class TaskSucceeded(name: String) extends TaskEvent

case class TaskFailed(name: String) extends TaskEvent

trait ResultEvent
case class ResultEventImpl(result:String) extends ResultEvent