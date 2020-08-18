package com.study.scala_course

/**
 *
 * @author andrii_lytvynskyi
 */
abstract class Boolean {
  def ifThenElse[T](t: =>T, e : =>T): T

  def && (x: => Boolean): Any = ifThenElse(x, false)

}
