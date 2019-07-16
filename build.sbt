version := "0.0.1-SNAPSHOT"

organization := "johnmitravensko"

scalaVersion := "2.12.4"

triggeredMessage := Watched.clearWhenTriggered

initialCommands in console :="import homegrown.collections._"

addCommandAlias("testc", ";clean;coverage;test;coverageReport")

libraryDependencies ++=
  Seq(
    "org.scalatest" %% "scalatest" % "3.0.8-RC5" % "test"
    // "org.scalacheck" %% "scalacheck" % "1.14.0"
    // "org.scala-lang.plugins" %% "scala-continuations-library" % "1.0.3",
  )


autoCompilerPlugins := true

//autocompilation start with at the sbt prompt by ~test