package kz.alabs.core_analytics.app_metrica.domain

interface AppMetricaAnalytics {

    fun activate(apiKey: String)

    fun sendEvent(eventName: String, params: Map<String, Any>)

    fun sendEvent(eventName: String)

    fun enableActivityAutoTracking()

}