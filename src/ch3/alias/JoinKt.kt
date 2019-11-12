package ch3.alias

// higher order property as const
const val DEFAULT_SEPARATOR = ","
const val DEFAULT_PREFIX = ""
const val DEFAULT_POSTFIX = ""

// higher order function
fun <T> higherOrderJoinToStringWithDefaultForAlias(
    collection: Collection<T>,
    separator: String = DEFAULT_SEPARATOR,
    prefix: String = DEFAULT_PREFIX,
    postfix: String = DEFAULT_POSTFIX
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}