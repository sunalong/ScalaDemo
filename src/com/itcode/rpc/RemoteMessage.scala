package com.itcode.rpc

/**
  * Created by along on 17/8/10 21:29.
  * Email:466210864@qq.com
  */
trait RemoteMessage extends Serializable

case class RegisterWorker(id:String,deviceInfo:String) extends RemoteMessage

case class RegistedStatus(masterUrl:String,isSuccess:Boolean)extends RemoteMessage