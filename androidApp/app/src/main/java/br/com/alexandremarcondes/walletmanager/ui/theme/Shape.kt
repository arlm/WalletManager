package br.com.alexandremarcondes.walletmanager.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlin.reflect.KProperty1

var noCornerShape = RectangleShape

val smallCutShape50 = ShapeCatalog(CutCornerShape::class, 50)
val extraSmallCutShape = ShapeCatalog(CutCornerShape::class, 4.dp)
val smallCutShape = ShapeCatalog(CutCornerShape::class, 8.dp)
val tvMediumCutShape = ShapeCatalog(CutCornerShape::class, 12.dp)
val mediumCutShape = ShapeCatalog(CutCornerShape::class, 16.dp)
val tvLargeCutShape = ShapeCatalog(CutCornerShape::class, 16.dp)
val largeCutShape = ShapeCatalog(CutCornerShape::class, 24.dp)
val tvExtraLargeCutShape = ShapeCatalog(CutCornerShape::class, 28.dp)
val extraLargeCutShape = ShapeCatalog(CutCornerShape::class, 32.dp)

val circleShape = ShapeCatalog(RoundedCornerShape::class, 50)
val extraSmallRoundShape = ShapeCatalog(RoundedCornerShape::class, 4.dp)
val smallRoundShape = ShapeCatalog(RoundedCornerShape::class, 8.dp)
val tvMediumRoundShape = ShapeCatalog(RoundedCornerShape::class, 12.dp)
val mediumRoundShape = ShapeCatalog(RoundedCornerShape::class, 16.dp)
val tvLargeRoundShape = ShapeCatalog(RoundedCornerShape::class, 16.dp)
val largeRoundShape = ShapeCatalog(RoundedCornerShape::class, 24.dp)
val tvExtraLargeRoundShape = ShapeCatalog(RoundedCornerShape::class, 28.dp)
val extraLargeRoundShape = ShapeCatalog(RoundedCornerShape::class, 32.dp)

class ShapeCatalogParameters
    : PreviewParameterProvider<KProperty1<ShapeCatalog<*>, CornerBasedShape>> {
    override val values = sequenceOf(
        ShapeCatalog<*>::full,
        ShapeCatalog<*>::top, ShapeCatalog<*>::bottom,
        ShapeCatalog<*>::start, ShapeCatalog<*>::end,
        ShapeCatalog<*>::topStartBottomEnd, ShapeCatalog<*>::bottomStartTopEnd
    )
    override val count: Int
        get() = values.count()
}

val shapes = Shapes(
    extraSmall = extraSmallRoundShape.full,
    small = smallRoundShape.full,
    medium = mediumRoundShape.full,
    large = largeRoundShape.full,
    extraLarge = extraLargeRoundShape.full
)

class ShapesParameters
    : PreviewParameterProvider<KProperty1<Shapes, CornerBasedShape>> {
    override val values = sequenceOf(
        Shapes::extraSmall, Shapes::small,
        Shapes::medium,
        Shapes::large, Shapes::extraLarge
    )
    override val count: Int
        get() = values.count()
}

@LightDynamicBluePreview
@Composable
fun ShapesPreview(@PreviewParameter(ShapesParameters::class) property: KProperty1<Shapes, CornerBasedShape>) {
    ApplicationTheme {
        CardPreview(property(MaterialTheme.shapes))
    }
}

@Composable
private fun CardPreview(shapeSize: CornerBasedShape) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = shapeSize,
    ) {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = shapeSize
        ) {
            ConstraintLayout(modifier = Modifier.padding(8.dp)) {
                val (
                    title, divider, label, textField, leftButton, rightButton
                ) = createRefs()

                Text(
                    modifier = Modifier.constrainAs(title) {
                        top.linkTo(parent.top)
                    },
                    text = "Card Size",
                    style = MaterialTheme.typography.headlineLarge
                )

                HorizontalDivider(
                    modifier = Modifier.constrainAs(divider) {
                        top.linkTo(title.bottom, margin = 8.dp)
                    },
                    thickness = 1.dp,
                    color = Color.Black
                )

                val textState = remember { mutableStateOf(TextFieldValue()) }

                Text(
                    modifier = Modifier.constrainAs(label) {
                        top.linkTo(divider.bottom, margin = 8.dp)
                        centerVerticallyTo(textField)
                        start.linkTo(parent.start, margin = 4.dp)
                    },
                    text = "Name:", textAlign = TextAlign.Start
                )

                TextField(
                    modifier = Modifier.constrainAs(textField) {
                        top.linkTo(divider.bottom, margin = 8.dp)
                        end.linkTo(parent.end, margin = 4.dp)
                    },
                    value = textState.value,
                    onValueChange = { textState.value = it }
                )

                ExtendedFloatingActionButton(
                    modifier = Modifier.constrainAs(leftButton) {
                        top.linkTo(textField.bottom, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                        start.linkTo(parent.start, margin = 4.dp)
                    },
                    icon = { Icon(Icons.Filled.Done, "Done") },
                    text = { Text("Done") },
                    onClick = { /*do something*/ },
                    elevation = FloatingActionButtonDefaults.elevation(8.dp)
                )

                FloatingActionButton(
                    modifier = Modifier.constrainAs(rightButton) {
                        top.linkTo(textField.bottom, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                        end.linkTo(parent.end, margin = 4.dp)
                    },
                    shape = shapeSize,
                    elevation = FloatingActionButtonDefaults.elevation(8.dp),
                    onClick = {}
                ) { Icon(Icons.Filled.Add, "Add") }
            }
        }
    }
}

