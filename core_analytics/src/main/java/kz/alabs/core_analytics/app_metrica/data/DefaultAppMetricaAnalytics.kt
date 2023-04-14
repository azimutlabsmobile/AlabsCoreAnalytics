package kz.alabs.core_analytics.app_metrica.data

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import kz.alabs.core_analytics.app_metrica.domain.AppMetricaAnalytics

class DefaultAppMetricaAnalytics(private val app: Application) : AppMetricaAnalytics {

    override fun activate(apiKey: String) = YandexMetrica.activate(
        app.applicationContext, YandexMetricaConfig.newConfigBuilder(apiKey).build()
    )

    override fun sendEvent(eventName: String, params: Map<String, Any>) =
        YandexMetrica.reportEvent(eventName, params)

}