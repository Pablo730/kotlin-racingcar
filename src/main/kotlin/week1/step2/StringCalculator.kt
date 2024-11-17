package week1.step2

class StringCalculator(val inputExpression: String?) {
    init {
        validationInputExpression()
    }

    companion object {
        const val NULL_OR_BLANK_ERROR_MESSAGE: String = "입력된 계산식이 없습니다"
        const val INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE: String = "입력한 계산식이 올바르지 않습니다"
        const val OPERATION_REGEX_PATTERN: String = "^[^+\\-*/]*[+\\-*/][^+\\-*/]*$"
        const val NUMBER_REGEX_PATTERN: String = "^\\d+$"
    }

    private fun validationInputExpression() {
        require(!inputExpression.isNullOrBlank()) { NULL_OR_BLANK_ERROR_MESSAGE }
        val inputExpressionSplit: List<String> = inputExpression.split(" ")
        require(inputExpressionSplit.size % 2 == 1) { INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE }

        val operatorRegex: Regex = Regex(OPERATION_REGEX_PATTERN)
        for (index in 1 until inputExpressionSplit.size step 2) {
            require(operatorRegex.matches(inputExpressionSplit[index])) { INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE }
        }

        val numberRegex: Regex = Regex(NUMBER_REGEX_PATTERN)
        for (index in inputExpressionSplit.indices step 2) {
            require(numberRegex.matches(inputExpressionSplit[index])) { INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE }
        }
    }

    private fun addition(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 + double2
    }

    private fun subtraction(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 - double2
    }

    private fun multiplication(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 * double2
    }

    private fun division(
        double1: Double,
        double2: Double,
    ): Double {
        return double1 / double2
    }

    fun calculateResult(): Double {
        val inputExpressionSplit: List<String> = inputExpression!!.split(" ")
        var calculateResult: Double = inputExpressionSplit.first().toDouble()
        for (index in 1 until inputExpressionSplit.size step 2) {
            val operation: Operation = Operation.entries.find { it.operationSymbol == inputExpressionSplit[index] }!!
            calculateResult =
                checkOperationCalculate(operation, calculateResult, inputExpressionSplit[index + 1].toDouble())
        }
        return calculateResult
    }

    private fun checkOperationCalculate(
        operation: Operation,
        double1: Double,
        double2: Double,
    ): Double {
        return when (operation) {
            Operation.ADDITION -> addition(double1, double2)
            Operation.SUBTRACTION -> subtraction(double1, double2)
            Operation.MULTIPLICATION -> multiplication(double1, double2)
            Operation.DIVISION -> division(double1, double2)
        }
    }
}
