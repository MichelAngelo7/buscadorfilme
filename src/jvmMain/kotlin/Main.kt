import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.skia.Image
import java.net.URL

@Composable
@Preview
fun App() {
    val titulo = "Super Mario Bros. - O Filme"
    val nota = 7.4
    val ano = 2023
    val url =
        "https://m.media-amazon.com/images/M/MV5BZjA3MWM3MjMtYjk5Yy00NWRhLWIzM2ItYWY1MjcyNGIyYWU2XkEyXkFqcGdeQXVyMTU2MjY2Mjk3._V1_FMjpg_UX240_.jpg%20240w,%20https://m.media-amazon.com/images/M/MV5BZjA3MWM3MjMtYjk5Yy00NWRhLWIzM2ItYWY1MjcyNGIyYWU2XkEyXkFqcGdeQXVyMTU2MjY2Mjk3._V1_FMjpg_UY339_.jpg%20240w"



    MaterialTheme {
        Column {
            Text(titulo)
            Image(
                contentDescription = titulo,
                bitmap = url.loadImageBitmapByURL(),
                modifier = Modifier.width(200.dp)
            )
            Text("Nota: $nota - Ano: $ano")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

fun String.loadImageBitmapByURL(): ImageBitmap{
    val inputStream = URL(this).readBytes()
    return Image.makeFromEncoded(inputStream).toComposeImageBitmap()
}
