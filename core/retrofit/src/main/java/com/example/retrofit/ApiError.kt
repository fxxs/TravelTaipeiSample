package com.example.retrofit

/**
 * @param code : Http response Code
 * @param message : Backend debug message
 */
data class ApiError(
    val code: Int = UNKNOWN,
    override val message: String = ""
) : Error() {
    companion object {
        const val UNKNOWN = Int.MAX_VALUE
        const val NO_CONTENT = 204
        const val FORBIDDEN = 403
        const val NOT_FOUND = 404
        const val SYSTEM_BUSY = 500

        const val UNKNOWN_ERROR = "unknown server error"
    }
}
