package kz.alabs.core_analytics.firebase.data

import android.annotation.SuppressLint
import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import kz.alabs.core_analytics.core.domain.AnalyticsAdapter
import kz.alabs.core_analytics.firebase.domain.FirebaseAnalyticsWrapper

class FirebaseAdapter private constructor(
    private val firebaseAnalytics: FirebaseAnalyticsWrapper
) : AnalyticsAdapter {
    override fun sendEvent(eventName: String, parameter: Map<String, Any>) {
        firebaseAnalytics.sendEvent(eventName = eventName, params = parameter)
    }

    override fun sendEvent(eventName: String) {
        firebaseAnalytics.sendEvent(eventName = eventName)
    }

    class Builder(private val app: Application) {
        @SuppressLint("MissingPermission")
        fun build(
            firebaseAnalytics: FirebaseAnalyticsWrapper = DefaultFirebaseAnalyticsWrapper(
                FirebaseAnalytics.getInstance(app)
            )
        ):FirebaseAdapter = FirebaseAdapter(firebaseAnalytics)
    }
}