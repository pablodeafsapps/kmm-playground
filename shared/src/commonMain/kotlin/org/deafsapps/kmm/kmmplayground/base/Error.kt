package org.deafsapps.kmm.kmmplayground.base

sealed class Error(val code: String, open val msg: String, open val ex: Exception)

data class RedirectError(override val msg: String, override val ex: Exception) :
    Error(code = "3xx", msg = msg, ex = ex)

data class RequestError(override val msg: String, override val ex: Exception) :
    Error(code = "4xx", msg = msg, ex = ex)

data class ServerError(override val msg: String, override val ex: Exception) :
    Error(code = "5xx", msg = msg, ex = ex)

data class UnknownError(override val msg: String, override val ex: Exception) :
    Error(code = "xxx", msg = msg, ex = ex)

fun Error.formattedDescription(): String = "Error $code - $msg"
