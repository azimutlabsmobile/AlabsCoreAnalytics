package kz.alabs.core_analytics.core.domain

interface AnalyticsFacade {
    fun sendEvent(
        eventName: String,
        parametersMap: Map<String, Any>?
    )

    fun sendEvent(eventName: String)

    fun registerAdapters(adapters: List<AnalyticsAdapter>)
}