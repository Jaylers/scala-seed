import Dependencies._

name := "scala-seed"

version := "0.1"

scalaVersion := "2.12.8"


//this ThisBuild are effect for all project
ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.tradition.jayler"
ThisBuild / organizationName := "tradition"

//to fork the project to use different sbt from the current 
ThisBuild / fork := true

Global / cancelable := true

lazy val root = (project in file("."))
  .aggregate(webService)
  .aggregate(webBlog)

//to add new module of project
lazy val webService = project in file("web-service")

lazy val webBlog = project in file("web-blog")

