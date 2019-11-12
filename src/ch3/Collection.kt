package ch3

import ch3.alias.higherOrderJoinToStringWithDefaultForAlias as aliasHigherOrderJoinToStringWithDefault

fun main() {
    assert(joinToString(setOf("1", "2", "3"), ",", "{", "}") == "{1,2,3}")
    assert(joinToString(listOf("1", "2", "3"), ",", "{", "}") == "{1,2,3}")

    assert(
        joinToString(
            collection = arrayListOf("1", "2", "3"),
            separator = ",",
            postfix = "}",
            prefix = "{"
        ) ==
                joinToString(
                    collection = linkedSetOf("1", "2", "3"),
                    separator = ",",
                    prefix = "{",
                    postfix = "}"
                )
    )

    assert(
        joinToStringWithDefault(listOf("1", "2", "3")) == "1,2,3"
    )

    assert(
        joinToStringWithDefault(listOf("1", "2", "3")) == higherOrderJoinToStringWithDefault(listOf("1", "2", "3"))
    )

    assert(
        joinToStringWithDefault(listOf("1", "2", "3")) == aliasHigherOrderJoinToStringWithDefault(listOf("1", "2", "3"))
    )
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun <T> joinToStringWithDefault(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}