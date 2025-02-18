import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.*
import org.openrndr.extra.imageFit.imageFit
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Matrix55
import org.openrndr.shape.Circle
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 720
        height = 720
    }

    program {
        val img = loadImage("data/images/cheeta.jpg")
        extend {
            //drawer.image(img, 0.0, 0.0)
            //drawer.drawStyle.colorMatrix = tint( ColorRGBa.WHITE.opacify(0.2) )
            //drawer.drawStyle.colorMatrix = Matrix55.IDENTITY
            drawer.drawStyle.colorMatrix = grayscale()
            drawer.imageFit(img, drawer.bounds)

            drawer.drawStyle.colorMatrix = invert * tint(ColorRGBa.WHITE.opacify(0.5))
            drawer.imageFit(img, drawer.bounds.offsetEdges(-50.0))
        }
    }
}
