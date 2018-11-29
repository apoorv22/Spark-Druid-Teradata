package com.scienaptic.sparkdruidteradata.utils

import org.apache.spark.sql.{SQLContext, SparkSession}

object SparkUtils {

  def getSparkSession: SparkSession = {
    SparkSession.builder()
      .appName("Data Ingestion")
      .master("local[*]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()
  }

  def getSQLContext: SQLContext = getSparkSession.sqlContext

}
