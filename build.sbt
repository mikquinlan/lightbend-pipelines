import sbt._
import sbt.Keys._

import scalariform.formatter.preferences._

lazy val sensorData =  (project in file("."))
  .enablePlugins(PipelinesAkkaStreamsApplicationPlugin)
  .settings(
    //end::docs-projectSetup-example[]
    libraryDependencies ++= Seq(
      "com.typesafe.akka"      %% "akka-http-spray-json"   % "10.1.8",
      "ch.qos.logback"         %  "logback-classic"        % "1.2.3",
      "com.typesafe.akka"      %% "akka-http-testkit"      % "10.1.8" % "test",
      "org.scalatest"          %% "scalatest"              % "3.2.0-M1"  % "test"
      //tag::docs-projectName-example[]
    ),
    name := "lightbend-pipelines",
    //end::docs-projectName-example[]
    organization := "com.metaxiaconsulting",

    scalaVersion := "2.12.10",
    crossScalaVersions := Vector(scalaVersion.value),
    scalacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-target:jvm-1.8",
      "-Xlog-reflective-calls",
      "-Xlint",
      "-Ywarn-unused",
      "-Ywarn-unused-import",
      "-deprecation",
      "-feature",
      "-language:_",
      "-unchecked"
    ),

    scalacOptions in (Compile, console) --= Seq("-Ywarn-unused", "-Ywarn-unused-import"),
    scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,

    scalariformPreferences := scalariformPreferences.value
      .setPreference(AlignParameters, false)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 90)
      .setPreference(DoubleIndentConstructorArguments, true)
      .setPreference(DoubleIndentMethodDeclaration, true)
      .setPreference(RewriteArrowSymbols, true)
      .setPreference(DanglingCloseParenthesis, Preserve)
      .setPreference(NewlineAtEndOfFile, true)
      .setPreference(AllowParamGroupsOnNewlines, true)
  )
