package com.myservice

import cats.data.ValidatedNel
import com.typesafe.config.Config
import cats.syntax.validated._

case class DaemonConfig()
object DaemonConfig {
  type VNel[T] = ValidatedNel[String, T]
  def readConfig(c: Config): VNel[DaemonConfig] = DaemonConfig().validNel
}
