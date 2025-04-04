package calculator.utils

fun <T> retryInput(
    runBlock: () -> T,
    onError: (String?) -> Unit,
): T {
    while (true) {
        try {
            return runBlock()
        } catch (e: IllegalArgumentException) {
            onError(e.message)
        }
    }
}