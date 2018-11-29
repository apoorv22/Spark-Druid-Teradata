package com.scienaptic.sparkdruidteradata

import java.util.Properties

import com.scienaptic.sparkdruidteradata.utils.SparkUtils

object TeraData {

  def main(args: Array[String]): Unit = {

    val sqlContext = SparkUtils.getSQLContext

    val teradataIp = "192.168.0.72"
    val url = s"jdbc:teradata://$teradataIp/test"

    val props = new Properties
    props.setProperty("user", "dbc")
    props.setProperty("password", "dbc")
    props.setProperty("TMODE", "TERA")
    props.setProperty("driver", "com.teradata.jdbc.TeraDriver")

    val df = sqlContext.read.jdbc(url,"test.Employee", props)

    df.show(10)

    df.write.jdbc(url,"test.Employee24", props)

    val df2 = sqlContext.read.jdbc(url,"test.Employee24", props)

    df2.show(10)
  }
}
