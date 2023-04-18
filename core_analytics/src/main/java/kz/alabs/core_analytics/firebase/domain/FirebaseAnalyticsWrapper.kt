package kz.alabs.core_analytics.firebase.domain

interface FirebaseAnalyticsWrapper {

    fun setUserProperty(key: String, value: String?)

    fun sendEvent(eventName: String, params: Map<String, Any?>)

    fun sendEvent(eventName: String)
}