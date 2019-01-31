package com.myservice

import akka.actor.ActorSystem
import cats.data.Validated
import com.myservice.acts.MainActor
import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.LoggerFactory

import scala.util.control.NonFatal

object Main {
  private val log = LoggerFactory.getLogger(getClass)
  type ResourceToClose = ActorSystem

  def main(args: Array[String]): Unit = {
    println("Hello world!")
    try{
      val c = ConfigFactory.load()
      DaemonConfig.readConfig(c) match {
        case Validated.Valid(deamonConfig) =>
          val s = start(c, deamonConfig)
          sys.addShutdownHook(stop(s))
        case Validated.Invalid(e) => log.error(e.toList.mkString(", "))
      }
    } catch {
      case NonFatal(e) => log.error(e.getMessage)
    }
  }

  def start(appConfig : Config, daemonConfig: DaemonConfig): ResourceToClose = {
    log.info("Starting My Service")
    val system = ActorSystem("MyService")
    val mainActor = system.actorOf(MainActor.props(daemonConfig))
    mainActor ! "Good morning"
    system
  }

  def stop (resourceToClose: ResourceToClose): Unit = {
    log.info("The application is Stoped")
    resourceToClose.terminate()
  }

}
