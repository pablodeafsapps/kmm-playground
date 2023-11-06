package org.deafsapps.kmm.kmmplayground.base

sealed class Result<out V, out E>

data class Ok<out V>(val value: V) : Result<V, Nothing>()
data class Err<out E>(val error: E) : Result<Nothing, E>()

inline infix fun <V, E> Result<V, E>.onSuccess(action: (V) -> Unit): Result<V, E> {
    if (this is Ok) {
        action(value)
    }
    return this
}

inline infix fun <V, W, E> Result<V, E>.mapSuccess(action: (V) -> W): Result<W, E> =
    (this as? Ok)?.run { Ok(action(value)) } ?: this as Err

inline infix fun <V, E> Result<V, E>.onFailure(action: (E) -> Unit): Result<V, E> {
    if (this is Err) {
        action(error)
    }
    return this
}

inline infix fun <V, E, F> Result<V, E>.mapFailure(action: (E) -> F): Result<V, F> =
    (this as? Err)?.run { Err(action(error)) } ?: this as Ok

fun <V, E> Result<V, E>.getOrNull(): V? = (this as? Ok<V>)?.value

fun <V, E> Result<V, E>.failureOrNull(): E? = (this as? Err<E>)?.error

fun <V, E> Result<V, E>.isSuccess(): Boolean = this is Ok

fun <V, E> Result<V, E>.isFailure(): Boolean = !isSuccess()

inline fun <V, E, R> Result<V, E>.fold(
    onSuccess: (value: V) -> R, onFailure: (err: E) -> R
): R = when (val err = failureOrNull()) {
    null -> onSuccess((this as Ok<V>).value)
    else -> onFailure(err)
}

