package ch4.part1

open class RichButton : Clickable {
//    opened class (via 'open') can be inherited

    fun disable() {}
//    default is final

    open fun animate() {}
//    opened class (via 'open) can be overridden

    override fun click(): String {
//        Clickable.click() is opened
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    ref : fragile base class
//          > Item 17 - Design and document for inheritance or else prohibit it // Effective Java

    final override fun showOff(): String {
        return super.showOff()
    }
}

class SubRichButton : RichButton() {
//   inheritance with constructor

    override fun click(): String {
        return super.click() + "from sub"
    }

//    final function can't be overridden
//    override fun showOff(): String {
//        return super.showOff()
//    }

}