@Preview(name = "Simple Shapes", group = "simple")
@Composable
fun SimpleShapesPreview(@PreviewParameter(ShapeCatalogParameters::class) property: KProperty1<ShapeCatalog<*>, CornerBasedShape>) {
    Column {
        Row {
            ShapePreview("rectangle", noCornerShape)
        }
        Row {
            ShapePreview("${property.name}\ncircle", property(circleShape))
            ShapePreview(
                "${property.name}\ncircle",
                property(circleShape),
                width = 75.dp,
                height = 75.dp
            )
        }
    }
}

@Preview(name = "Cut Shapes", group = "cut")
@Composable
fun CutShapesPreview(@PreviewParameter(ShapeCatalogParameters::class) property: KProperty1<ShapeCatalog<*>, CornerBasedShape>) {
    Column {
        Row {
            ShapePreview("${property.name}\nsmall cut 50%", property(smallCutShape50))
        }
        Row {
            ShapePreview("${property.name}\nextra small cut", property(extraSmallCutShape))
            ShapePreview("${property.name}\nsmall cut", property(smallCutShape))
        }
        Row {
            ShapePreview("${property.name}\nmedium cut", property(mediumCutShape))
        }
        Row {
            ShapePreview("${property.name}\nlarge cut", property(largeCutShape))
            ShapePreview("${property.name}\nextra large cut", property(extraLargeCutShape))
        }
        Row {
            ShapePreview("${property.name}\nTV medium round", property(tvMediumCutShape))
        }
        Row {
            ShapePreview("${property.name}\nTV large round", property(tvLargeCutShape))
            ShapePreview("${property.name}\nTV extra large round", property(tvExtraLargeCutShape))
        }
    }
}


@Preview(name = "Round Shapes", group = "round")
@Composable
fun FullRoundShapesPreview(@PreviewParameter(ShapeCatalogParameters::class) property: KProperty1<ShapeCatalog<*>, CornerBasedShape>) {
    Column {
        Row {
            ShapePreview("${property.name}\nsmall round 50%", property(circleShape))
        }
        Row {
            ShapePreview("${property.name}\nextra small round", property(extraSmallRoundShape))
            ShapePreview("${property.name}\nsmall round", property(smallRoundShape))
        }
        Row {
            ShapePreview("${property.name}\nmedium round", property(mediumRoundShape))
        }
        Row {
            ShapePreview("${property.name}\nlarge round", property(largeRoundShape))
            ShapePreview("${property.name}\nextra large round", property(extraLargeRoundShape))
        }
        Row {
            ShapePreview("${property.name}\nTV medium round", property(tvMediumRoundShape))
        }
        Row {
            ShapePreview("${property.name}\nTV large round", property(tvLargeRoundShape))
            ShapePreview("${property.name}\nTV extra large round", property(tvExtraLargeRoundShape))
        }
    }
}

@Composable
private fun ShapePreview(
    name: String,
    shapeSize: Shape,
    width: Dp = 175.dp,
    height: Dp = 75.dp
) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .padding(4.dp)
            .border(
                border = BorderStroke(1.dp, md_theme_light_onPrimary),
                shape = shapeSize
            )
            .clip(shapeSize)
            .background(md_theme_light_primary),
        contentAlignment = Alignment.Center
    ) {
        BasicText(
            text = name,
            modifier = Modifier.padding(8.dp, 4.dp),
            style = bodySmall.plus(TextStyle(color = md_theme_light_onPrimary))
        )
    }
}