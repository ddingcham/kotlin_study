package ch4.part1

const val DEFAULT_CLICK_MESSAGE = "I was clicked"
const val Clickable_SHOW_OFF_MESSAGE = "I'm Clickable !"
const val ShowOffable_SHOW_OFF_MESSAGE = "I'm showOffable !"


fun main() {
    assert(DEFAULT_CLICK_MESSAGE == Button().click())
//    assert(ShowOffable_SHOW_OFF_MESSAGE == Button().showOff())
    assert(Clickable_SHOW_OFF_MESSAGE + ShowOffable_SHOW_OFF_MESSAGE == Button().showOff())

//    kotlin doesn't support 'default method' in java's interface
//    for Java 6
}

interface Clickable {
    fun click(): String
    fun showOff() = Clickable_SHOW_OFF_MESSAGE
}

class Button : Clickable, ShowOffable {
    //    needs 'override' modifier
//    fun click(): String {
//        return DEFAULT_CLICK_MESSAGE
//    }
    override fun click(): String {
        return DEFAULT_CLICK_MESSAGE
    }

//    override fun showOff(): String {
//        return super<ShowOffable>.showOff()
//    }

    override fun showOff(): String {
        return super<Clickable>.showOff() + super<ShowOffable>.showOff()
    }
}

interface ShowOffable {
    fun showOff() = ShowOffable_SHOW_OFF_MESSAGE
}