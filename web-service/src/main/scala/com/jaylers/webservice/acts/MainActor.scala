package com.jaylers.webservice.acts

import akka.actor.{Actor, ActorLogging, Props}
import com.jaylers.webservice.DaemonConfig

object MainActor {
  def props(c: DaemonConfig): Props = Props(new MainActor(c))
}


class MainActor(c: DaemonConfig) extends Actor with ActorLogging{
  override def receive:Receive = {
    case msq:String => log.info(msq)
  }
}
