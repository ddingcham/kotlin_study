package ch4.part1

import java.lang.UnsupportedOperationException

fun main() {
//  클래스 계층 정의 시 계층 확장 제한
    assert(
        eval(Sum(Num(1), Num(2))) ==
                evalWithSealedExpr(
                    SealedExpr.Sum(
                        SealedExpr.Num(1),
                        SealedExpr.Num(2)
                    )
                )
    )

    try {
        eval(UnsupportedExpr(1))
        assert(false)
    } catch (e: Exception) {}
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
class UnsupportedExpr(val value: Int) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw UnsupportedOperationException()
//        계층 확장 제한을 위한 else
    }

sealed class SealedExpr {
    class Num(val value: Int) : SealedExpr()
    class Sum(val left: SealedExpr, val right: SealedExpr) : SealedExpr()
}

fun evalWithSealedExpr(e: SealedExpr): Int =
    when (e) {
        is SealedExpr.Num -> e.value
        is SealedExpr.Sum -> evalWithSealedExpr(e.right) + evalWithSealedExpr(e.left)
//        else -> throw UnsupportedOperationException()
//        sealed 키워드를 사용해서 이미 계층 제한을 두었음
    }

