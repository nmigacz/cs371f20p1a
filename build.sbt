name := "shapes-oo-scala"

version := "0.2"

scalaVersion := "2.12.7"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "3.0.5"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.14.0" % Test
)
