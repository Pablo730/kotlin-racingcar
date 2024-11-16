package week1.step2

enum class Operation(val operationSymbol: String) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    ;

    companion object {
        fun fromOperationSymbol(operationSymbol: String): Operation? {
            return entries.find { it.operationSymbol == operationSymbol }
        }
    }
}
