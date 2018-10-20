package dashboard.weather.uicomponents

import com.vaadin.flow.component.Composite
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.textfield.TextField
import dashboard.util.toString

class FloatField(
        private val label: String,
        private val digits: Int
) : Composite<Div>() {

    private val labelComponent = Label()
    private val valueComponent = TextField()

    init {
        labelComponent.text = label
        labelComponent.width = "25vw"
        labelComponent.style.set("align-self", "center")

        valueComponent.isReadOnly = true
        valueComponent.style.set("align", "right")
        valueComponent.element.setAttribute("theme", "align-right")
        valueComponent.width = "10vw"

        val layout = HorizontalLayout(labelComponent, valueComponent)
        layout.isSpacing = true

        content.add(layout)
    }

    var value: Float? = 0f
        set(value) {
            valueComponent.value = value?.toString(digits) ?: "--"
        }
}