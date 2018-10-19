package dashboard.weather

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@JsonIgnoreProperties(ignoreUnknown = true)
data class DarkSkyForecast(
        val latitude: String,
        val longitude: String,
        val timezone: String,

        val currently: Forecast,
        val hourly: Hourly,
        val daily: Daily
) {

    data class Forecast(
            val time: Time,
            val summary: String?,
            val icon: String?,
            val precipIntensity: Float?,
            val precipProbability: Float?,
            val temperature: Float?,
            val apparentTemperature: Float?,
            val humidity: Humidity?,
            val pressure: Float?,
            val windSpeed: Float?,
            val windBearing: Float?,
            val sunriseTime: Time?,
            val sunsetTime: Time?,
            val moonPhase: Float?,
            val temperatureHigh: Float?,
            val temperatureLow: Float?
    )

    data class Hourly(
            val summary: String?,
            val icon: String?,
            val data: List<Forecast>
    )

    data class Daily(
            val summary: String?,
            val icon: String?,
            val data: List<Forecast>
    )

    data class Time(
            private val time:Long
    ) {
        init {
            val readableTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.systemDefault())
        }
    }

    data class Humidity(
            private val humidity: Float
    ) {
        init {
            val percentageHumidity = "${humidity * 100}%"
        }
    }
}
