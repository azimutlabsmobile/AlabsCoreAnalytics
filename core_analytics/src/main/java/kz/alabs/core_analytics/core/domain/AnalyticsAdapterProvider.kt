package kz.alabs.core_analytics.core.domain

interface AnalyticsAdapterProvider {
    fun getAdapters(): List<AnalyticsAdapter>
}