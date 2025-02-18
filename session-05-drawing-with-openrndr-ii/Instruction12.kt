import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.extra.color.tools.shiftHue
import org.openrndr.extra.shapes.primitives.regularPolygon
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
            val r = drawer.bounds
           // drawer.rectangle(r)


            val stagger = mouse.position.x / width
            val spacing = 10.0
            val speed = 0.1
            for (i in 0 until 30) {
                val c = regularPolygon(6, drawer.bounds.center, 50.0 + i * spacing, seconds * -36.0)
                val c2 = c.sub(seconds * speed + i * stagger, seconds * speed + stagger * i + 0.4)
                drawer.strokeWeight = cos(seconds + i * 0.1) * 3.0 + 4.0
                drawer.stroke = ColorRGBa.RED.toHSVa()
                    .shiftHue(seconds * 40 + i * 3.0).toRGBa()
                drawer.contour(c2)

            }
        }
    }
}
