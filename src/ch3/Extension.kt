package ch3

const val CHAR_A = 'A'
const val LAST_CHAR_IS_A = "asndfkjanfdkasjfnsajkfnjkan fjkadsfA"

fun main() {
    assert(
        CHAR_A == LAST_CHAR_IS_A.lastChar()
                && CHAR_A == LAST_CHAR_IS_A.lastCharWithoutThisRef()
                && CHAR_A == LAST_CHAR_IS_A.lastCharByIndex()
    )



}

fun String.lastChar(): Char = this.get(this.length - 1)

fun String.lastCharWithoutThisRef(): Char = get(this.length - 1)

fun String.lastCharByIndex(): Char = this[length - 1]