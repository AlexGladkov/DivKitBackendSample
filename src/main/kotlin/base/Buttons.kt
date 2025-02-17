package base

import divkit.dsl.*
import divkit.dsl.scope.DivScope

fun DivScope.renderButton(
    text: String,
    actions: List<Action>,
    margins: EdgeInsets = edgeInsets(),
    paddings: EdgeInsets = edgeInsets(),
    textColor: Color = color(Colors.textPrimary),
    background: List<Background> = solidBackground(color(Colors.backgroundPrimary)).asList(),
): Div {
    return text(
        width = matchParentSize(),
        height = fixedSize(50),
        text = text,
        fontWeight = medium,
        fontSize = 16,
        textColor = textColor,
        margins = margins,
        actions = actions,
        paddings = paddings,
        background = background,
        border = border(cornerRadius = 8),
        textAlignmentHorizontal = center,
        textAlignmentVertical = center,
    )
}

fun DivScope.renderOutlinedButton(
    text: String,
    actions: List<Action>,
    margins: EdgeInsets = edgeInsets(),
): Div {
    return text(
        width = matchParentSize(),
        height = fixedSize(50),
        text = text,
        fontWeight = medium,
        fontSize = 16,
        textColor = color(Colors.textPrimary),
        margins = margins,
        actions = actions,
        border = border(
            cornerRadius = 8,
            stroke = stroke(
                color = color(Colors.backgroundPrimary),
                width = 1.0
            )
        ),
        textAlignmentHorizontal = center,
        textAlignmentVertical = center,
    )
}