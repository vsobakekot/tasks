import Dependencies.Libraries._
import Dependencies.Versions

lazy val root = (project in file("."))
  .settings(
    name := "tasks",
    organization := "com.banktochka",
    version := Versions.current,
    scalaVersion := Versions.scala,
    scalacOptions := Seq(
      "-deprecation",
      "-encoding",
      "UTF-8",
      "-explaintypes",
      "-feature",
      "-unchecked",
      "-Xfatal-warnings"
    ),
    libraryDependencies ++= Seq(
      zioCore,
      zioTest,
      zioTestSbt,
      scalatest
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
    scalafmtOnCompile := true
  )
