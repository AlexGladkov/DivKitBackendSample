import com.yandex.div.dsl.serializer.ColorSerializer
import divkit.dsl.*
import divkit.dsl.scope.DivScope
import divkit.dsl.*

object FirstSample {
    fun generateResponse(): DivKitResponse = DivKitResponse(
        templates = DivKitTemplate(),
        card = DivKitCard(
            logId = "example_log",
            states = listOf(
                SampleState(
                    stateId = 0,
                    div = SampleDiv(
                        type = "text",
                        text = "Hello, DivKit",
                        margins = DivKitPaddings(top = 16, bottom = 16, left = 16, right = 16),
                    )
                )
            )
        )
    )
}

data class DivKitResponse(val templates: DivKitTemplate, val card: DivKitCard)

class DivKitTemplate

class DivKitCard(val logId: String, val states: List<SampleState>)

data class SampleState(val stateId: Int, val div: SampleDiv)

data class SampleDiv(
    val type: String,
    val text: String? = null,
    val title: String? = null,
    val imageUrl: String? = null,
    val margins: DivKitPaddings? = null,
    val custom: String? = null,
    val items: List<SampleDiv>? = null,
    val links: List<TutorialLinks>? = null,
)