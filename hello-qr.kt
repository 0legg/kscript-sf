@file:DependsOn("com.github.ajalt:clikt:2.1.0")
@file:DependsOn("com.google.zxing:core:3.4.0")

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

class Hello : CliktCommand() {
    private val name by option("-n", "--name", help = "Who are you happy to see").prompt("Host name")

    override fun run() {
        val writer = QRCodeWriter()
        val qr = writer.encode(name, BarcodeFormat.QR_CODE, 20, 20)
        qr.renderCli()
    }

    fun BitMatrix.renderCli() {
        println(toString("\u2588\u2588", "  "))
    }
}

fun main(args: Array<String>) = Hello().main(args)
