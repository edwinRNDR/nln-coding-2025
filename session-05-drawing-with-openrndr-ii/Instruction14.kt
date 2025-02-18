import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.shape.Circle
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 720
        height = 720
    }

    program {

//        extend(ScreenRecorder()) {
//            maximumDuration = 10.0
//        }
        extend {
            //val c = drawer.bounds.offsetEdges(-100.0).contour
            val c = Circle(drawer.bounds.center, 200.0).contour

            drawer.fontMap = loadFont("data/fonts/default.otf", 32.0)
            for (i in 0 until 50) {
                // 1.1
                // (1.1).mod(1.0) == 0.1
                //val pos = c.position(seconds * 0.01 + i / 50.0)
                val pos = c.position( (i / 50.0 + seconds * 0.1).mod(1.0) )
                //val pos = c.position((seconds * 0.01 + i / 50.0).mod(1.0))
                drawer.text("A VERY LONG TEXT WILL BE LIKE THIS", pos.x -250.0, pos.y)
            }
        }
    }
}
