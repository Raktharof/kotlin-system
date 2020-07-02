package classes

import com.google.gson.Gson
import java.net.URL

class DateTime() {

    fun getDateTimeByZone (timezone:String):String {
            val validTimezones = arrayOf("CST", "GMT", "CET", "GMT", "EST", "MST", "PST", "UTC") //todo: add more

            if (!validTimezones.contains(timezone.toUpperCase())) {
                return "Invalid timezone!"
            }

            val content = URL("http://worldclockapi.com/api/json/$timezone/now").readText()
            val parsedContent = Gson().fromJson(content, Map::class.java) as Map<String, String>
            return "(${timezone.toUpperCase()}) ${parsedContent["currentDateTime"]}"
    }
}