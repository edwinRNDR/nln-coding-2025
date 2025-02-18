import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.*
import org.openrndr.drawImage
import org.openrndr.extra.camera.Camera2D
import org.openrndr.extra.color.spaces.toOKHSVa
import org.openrndr.extra.imageFit.imageFit
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Matrix55
import org.openrndr.shape.Circle
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 1440
        height = 720
    }

    program {
        val img = loadImage("data/images/grayscale-8.jpg")
        println(img.format)

        val imgFix = drawImage(img.width, img.height) {
            drawer.image(img)
        }
        extend(Camera2D())
        extend {
            drawer.fontMap = loadFont("data/fonts/default.otf", 8.0)
            val shadow = imgFix.shadow
            shadow.download()

            drawer.stroke = ColorRGBa.BLACK
            drawer.drawStyle.blendMode = BlendMode.ADD
            //val table = listOf(" ", ".", ",", "-", "o", "O", "0")
            val table = listOf(" ", ".", ",", "-", "+", "o", "O", "0", "M")
            for (y in 0 until img.height step 4 ) {
                for (x in 0 until img.width step 4) {
                    val c = shadow[x * 2, y * 2]
                    drawer.fill = ColorRGBa.RED
                    drawer.text(table[(c.r * (table.size)).toInt().coerceIn(table.indices)], x*2.0, y*2.0)
                }
            }

            for (y in 0 until img.height step 4 ) {
                for (x in 0 until img.width step 4) {
                    val c = shadow[x * 2, y * 2]
                    drawer.fill = ColorRGBa.GREEN
                    drawer.text(table[(c.g * table.size).toInt().coerceIn(table.indices)], x*2.0, y*2.0)

                }
            }

            for (y in 0 until img.height step 4 ) {
                for (x in 0 until img.width step 4) {
                    val c = shadow[x * 2, y * 2]
                    drawer.fill = ColorRGBa.BLUE
                    drawer.text(table[(c.b * table.size).toInt().coerceIn(table.indices)], x*2.0, y*2.0)

                }
            }
        }
    }
}
