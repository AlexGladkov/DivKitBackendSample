import base.renderButton
import divkit.dsl.*

object ThirdSample {

    fun makeDivan(): Divan = divan {
        data(
            logId = "Page",
            div = stack(
                id = "Root",
                width = matchParentSize(),
                height = matchParentSize(),
                background = solidBackground(color(Colors.backgroundPrimary)).asList(),
                items = listOf(
                    container(
                        orientation = vertical,
                        width = matchParentSize(),
                        alignmentHorizontal = center,
                        alignmentVertical = center,
                        items = listOf(
                            text(
                                text = "Click Me",
                                fontSize = 32,
                                fontWeight = bold,
                                alignmentHorizontal = center
                            ),

                            renderButton(
                                text = "Hello, World",
                                background = solidBackground(color(Colors.accentColor)).asList(),
                                paddings = edgeInsets(all = 16),
                                textColor = color(Colors.textAccent),
                                margins = edgeInsets(16),
                                actions = listOf(
                                    action(
                                        logId = "BUTTON_CLICK",
                                        url = Url.create("sample-action://toast?message=Hello, World"),
                                        payload = mapOf(
                                            "event" to "local_click",
                                            "value" to "123"
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}