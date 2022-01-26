ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.12"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.28"

lazy val root = (project in file("."))
  .settings(
    name := "Project0Revature"
  )
