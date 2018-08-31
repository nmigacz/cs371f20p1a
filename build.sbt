name := "shapes-oo-scala"

version := "0.2"

scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "3.0.1"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test
)
