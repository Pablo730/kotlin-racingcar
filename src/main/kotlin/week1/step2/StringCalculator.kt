package week1.step2

import java.lang.IllegalArgumentException

class StringCalculator(val inputExpression: String?) {
    init {
        validationInputExpression()
    }

    private fun validationInputExpression() {
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

    fun calculateResult(): Double {
        val inputExpressionSplit: List<String> = inputExpression!!.split(" ")
        var calculateResult: Double = inputExpressionSplit.first().toDouble()
        for (index in 1 until inputExpressionSplit.size step 2) {
            calculateResult =
                checkOperationCalculate(
                    inputExpressionSplit[index], calculateResult, inputExpressionSplit[index + 1].toDouble(),
                )
        }
        return calculateResult
    }

    fun checkOperationCalculate(
        operator: String,
        double1: Double,
        double2: Double,
    ): Double {
        when (operator) {
            "+" -> {
                return addition(double1, double2)
            }
            "-" -> {
                return subtraction(double1, double2)
            }
            "*" -> {
                return multiplication(double1, double2)
            }
            "/" -> {
                return division(double1, double2)
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }
}
