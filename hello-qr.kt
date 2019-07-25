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
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt

class Hello : CliktCommand() {
    private val name by option("-n", "--name", help = "Who are you happy to see").prompt("Host name")

    override fun run() {
        name.renderQR()
    }
}

fun main(args: Array<String>) = Hello().main(args)