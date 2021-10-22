package com.banktochka

import zio._
import zio.console.{getStrLn, putStrLn}

import scala.util.matching.Regex

object Task3 extends App {

  /**
   * Regex expression from Play Framework
   * (https://github.com/playframework/playframework/blob/2.7.0/
   * framework/src/play/src/main/scala/play/api/data/validation/Validation.scala)
   * and presented W3C recommendation
   * (http://www.w3.org/TR/html5/forms.html#valid-e-mail-address).
   */
  val emailRegex: Regex =
    """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

  def isValid(email: String): Boolean =
    if (email.trim.isEmpty)
      false
    else
      emailRegex.matches(email)

  override def run(args: List[String]): URIO[ZEnv, ExitCode] =
    (for {
      email <- putStrLn("\nPlease type email") *> getStrLn
      _     <- if (isValid(email)) putStrLn(s"Email is valid") else putStrLn(s"Email is invalid")
    } yield ()).exitCode
}
