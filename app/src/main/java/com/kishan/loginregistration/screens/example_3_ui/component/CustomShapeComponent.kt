package com.kishan.loginregistration.screens.example_3_ui.component

import android.graphics.PointF
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.plus
import androidx.core.graphics.times
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

//radial to Cartesian
internal fun Float.toRadians() = this * PI.toFloat() / 180f
internal val PointZero = PointF(0f,0f)
internal fun radialToCartesian(
    radius:Float,
    angleRadius:Float,
    center:PointF = PointZero
) = directionVectorPointF(angleRadius) * radius + center

internal fun directionVectorPointF(angleRadius: Float) = PointF(cos(angleRadius), sin(angleRadius))



@Composable
@Preview
fun Polygon() {
    Box(modifier = Modifier
        .drawWithCache {
            val roundedPolygon = RoundedPolygon(
                numVertices = 4,
                radius = size.minDimension / 5,
                centerX = size.width / 2,
                centerY = size.height / 2
            )
            val roundedPolygonPath = roundedPolygon
                .toPath()
                .asComposePath()
            onDrawBehind {
                drawPath(roundedPolygonPath, color = Color.Blue)
            }
        }
        .fillMaxSize()
    )
}



//heart shape

@Composable
fun StarShape(mySize : Dp) {

    val vertices = remember {
        val radius = 1f
        val innerRadius = .2f
        floatArrayOf(
            radialToCartesian(radius, 0f.toRadians()).x,
            radialToCartesian(radius, 0f.toRadians()).y,
            radialToCartesian(innerRadius, 40f.toRadians()).x,
            radialToCartesian(innerRadius, 40f.toRadians()).y,
            radialToCartesian(radius, 90f.toRadians()).x,
            radialToCartesian(radius, 90f.toRadians()).y,
            radialToCartesian(innerRadius, 140f.toRadians()).x,
            radialToCartesian(innerRadius, 140f.toRadians()).y,
            radialToCartesian(radius, 180f.toRadians()).x,
            radialToCartesian(radius, 180f.toRadians()).y,
            radialToCartesian(innerRadius,220f.toRadians()).x,
            radialToCartesian(innerRadius,220f.toRadians()).y,
            radialToCartesian(radius , 270f.toRadians()).x,
            radialToCartesian(radius , 270f.toRadians()).y,
            radialToCartesian(innerRadius, 320f.toRadians()).x,
            radialToCartesian(innerRadius, 320f.toRadians()).y,
        )
    }

    val rounding = remember {
        val roundingNormal = 0.6f
        val roundingNone = 0f
        listOf(
            CornerRounding(roundingNormal),
            CornerRounding(roundingNone),
            CornerRounding(roundingNormal),
            CornerRounding(roundingNormal),
            CornerRounding(roundingNone),
            CornerRounding(roundingNormal),
        )
    }

    val polygon = remember(vertices, rounding) {
        RoundedPolygon(
            vertices = vertices,
        )
    }

    Box(
        modifier = Modifier
            .drawWithCache {
                val roundedPolygonPath = polygon
                    .toPath()
                    .asComposePath()
                onDrawBehind {
                    scale(size.width * 0.5f, size.width * 0.5f) {
                        translate(size.width * 0.5f, size.height * 0.5f) {
                            drawPath(roundedPolygonPath, color = Color(0xFFFFFFFF))
                        }
                    }
                }
            }
            .size(mySize)
    )
}

@Composable
fun CustomHeaderDraw(modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        StarShape(mySize = 50.dp)
        HorizontalDivider(modifier = Modifier.width(270.dp))
    }
}

@Preview
@Composable
private fun DefaultPreview() {
//    StarShape(mySize = 50.dp)
    CustomHeaderDraw(modifier = Modifier)

}