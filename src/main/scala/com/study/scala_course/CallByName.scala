package com.study.scala_course

/**
 *
 * @author andrii_lytvynskyi
 */
object CallByName {
  def measure(action: () => Unit) = {
    println("Starting to measure time")
    val startTime = System.nanoTime
    action
    val endTime = System.nanoTime
    println("Operation took "+(endTime-startTime)+" ns")
  }

  measure(test)

  private def test() = {

    println("Will now sleep a little")
    Thread.sleep(1000)

  }
}
