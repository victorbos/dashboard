package dashboard.weather

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import dashboard.weather.uicomponents.FloatField

@Theme(value = Lumo::class, variant = Lumo.DARK)
@Route("dashboard/weather")
class WeatherUI(
        private val weatherService: WeatherService
) : VerticalLayout() {

    private val temperatureField = FloatField("Temperatuur", 1)

    init {
        add(temperatureField)
        refresh()
    }


    private fun refresh() {
        val darkSkyForecast = weatherService.darkSkyForecast()

        temperatureField.value = darkSkyForecast.currently.temperature
    }
}