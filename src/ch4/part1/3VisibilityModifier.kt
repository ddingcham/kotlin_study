package ch4.part1

// modifier         : 클래스 멤버    : 최상위 선언
// public (default) :  모든 곳      : 모든 곳
// internal         : 같은 모듈     : 같은 모듈 // decompile to java
// protected        : 하위 클래스    : (최상위 선언에 적용 불가)
// private          : 같은 클래스 내부 : 같은 파일 안에서

internal open class TalkativeButton : ShowOffable {
    private fun yell() = "yell"
    protected fun whisper() = "whisper"
}

//fun TalkativeButton.giveSpeech () {
// visibility can't be overridden as lower - order visibility
//    yell ()
// private access
//    whisper ()
// protected access
//}