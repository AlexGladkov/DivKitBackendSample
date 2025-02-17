object SecondSample {
    fun generateResponse(): DivKitSecondResponse = DivKitSecondResponse(
        templates = DivKitSecondTemplate(
            tutorialCard = TutorialCard(
                type = "container",
                items = listOf(
                    TutorialItem(
                        type = "text",
                        fontSize = 22,
                        fontWeight = "bold",
                        margins = DivKitPaddings(bottom = 16),
                        text = "title"
                    ),
                    TutorialItem(
                        type = "text",
                        fontSize = 16,
                        margins = DivKitPaddings(bottom = 16),
                        text = "custom"
                    ),
                    TutorialItem(
                        type = "container",
                        items = "links"
                    )
                ),
                link = TutorialTemplateLink(
                    type = "text",
                    fontSize = 14,
                    action = TutorialLinkTemplateAction(
                        url = "link",
                        logId = "log"
                    ),
                    margins = DivKitPaddings(bottom = 2),
                    textColor = "#0000ff",
                    underline = "single",
                    text = "link_text"
                ),
                margins = DivKitPaddings(bottom = 6),
                orientation = "vertical",
                paddings = DivKitPaddings(
                    top = 10,
                    bottom = 0,
                    left = 30,
                    right = 30
                )
            )
        ),
        card = DivKitCard(
            logId = "div2_sample_card",
            states = listOf(
                SampleState(
                    stateId = 0,
                    div = SampleDiv(
                        type = "container",
                        items = listOf(
                            SampleDiv(
                                type = "image",
                                imageUrl = "https://yastatic.net/s3/home/divkit/logo.png",
                                margins = DivKitPaddings(
                                    top = 10, right = 60, bottom = 10, left = 60
                                )
                            ),
                            SampleDiv(
                                type = "tutorialCard",
                                title = "DivKit",
                                custom = "What is DivKit and why did I get here?\n\nDivKit is a new Yandex open source framework that helps speed up mobile development.\n\niOS, Android, Web — update the interface of any applications directly from the server, without publishing updates.\n\nFor 5 years we have been using DivKit in the Yandex search app, Alice, Edadeal, Market, and now we are sharing it with you.\n\nThe source code is published on GitHub under the Apache 2.0 license.",
                                links = listOf(
                                    TutorialLinks(
                                        type = "link",
                                        linkText = "More about DivKit",
                                        link = "tgdk",
                                        log = "landing"
                                    ),
                                    TutorialLinks(
                                        type = "link",
                                        linkText = "Documentation",
                                        link = "https://divkit.tech/doc/",
                                        log = "docs"
                                    ),TutorialLinks(
                                        type = "link",
                                        linkText = "News channel",
                                        link = "https://t.me/divkit_news",
                                        log = "tg_news"
                                    ),
                                    TutorialLinks(
                                        type = "link",
                                        linkText = "EN Community chat",
                                        link = "https://t.me/divkit_community_en",
                                        log = "tg_en_chat"
                                    ),
                                    TutorialLinks(
                                        type = "link",
                                        linkText = "RU Community chat",
                                        link = "https://t.me/divkit_community_ru",
                                        log = "tg_ru_chat"
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

data class DivKitSecondResponse(val templates: DivKitSecondTemplate, val card: DivKitCard)

data class DivKitSecondTemplate(val tutorialCard: TutorialCard)

data class TutorialCard(
    val type: String,
    val items: List<TutorialItem>,
    val orientation: String,
    val paddings: DivKitPaddings,
    val margins: DivKitPaddings,
    val link: TutorialTemplateLink
)

data class TutorialItem(
    val type: String,
    val fontSize: Int? = null,
    val fontWeight: String? = null,
    val margins: DivKitPaddings? = null,
    val text: String? = null,
    val items: String? = null,
)

data class DivKitPaddings(
    val top: Int? = null,
    val bottom: Int? = null,
    val left: Int? = null,
    val right: Int? = null
)

data class TutorialTemplateLink(
    val type: String,
    val fontSize: Int? = null,
    val margins: DivKitPaddings? = null,
    val textColor: String? = null,
    val underline: String? = null,
    val action: TutorialLinkTemplateAction? = null,
    val text: String? = null
)

data class TutorialLinkTemplateAction(
    val url: String,
    val logId: String
)

data class TutorialLinks(
    val type: String,
    val linkText: String,
    val link: String,
    val log: String
)