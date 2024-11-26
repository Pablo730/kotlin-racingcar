package racingcar.domain

class CarForwardRandomProvider {
    fun randomValue(): Int {
        return (FORWARD_RANDOM_START_RANGE..FORWARD_RANDOM_END_RANGE).random()
    }

    companion object {
        const val FORWARD_RANDOM_START_RANGE: Int = 0;
        const val FORWARD_RANDOM_END_RANGE: Int = 9;
    }
}