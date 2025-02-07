import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
                        text = "Hello, DivKit"
                    )
                )
            )
        )
    )
}

@Serializable
data class DivKitResponse(val templates: DivKitTemplate, val card: DivKitCard)

@Serializable
class DivKitTemplate

@Serializable
class DivKitCard(@SerialName("log_id") val logId: String, val states: List<SampleState>)

@Serializable
data class SampleState(@SerialName("state_id") val stateId: Int, val div: SampleDiv)

@Serializable
data class SampleDiv(
    @SerialName("type") val type: String,
    @SerialName("text") val text: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("image_url") val imageUrl: String? = null,
    @SerialName("margins") val margins: DivKitPaddings? = null,
    @SerialName("custom") val custom: String? = null,
    @SerialName("items") val items: List<SampleDiv>? = null,
    @SerialName("links") val links: List<TutorialLinks>? = null
)