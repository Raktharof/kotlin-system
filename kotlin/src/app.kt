import classes.CNPJ
import classes.DateTime
import classes.Rectangle


fun main() {
    val filledCNPJ = CNPJ("31.605.522/0001-40")
    val squareA = Rectangle(3, 11, 5, 11)
    val squareB = Rectangle(7, 13, 2, 7)
    val squareC = Rectangle(10, 14, 10, 13)

    //exercise 1
    println(squareA.intersects(squareB))
    println(squareA.intersects(squareC))
    println(squareB.intersects(squareC))

    //exercise 2 and 3
    println(filledCNPJ.checkFormatAndValue())

    //exercise 4
    println(squareA.calculateIntersectArea(squareB))
    println(squareA.calculateIntersectArea(squareC))
    println(squareB.calculateIntersectArea(squareC))

    //exercise 6
    println(DateTime().getDateTimeByZone("UTC"))
}


