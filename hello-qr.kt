#!/bin/bash

//usr/bin/env echo '
/**** BOOTSTRAP kscript ****\'>/dev/null
command -v kscript >/dev/null 2>&1 || curl -L "https://git.io/fpF1K" | bash 1>&2
exec kscript $0 "$@"
\*** IMPORTANT: Any code including imports and annotations must come after this line ***/

@file:DependsOn("com.github.ajalt:clikt:2.1.0")
@file:DependsOn("com.google.zxing:core:3.4.0")
@file:Include("qr-lib.kt")

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import java.util.concurrent.TimeUnit

class Hello : CliktCommand() {
    private val name by option("-n", "--name", help = "Who are you happy to see").prompt("Host name")
    private val ui by option("--ui").flag(default = false)

    override fun run() {
        if (ui) {
            val file = "qr.png"
            name.renderUi(file)
            ProcessBuilder("open", file).start().waitFor(10, TimeUnit.SECONDS)
        } else {
            name.renderCli()
        }
    }
}

fun main(args: Array<String>) = Hello().main(args)