package ch4.part1

import java.io.Serializable

fun main() {
    val button = ButtonWithNested()
    val buttonState = button.ButtonState()

    assert(button === buttonState.getButton())
    assert(button === button.ButtonState().getButton())
}

class ButtonWithNested : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class StaticButtonState : State {

//      fun getButton(): ButtonWithNested = this@ButtonWithNested
//      this is static nested class
    }

    inner class ButtonState : State {
        fun getButton(): ButtonWithNested = this@ButtonWithNested
    }

//    클래스 계층을 만들되 그 계층에 속한 클래스의 수를 제한하고 싶은 경우 중첩 클래스를 쓰면 편리
}

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

