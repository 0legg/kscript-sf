@file:DependsOn("com.github.ajalt:clikt:2.1.0")

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt

class Hello : CliktCommand() {
    private val name by option("-n", "--name", help = "Who are you happy to see").prompt("Host name")

    override fun run() {
        println("Hello, $name")
    }
}

fun main(args: Array<String>) = Hello().main(args)
