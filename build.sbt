
lazy val commonSettings = Seq(
  scalaVersion := "2.12.4",
  scalaVersion in ThisBuild := "2.12.4",
  scalacOptions ++= Seq("-Xsource:2.11"),
  scalacOptions ++= Seq("-unchecked", "-deprecation"),
  libraryDependencies += "edu.berkeley.cs" % "chisel3_2.12"          %  "3.1.7",
  libraryDependencies += "edu.berkeley.cs" % "chisel-iotesters_2.12" %  "1.2.9",
  updateOptions := updateOptions.value.withLatestSnapshots(false),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
  //libraryDependencies += "edu.berkeley.cs" % "rocketchip"       %  "latest.integration"
)

lazy val example = (project in file("."))
  .settings(commonSettings)
