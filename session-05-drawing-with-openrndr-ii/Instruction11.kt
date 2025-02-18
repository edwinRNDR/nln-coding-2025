import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
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
            // this is a comment
            val r = drawer.bounds
            drawer.rectangle(r)

            // primitives
            // Circle, Rectangle, Ellipse, LineSegment

            //val c = drawer.bounds.offsetEdges(-50.0).contour
            //val c = Circle(drawer.bounds.center, 250.0).contour
            //val e = Ellipse
            val c = regularPolygon(5, drawer.bounds.center, 250.0)

            val p = c.position(mouse.position.y / height)
            drawer.circle(p, 50.0)

            val c2 = c.sub(0.0, mouse.position.x / width)
            drawer.contour(c2)
        }
    }
}
