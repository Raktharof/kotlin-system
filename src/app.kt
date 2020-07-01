import Classes.Rectangle

fun main() {
    val squareA = Rectangle(3, 11, 5, 11)
    val squareB = Rectangle(7, 13, 2, 7)
    val squareC = Rectangle(10, 14, 10, 13)

    println(squareA.intersects(squareB))
    println(squareA.intersects(squareC))
    println(squareB.intersects(squareC))
}

