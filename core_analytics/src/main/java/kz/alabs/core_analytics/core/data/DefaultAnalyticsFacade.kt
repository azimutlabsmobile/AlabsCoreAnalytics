package kz.alabs.core_analytics.core.data

import kz.alabs.core_analytics.core.domain.AnalyticsAdapter
import kz.alabs.core_analytics.core.domain.AnalyticsFacade

class DefaultAnalyticsFacade : AnalyticsFacade {

    private var adapters = listOf<AnalyticsAdapter>()

    override fun sendEvent(eventName: String, parametersMap: Map<String, Any>?) {
        adapters.forEach {
            it.sendEvent(
                eventName = eventName,
                parameter = parametersMap.orEmpty()
            )
        }
    }

    override fun sendEvent(eventName: String) {
        adapters.forEach {
            it.sendEvent(
                eventName = eventName
            )
        }
    }

    override fun registerAdapters(adapters: List<AnalyticsAdapter>) {
        this.adapters = adapters
    }
}