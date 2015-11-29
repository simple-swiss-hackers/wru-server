name := """wru-server"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  ws,
  cache,
  specs2 % Test
)

libraryDependencies += "org.elasticsearch" % "elasticsearch" % "2.1.0"
libraryDependencies += "joda-time" % "joda-time" % "2.9.1"


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
