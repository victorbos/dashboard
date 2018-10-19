package dashboard.weather

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import feign.Feign
import feign.Param
import feign.RequestLine
import feign.jackson.JacksonDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


interface DarkSkyClient {

    @RequestLine("GET /forecast/{key}/{latitude},{longitude}?lang=nl&units=si")
    fun forecast(
            @Param("key") key: String,
            @Param("latitude") latitude: String,
            @Param("longitude") longitude: String): DarkSkyForecast
}

@Configuration
class WheatherConfiguration {

    @Bean
    fun darkSkyClient(): DarkSkyClient =
            Feign.builder()
                    .decoder(
                            JacksonDecoder(
                                    jacksonObjectMapper()
                                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            )
                    )
                    .target(DarkSkyClient::class.java, "https://api.darksky.net")
}