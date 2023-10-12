package com.example.retrofit.interceptor

import okhttp3.Request
import okhttp3.RequestBody
import okio.Buffer
import java.nio.charset.Charset
import javax.inject.Inject

private val UTF8 = Charset.forName("UTF-8")

class RetrofitCurlGenerator @Inject constructor() {

    fun curlCommandForRequest(request: Request): String {

        var command = ShellCommand("curl", listOf("-X" to request.method))

        request.headers.names().forEach { element ->
            command = command.argument("-H", "'$element: ${request.header(element)}'")
        }

        val body = request.body
        if (body != null) {
            if (body.contentType() != null) {
                command = command.argument("-H", "'Content-Type: ${body.contentType()}'")
            }
            if (body.contentLength() != (-1).toLong()) {
                command = command.argument("-H", "'Content-Length: ${body.contentLength()}'")
            }
            command = command.argument("-d" to "'${body.toCommand()}'")
        }

        command = command.argument("-i" to "'${request.url}'")


        return command.toString()
    }
}

fun RequestBody.toCommand(): String? {
    val buffer = Buffer()
    this.writeTo(buffer)
    val contentType = this.contentType()
    val charset = if (contentType != null) contentType.charset(UTF8) else UTF8

    return charset?.let { buffer.readString(it) }
}