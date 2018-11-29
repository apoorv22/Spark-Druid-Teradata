name := "SparkDruidTeradata"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.0"
val avaticaVersion = "1.12.0"

resolvers += Resolver.mavenLocal
resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += "Atlassian Releases".at("https://maven.atlassian.com/public/")

exportJars := true

libraryDependencies ++= Seq("spark-core",
                            "spark-hive",
                            "spark-mllib").map("org.apache.spark" %% _ % sparkVersion) ++
                        Seq("avatica-server",
                            "avatica-core").map("org.apache.calcite.avatica" % _ % avaticaVersion
                                            excludeAll ExclusionRule(organization = "com.fasterxml.jackson.core"))

