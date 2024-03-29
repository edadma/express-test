name := "express-test"

version := "0.1"

scalaVersion := "2.12.8"

scalacOptions ++= Seq( "-deprecation", "-feature", "-unchecked", "-language:postfixOps", "-language:implicitConversions", "-language:existentials" )

organization := "xyz.hyperreal"

Global / onChangedBuildSource := ReloadOnSourceChanges

resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

resolvers += "Hyperreal Repository" at "https://dl.bintray.com/edadma/maven"

enablePlugins(ScalaJSPlugin)

enablePlugins(ScalaJSBundlerPlugin)

scalaJSUseMainModuleInitializer := true

jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv()

npmDependencies in Compile ++=
  Seq(
    "uuid" -> "3.3.3",
    "sockjs" -> "^0.3.19",
    "express" -> "4.17.1"
  )

libraryDependencies ++= Seq(
  "net.exoego" %%% "scala-js-nodejs-v12" % "0.9.0",
  "io.scalajs.npm" %%% "express" % "0.5.0"
)

coverageExcludedPackages := ".*Main"

mainClass in (Compile, run) := Some( "xyz.hyperreal." + name.value.replace('-', '_') + ".Main" )

mainClass in assembly := Some( "xyz.hyperreal." + name.value.replace('-', '_') + ".Main" )

assemblyJarName in assembly := name.value + "-" + version.value + ".jar"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("ISC" -> url("https://opensource.org/licenses/ISC"))

homepage := Some(url("https://github.com/edadma/" + name.value))

pomExtra :=
  <scm>
    <url>git@github.com:edadma/{name.value}.git</url>
    <connection>scm:git:git@github.com:edadma/{name.value}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>edadma</id>
      <name>Edward A. Maxedon, Sr.</name>
      <url>https://github.com/edadma</url>
    </developer>
  </developers>
