name := """wru-server"""

version := "0.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  ws,
  cache,
  evolutions,
  specs2 % Test
)

libraryDependencies += "org.elasticsearch" % "elasticsearch" % "2.1.0"
libraryDependencies += "joda-time" % "joda-time" % "2.9.1"
libraryDependencies += "com.restfb" % "restfb" % "1.17.0"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.1.0"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "1.1.1"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"




resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
