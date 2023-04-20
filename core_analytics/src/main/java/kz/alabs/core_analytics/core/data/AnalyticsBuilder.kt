package kz.alabs.core_analytics.core.data

import android.app.Application
import kz.alabs.core_analytics.app_metrica.data.AppMetricaAdapter
import kz.alabs.core_analytics.core.domain.AnalyticsAdapter
import kz.alabs.core_analytics.firebase.data.FirebaseAdapter

class Analytics private constructor(builder: Builder) {

    private var adapters: List<AnalyticsAdapter> = emptyList()

    class Builder(private val app: Application) {

        private val adapters: MutableList<AnalyticsAdapter> = mutableListOf()

        fun registerAppMetricaAdapter(apiKey: String) = apply {
            adapters.add(createAppMetricaAdapter(apiKey))
        }

        fun registerFirebaseAdapter() = apply {
            adapters.add(createFirebaseAdapter())
        }

        private fun createAppMetricaAdapter(apiKey: String): AnalyticsAdapter =
            AppMetricaAdapter.Builder(apiKey = apiKey, application = app).build()

        private fun createFirebaseAdapter(): AnalyticsAdapter = FirebaseAdapter.Builder(app).build()

        fun build() = Analytics(this)

        fun getAdapters(): List<AnalyticsAdapter> = adapters

    }

    fun getAdapters(): List<AnalyticsAdapter> = adapters

    init {
        adapters = builder.getAdapters()
    }
}