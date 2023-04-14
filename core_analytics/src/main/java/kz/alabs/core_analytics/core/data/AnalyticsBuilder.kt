package kz.alabs.core_analytics.core.data

import android.app.Application
import kz.alabs.core_analytics.app_metrica.data.AppMetricaAdapter
import kz.alabs.core_analytics.core.domain.AnalyticsAdapter

class Analytics private constructor(builder: Builder) {

    var adapters: List<AnalyticsAdapter> = emptyList()

    class Builder(private val app: Application) {

        private val adapters: MutableList<AnalyticsAdapter> = mutableListOf()

        fun registerAppMetricaAdapter(apiKey: String) = apply {
            adapters.add(createAppMetricaAdapter(apiKey))
        }

        private fun createAppMetricaAdapter(apiKey: String) =
            AppMetricaAdapter.Builder(apiKey = apiKey, application = app).build()

        fun build() = Analytics(this)

        fun getAdapters(): List<AnalyticsAdapter> = adapters
    }

    init {
        adapters = builder.getAdapters()
    }
}