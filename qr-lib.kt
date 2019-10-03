#!/usr/bin/env kscript

@file:DependsOn("com.google.zxing:core:3.4.0")
@file:DependsOn("com.google.zxing:javase:3.4.0")

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import java.nio.file.Paths

fun BitMatrix.renderCli() {
    println(toString("\u2588\u2588", "  "))
}

fun BitMatrix.renderUi(file: String) {
    MatrixToImageWriter.writeToPath(this, "PNG", Paths.get(file))
}

fun String.renderCli() {
    val writer = QRCodeWriter()
    val qr = writer.encode(this, BarcodeFormat.QR_CODE, 40, 40)
    qr.renderCli()
}

fun String.renderUi(file: String = "qr.png") {
    val writer = QRCodeWriter()
    val qr = writer.encode(this, BarcodeFormat.QR_CODE, 400, 400)
    qr.renderUi(file)
}
