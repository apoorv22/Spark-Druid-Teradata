package com.scienaptic.dataingestion

import java.util.Properties

import com.scienaptic.dataingestion.utils.SparkUtils

object Druid {

  def main(args: Array[String]): Unit = {

    val sqlContext = SparkUtils.getSQLContext

    val props = new Properties()
    props.setProperty("driver", "org.apache.calcite.avatica.remote.Driver")
    props.setProperty("fetchSize", "10000")

    val df = sqlContext
      .read
      .jdbc("jdbc:avatica:remote:url=http://localhost:8082/druid/v2/sql/avatica/", "wikipedia", props)

    df.show(10)


    /*
        props.setProperty("driver", "org.apache.calcite.jdbc.Driver")
    df.write
      .mode(SaveMode.Overwrite)
      .jdbc("jdbc:calcite:remote:url=http://localhost:8082/druid/v2/sql/;parserFactory=org.apache.calcite.sql.parser.ddl.SqlDdlParserImpl#FACTORY","\"wikipedia23\"",props)
      .format("jdbc")
      .option(
        "url",
        "jdbc:calcite:parserFactory=org.apache.calcite.sql.parser.ddl.SqlDdlParserImpl#FACTORY")
//          .option("url", "jdbc:calcite:schemaFactory=org.apache.calcite.adapter.druid.DruidSchemaFactory; schema.url=http://localhost:8082")
      .option("dbtable", "wikipedia23")
      //      .option("query", "SELECT * FROM wikipedia")
      .option("driver", "org.apache.calcite.jdbc.Driver")
      .save()*/
  }
}
