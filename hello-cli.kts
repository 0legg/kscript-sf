#!/usr/bin/env kscript

val meetup = "San Francisco Kotlin Meetup"
println("Hello, ${args.getOrNull(0) ?: meetup}")
