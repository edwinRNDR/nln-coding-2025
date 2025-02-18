import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.*
import org.openrndr.drawImage
import org.openrndr.extra.color.spaces.toOKHSVa
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
        val imgFix = drawImage(img.width, img.height) {
            drawer.image(img)
        }
        extend {
            val shadow = imgFix.shadow
            shadow.download()

            drawer.stroke = ColorRGBa.BLACK

            //val table = listOf(" ", ".", ",", "-", "o", "O", "0")
            val table = listOf(" ", ".", ",", "-", "+", "o", "O", "0", "M")
            for (y in 0 until img.height step 4 ) {
                for (x in 0 until img.width step 4) {
                    val c = shadow[x * 2, y * 2]
                    drawer.fill = ColorRGBa.WHITE.shade(c.luminance)
                    //drawer.fill = ColorRGBa.RED.toHSVa().shiftHue(c.luminance * 180.0).toRGBa()
                    //drawer.circle(x * 1.0, y * 1.0, 5.0)
                    drawer.fill = ColorRGBa.WHITE
                    drawer.text(table[(c.luminance * table.size).toInt()], x*2.0, y*2.0)
                    //                    if (c.luminance > 0.5) {
//                        drawer.text("+", x * 1.0, y * 1.0)
//                    }

                }
            }

        }
    }
}
