import sbt._
object Dependencies {
  object Versions {
    lazy val logbackVersion = "1.2.3"
    lazy val slf4japiVersion = "1.7.25"
    lazy val akkaVersion = "2.5.20"
    lazy val catsVersion = "1.5.0"
    lazy val typeSafeConfigVersion = "1.3.2"
  }

  lazy val typeSafeConfig = "com.typesafe" % "config" % Versions.typeSafeConfigVersion
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % Versions.akkaVersion
  lazy val cats = "org.typelevel" %% "cats-core" % Versions.catsVersion
  lazy val logbackClassic = "ch.qos.logback" % "logback-classic" % Versions.logbackVersion
  lazy val logbackCore = "ch.qos.logback" % "logback-core" % Versions.logbackVersion
  lazy val slf4jApi = "org.slf4j" % "slf4j-api" % Versions.slf4japiVersion

  lazy val logBacks = Seq(logbackClassic, logbackCore, slf4jApi)
}