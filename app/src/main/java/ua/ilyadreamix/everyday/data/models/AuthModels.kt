package ua.ilyadreamix.everyday.data.models

import java.io.Serializable

data class SessionInfo(
    val sessionId: String?,
    val userId: String?,
    val timestamp: Int = 0,
    val data: SessionData?
) : Serializable {
    data class SessionData(
        val email: String?,
        val password: String?
    )
}