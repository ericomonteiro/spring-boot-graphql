package com.github.ericomonteiro.graphql.extension

import java.util.Optional

fun <T> Optional<T>.toNullable(): T? =
    if (isPresent)
        get()
    else
        null

