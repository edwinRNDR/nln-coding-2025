import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 720
        height = 720
    }

    program {
        extend {
            drawer.fontMap = loadFont("data/fonts/default.otf", 32.0)
            for (i in 0 until 10) {
                drawer.text("LET THE MACHINES DO THE WORK", 40.0, 40.0 + i * 20.0)
            }
        }
    }
}
