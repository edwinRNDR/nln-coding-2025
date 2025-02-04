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
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import org.openrndr.shape.Ellipse
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

            drawer.fill = ColorRGBa.RED.opacify(0.5)
            drawer.circle(c.x, c.y+50.0, 25.0)

            drawer.fill = ColorRGBa.RED
            val mouth = Ellipse(c.x, c.y + 100.0, 100.0, 20.0)
            drawer.contour(mouth.contour)

            drawer.stroke = ColorRGBa.BLACK
            drawer.strokeWeight = 10.0

            val browShape = mouse.position.x / width

            val leftBrow = Ellipse(c.x - 100.0, c.y - 100.0, 100.0, 20.0).contour.sub(browShape + 0.2, browShape + 0.5)
            drawer.contour(leftBrow)

            val rightBrow = Ellipse(c.x + 100.0, c.y - 100.0, 100.0, 20.0).contour.sub(0.0 - browShape, 0.3 - browShape)
            drawer.contour(rightBrow)

            val head = Circle(c, 200.0).contour.sub(0.1, 0.4)
            drawer.contour(head)

            for (i in 0 until 21) {
                drawer.lineSegment(
                    head.position(i/20.0), 
                    head.position(i/20.0) + Vector2(0.0, -Double.uniform(5.0, 20.0))
                )
            }
        }
    }
}
