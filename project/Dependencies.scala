import sbt._

object Dependencies {

  object Versions {
    val current   = "0.1.0"
    val scala     = "2.13.6"
    val zio       = "1.0.12"
    val scalaTest = "3.2.9"
  }

  object Libraries {
    val zioCore    = "dev.zio"       %% "zio"          % Versions.zio
    val zioTest    = "dev.zio"       %% "zio-test"     % Versions.zio       % Test
    val zioTestSbt = "dev.zio"       %% "zio-test-sbt" % Versions.zio       % Test
    val scalatest  = "org.scalatest" %% "scalatest"    % Versions.scalaTest % Test
  }
}
