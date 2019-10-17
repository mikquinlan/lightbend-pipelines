//credentials += Credentials(Path.userHome / ".lightbend" / "commercial.credentials")
credentials += Credentials(Path.userHome / ".lightbend/commercial.credentials")
resolvers += Resolver.url("lightbend-commercial", url("https://repo.lightbend.com/commercial-releases"))(Resolver.ivyStylePatterns)
resolvers += "Akka Snapshots" at "https://repo.akka.io/snapshots/"

addSbtPlugin("com.lightbend.pipelines" % "sbt-pipelines" % "1.1.0")