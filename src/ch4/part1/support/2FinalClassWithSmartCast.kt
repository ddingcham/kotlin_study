package ch4.part1.support;

// 클래스의 기본적인 상속 가능 상태를 final로 함으로써 얻을 수 있는 큰 이점
// "다양한 경우에 스마트 캐스트 가능" - 코드를 더 이해하기 쉽게 만듬
// 스마트 캐스트는 타입 검사 뒤에 변경될 수 없는 변수에만 적용 가능
// (상속과 커스텀 접근자 정의로 인한 변경 가능성 방지)
// ref kotlin in action - 2.3.5

fun main() {
// https://www.geeksforgeeks.org/kotlin-type-checking-and-smart-casting/
// Type Checking and Smart Casting
    assert("String6IntDoubleUndefinedUndefined" == smartCastWithList())
}

fun smartCastWithList(): String {
    val name = "Praveen"
    val age = 24
    val salary = 5000.55
    val grade = 'A'
    val details = listOf("detail_1")

    val employeeInfo: List<Any> = listOf(name, age, salary, grade, details)
    val result = "" // val - only reference

    for (attribute in employeeInfo) {
        when (attribute) {
            is String -> result + "String" + attribute.length
            is Int -> result + "Int"
            is Double -> result + "Double"
            else -> result + "Undefined"
        }
    }
    return result
}




