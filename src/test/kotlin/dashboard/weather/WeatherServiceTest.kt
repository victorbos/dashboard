package dashboard.weather

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class WeatherServiceTest {

    @Autowired
    lateinit var weatherService: WeatherService

    @Test
    fun getForecast() {

        val forecast = weatherService.darkSkyForecast()
        print(forecast)

    }

}