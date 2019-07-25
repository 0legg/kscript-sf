#!/usr/bin/env kscript

@file:DependsOn("com.google.zxing:core:3.4.0")

import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

fun BitMatrix.renderCli() {
    println(toString("\u2588\u2588", "  "))
}

fun String.renderQR() {
    val writer = QRCodeWriter()
    val qr = writer.encode(this, BarcodeFormat.QR_CODE, 40, 40)
    qr.renderCli()
}
