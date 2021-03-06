package dashboard.weather

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class WeatherService(
        private val darkskyClient: DarkSkyClient,
        @Value("\${darksky.api.key}") private val key: String
) {

    companion object {
        val latitude = "52.1647"
        val longitude = "5.2767"
    }

    fun darkSkyForecast(): DarkSkyForecast {
        return darkskyClient.forecast(key, latitude, longitude)
    }
}