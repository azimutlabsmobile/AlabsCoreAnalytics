package kz.alabs.core_analytics.app_metrica.data

import android.app.Application
import kz.alabs.core_analytics.app_metrica.domain.AppMetricaAnalytics
import kz.alabs.core_analytics.core.domain.AnalyticsAdapter

class AppMetricaAdapter private constructor(
    private val apiKey: String,
    private val metric: AppMetricaAnalytics
) : AnalyticsAdapter {

    init {
        metric.activate(apiKey)
        metric.enableActivityAutoTracking()
    }

    override fun sendEvent(eventName: String, parameter: Map<String, Any>) {
        metric.sendEvent(eventName = eventName, params = parameter)
    }

    class Builder(
        application: Application,
        private val apiKey: String,
        private val metric: AppMetricaAnalytics = DefaultAppMetricaAnalytics(application)
    ) {
        fun build(): AnalyticsAdapter = AppMetricaAdapter(
            apiKey = apiKey,
            metric = metric
        )
    }
}