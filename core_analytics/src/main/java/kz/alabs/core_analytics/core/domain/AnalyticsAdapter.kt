package kz.alabs.core_analytics.core.domain

interface AnalyticsAdapter {
    fun sendEvent(eventName: String, parameter: Map<String, Any>)
    fun sendEvent(eventName: String)
}