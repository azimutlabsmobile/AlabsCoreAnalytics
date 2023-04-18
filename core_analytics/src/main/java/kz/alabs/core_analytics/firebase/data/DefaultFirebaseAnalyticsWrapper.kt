package kz.alabs.core_analytics.firebase.data

import com.google.firebase.analytics.FirebaseAnalytics
import kz.alabs.core_analytics.firebase.domain.FirebaseAnalyticsWrapper
import kz.alabs.core_analytics.utils.toBundle

class DefaultFirebaseAnalyticsWrapper(
    private val analytics: FirebaseAnalytics
) : FirebaseAnalyticsWrapper {

    override fun setUserProperty(key: String, value: String?) {
        analytics.setUserProperty(key, value)
    }

    override fun sendEvent(eventName: String, params: Map<String, Any?>) {
        analytics.logEvent(eventName, params.toBundle())
    }

    override fun sendEvent(eventName: String) {
        analytics.logEvent(eventName, null)
    }
}