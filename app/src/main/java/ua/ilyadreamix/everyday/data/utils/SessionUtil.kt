package ua.ilyadreamix.everyday.data.utils

import android.content.Context
import androidx.activity.ComponentActivity
import ua.ilyadreamix.everyday.data.models.SessionInfo

object SharedPrefsKeys {
    const val SHARED_PREFS_NAME = "ed-session"
    const val ED_SESSION_ID = "session-id"
    const val ED_SESSION_USER_ID = "user-id"
    const val ED_SESSION_TIMESTAMP = "timestamp"
    const val ED_SESSION_DATA_EMAIL = "email"
    const val ED_SESSION_DATA_PASSWORD = "password"
}

object SessionStatuses {
    /** User is unregistered */
    const val SESSION_NULL = 0
    /** User can sign in by session ID */
    const val SESSION_VALID = 1
    /** User must relogin */
    const val SESSION_EXPIRED = 2
}

/**
 * Class for validating and setting
 * Everyday API session
 *
 * @param activity Activity to get shared preferences from
 * @author IlyaDreamix
 */
class SessionUtil(private val activity: ComponentActivity) {
    private val sharedPrefs = activity.getSharedPreferences(SharedPrefsKeys.SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    fun getSessionInfo(): SessionInfo {
        val sessionId = sharedPrefs.getString(SharedPrefsKeys.ED_SESSION_ID, null)
        val userId = sharedPrefs.getString(SharedPrefsKeys.ED_SESSION_USER_ID, null)
        val timestamp = sharedPrefs.getInt(SharedPrefsKeys.ED_SESSION_TIMESTAMP, 0)
        val email = sharedPrefs.getString(SharedPrefsKeys.ED_SESSION_DATA_EMAIL, null)
        val password = sharedPrefs.getString(SharedPrefsKeys.ED_SESSION_DATA_PASSWORD, null)

        return SessionInfo(sessionId, userId, timestamp,
            SessionInfo.SessionData(email, password)
        )
    }

    fun getSessionStatus(): Int {
        var status = SessionStatuses.SESSION_NULL
        val sessionInfo = getSessionInfo()

        sessionInfo.sessionId?.let {
            val currentTimeSeconds = (System.currentTimeMillis() / 1000).toInt()
            status = if (currentTimeSeconds - sessionInfo.timestamp >= ONE_DAY) {
                SessionStatuses.SESSION_EXPIRED
            } else {
                SessionStatuses.SESSION_VALID
            }
        }

        return status
    }

    fun setSession(data: SessionInfo) {
        val sessionData = data.data!!

        sharedPrefs.edit()
            .putString(SharedPrefsKeys.ED_SESSION_ID, data.sessionId)
            .putString(SharedPrefsKeys.ED_SESSION_USER_ID, data.userId)
            .putInt(SharedPrefsKeys.ED_SESSION_TIMESTAMP, data.timestamp)
            .putString(SharedPrefsKeys.ED_SESSION_DATA_EMAIL, sessionData.email)
            .putString(SharedPrefsKeys.ED_SESSION_DATA_PASSWORD, sessionData.password)
            .apply()
    }

    fun deleteSession() {
        sharedPrefs.edit().clear().apply()
    }

    companion object {
        const val ONE_DAY = 24 * 60 * 60
    }
}