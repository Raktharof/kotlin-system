import classes.CNPJ
import classes.DateTime
import classes.Rectangle
import com.google.gson.Gson
import java.net.URL


fun main() {
    val filledCNPJ = CNPJ("31.605.522/0001-40")
    val squareA = Rectangle(3, 11, 5, 11)
    val squareB = Rectangle(7, 13, 2, 7)
    val squareC = Rectangle(10, 14, 10, 13)

    println(squareA.intersects(squareB))
    println(squareA.intersects(squareC))
    println(squareB.intersects(squareC))
    println(filledCNPJ.checkFormatAndValue())
    println(filledCNPJ.cnpj)

    println(squareA.calculateIntersectArea(squareB))
    println(squareA.calculateIntersectArea(squareC))
    println(squareB.calculateIntersectArea(squareC))
    println(DateTime().getDateTimeByZone("CET"))
}


