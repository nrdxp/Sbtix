scalaVersion in ThisBuild := "2.12.12"

lazy val one = project.settings(
  credentials += Credentials(realm = "Very secret stuff!", host = "files.nullable.se", userName = "test", passwd = "test"),
  libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % "3.3.3",
    "private-org" % "private-name" % "1.2.3"
  )
)
lazy val two = project
lazy val three = project.settings(
  credentials += Credentials(realm = "Very secret stuff!", host = "files.nullable.se", userName = "test", passwd = "test")
).dependsOn(one).enablePlugins(JavaAppPackaging)

lazy val root = project.in(file(".")).aggregate(one, two, three)

resolvers in ThisBuild += "private demo" at "https://files.nullable.se/sbtix-demo-private/"
