package dashboard.weather

import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route

@Route("dashboard/weather")
class WeatherUI: VerticalLayout() {

    private val textField = TextField("Hello")

    init {
        add(textField)
    }
}