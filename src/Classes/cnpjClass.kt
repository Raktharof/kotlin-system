package classes

class CNPJ(cnpj:String){
    val cnpj = cnpj

    fun checkFormatAndValue() :String {
        if (cnpj.length == 14 || (cnpj.length == 18 && ((cnpj[2] == '.' && cnpj[6] == '.' && cnpj[10] == '/' && cnpj[15] == '-')))) {
            val re = Regex("[^0-9]")
            val cnpjFormatted = re.replace(cnpj, "")
            return checkValidCNPJ(cnpjFormatted)
        } else {
            return "Formato de CNPJ incorreto. Por favor, insira formato correto. " +
                    "Ex: XXXXXXXXXXXXXX ou XX.XXX.XXX/XXXX-XX"
        }
    }

    private fun checkValidCNPJ(cpfNum:String):String {
        val invalidValueCheck = (cpfNum == "00000000000000") || (cpfNum == "11111111111111") || (cpfNum == "22222222222222") ||
                (cpfNum == "33333333333333") || (cpfNum == "44444444444444") || (cpfNum == "55555555555555") || (cpfNum == "66666666666666") ||
                (cpfNum == "77777777777777") || (cpfNum == "88888888888888") || (cpfNum == "99999999999999") || (cpfNum.length < 14)
        var firstDigitCheck = false
        var secondDigitCheck = false

        if (!invalidValueCheck) {
            val digits = cpfNum.map { Integer.parseInt(it.toString()) }.toIntArray()

            val firstDigitValue = (digits[0] * 5 + digits[1] * 4 + digits[2] * 3 + digits[3] * 2 + digits[4] * 9 +
                    digits[5] * 8 + digits[6] * 7 + digits[7] * 6 + digits[8] * 5 + digits[9] * 4 + digits[10] * 3
                    + digits[11] * 2) % 11

            if (firstDigitValue > 1) {
                firstDigitCheck = (11 - firstDigitValue) == digits[12]
            } else {
                firstDigitCheck = digits[12] == 0
            }

            if (firstDigitCheck) {
                val secondDigitValue = (digits[0] * 6 + digits[1] * 5 + digits[2] * 4 + digits[3] * 3 + digits[4] * 2 +
                        digits[5] * 9 + digits[6] * 8 + digits[7] * 7 + digits[8] * 6 + digits[9] * 5 + digits[10] * 4
                        + digits[11] * 3 + digits[12] * 2) % 11

                if (secondDigitValue > 1) {
                    secondDigitCheck = (11 - secondDigitValue) == digits[13]
                } else {
                    secondDigitCheck = digits[13] == 0
                }
            }
        }

        if (!invalidValueCheck && firstDigitCheck && secondDigitCheck){
            return "CNPJ $cnpj Válido"
        } else {
            return "CNPJ Inválido"
        }

    }

}