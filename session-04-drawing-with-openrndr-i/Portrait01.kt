import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb

import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extra.color.presets.SADDLE_BROWN
import org.openrndr.extra.color.spaces.toOKHSVa
import org.openrndr.extra.noise.uniform
import org.openrndr.extra.shadestyles.linearGradient
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {

    configure {
        width = 720
        height = 720
    }

    program {
        extend {
            drawer.clear(ColorRGBa.WHITE)
            drawer.stroke = null
            drawer.fill = ColorRGBa.PINK.toHSVa().shiftHue(mouse.position.x).toRGBa()

            val c = drawer.bounds.center
            drawer.circle(c, 200.0)

            // draw the left eye
            drawer.fill = ColorRGBa.WHITE
            drawer.circle(c.x - 100.0, c.y - 50.0, 50.0)
            drawer.fill = ColorRGBa.SADDLE_BROWN
            drawer.circle(c.x - 100.0, c.y - 50.0, 25.0)
            drawer.fill = ColorRGBa.BLACK
            drawer.circle(c.x - 100.0, c.y - 50.0, 12.5)

            // draw the right eye
            drawer.fill = ColorRGBa.WHITE
            drawer.circle(c.x + 100.0, c.y - 50.0, 50.0)
            drawer.fill = ColorRGBa.SADDLE_BROWN
            drawer.circle(c.x + 100.0, c.y - 50.0, 25.0)
            drawer.fill = ColorRGBa.BLACK
            drawer.circle(c.x + 100.0, c.y - 50.0, 12.5)

        }
    }
}
