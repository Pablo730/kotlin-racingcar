package week1.step2

class StringCalculator(val inputExpression: String?) {
    init {
        validationInputExpression(inputExpression)
    }

    private fun validationInputExpression(inputExpression: String?) {
        require(!inputExpression.isNullOrBlank())
        val inputExpressionSplit: List<String> = inputExpression.split(" ")
        require(inputExpressionSplit.size % 2 == 1)

        val operatorRegex: Regex = Regex("^[^+\\-*/]*[+\\-*/][^+\\-*/]*$")
        for (index in 1 until inputExpressionSplit.size step 2) {
            require(operatorRegex.matches(inputExpressionSplit[index]))
        }

        val numberRegex: Regex = Regex("^\\d+$")
        for (index in inputExpressionSplit.indices step 2) {
            require(numberRegex.matches(inputExpressionSplit[index]))
        }
    }

    fun addition(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 + double2
    }

    fun subtraction(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 - double2
    }

    fun multiplication(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 * double2
    }

    fun division(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 / double2
    }
}
