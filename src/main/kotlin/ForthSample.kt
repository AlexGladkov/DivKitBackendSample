import base.renderButton
import divkit.dsl.*

object ForthSample {

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
                        height = matchParentSize(),
                        alignmentHorizontal = start,
                        alignmentVertical = top,
                        items = listOf(
                            image(
                                imageUrl = url("https://natureconservancy-h.assetsadobe.com/is/image/content/dam/tnc/nature/en/photos/y/i/YingHanAL.jpg?crop=0%2C25%2C4000%2C2200&wid=4000&hei=2200&scl=1.0"),
                                margins = edgeInsets(top = 32, start = 16, bottom = 16, end = 16)
                            ),
                            text(
                                text = "Embark on a Stunning Arctic Adventure! ❄\uFE0F✨",
                                textColor = color(Colors.textPrimary),
                                margins = edgeInsets(top = 16, start = 16, bottom = 16, end = 16),
                                fontSize = 36,
                                fontWeight = medium
                            ),
                            text(
                                text = "Experience the breathtaking beauty of the Arctic—majestic glaciers, dancing Northern Lights, and rare wildlife. Travel in comfort, explore untouched landscapes, and create unforgettable memories. Adventure awaits! \uD83C\uDF0D\uD83D\uDD25",
                                textColor = color(Colors.textPrimary),
                                margins = edgeInsets(all = 16),
                                fontSize = 14,
                                fontWeight = regular
                            ),
                            container(
                                height = matchParentSize(weight = 1.0)
                            ),
                            container(
                                orientation = horizontal,
                                margins = edgeInsets(start = 16, end = 16, top = 8, bottom = 8),
                                items = listOf(
                                    text(text = "Time Spend", fontSize = 16, textColor = color(Colors.textPrimary)),
                                    container(width = matchParentSize(weight = 1.0)),
                                    text(
                                        text = "2 weeks",
                                        fontSize = 24,
                                        textColor = color(Colors.textPrimary),
                                        fontWeight = bold,
                                        textAlignmentHorizontal = end
                                    )
                                )
                            ),
                            container(
                                orientation = horizontal,
                                margins = edgeInsets(start = 16, end = 16, top = 8, bottom = 24),
                                items = listOf(
                                    text(text = "Price", fontSize = 16, textColor = color(Colors.textPrimary)),
                                    container(width = matchParentSize(weight = 1.0)),
                                    text(
                                        text = "999.99$",
                                        fontSize = 24,
                                        textColor = color(Colors.textPrimary),
                                        fontWeight = bold,
                                        textAlignmentHorizontal = end
                                    )
                                )
                            ),
                            renderButton(
                                text = "Book Now!",
                                background = solidBackground(color(Colors.accentColor)).asList(),
                                paddings = edgeInsets(all = 16),
                                margins = edgeInsets(start = 16, end = 16, bottom = 16),
                                textColor = color(Colors.textAccent),
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