package com.study.llnw

/**
  *
  *
  *
  *
  */
object LLnwLogAnalyzer {
  def main(args: Array[String]): Unit = {
    for (i <-3 to 3) {
      println(i)
    }
      //sudo -u mapr /opt/mapr/spark/spark-2.2.1/bin/spark-shell --name '3plisLlnwAnalysis' --master yarn --deploy-mode cluster --conf spark.yarn.queue=root.high_priority --conf spark.driver.bindAddress=10.2.121.168 --driver-memory 6G --executor-memory 6g --num-executors 15

//       import org.apache.hadoop.io.Writable
//       import org.apache.hadoop.io.Text
//       val llnwRecords = sc.sequenceFile("/3plis/ingest/3plis.llnw-direct.live-aggregated/http_raw/2019/08/01/*/*/*", classOf[Writable], classOf[Text]).map{case (k, v) => (k.get(), v.toString)}.map(x => LineParser.parse(x._2)).toDS.coalesce(100).cache
    }

}
