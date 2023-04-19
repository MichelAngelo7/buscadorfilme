import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.skia.Image
import java.net.URL

@Composable
@Preview
fun App() {
    MaterialTheme(colors = darkColors()) {
        filmeParaExibir()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Buscador de Filmes",
        state = rememberWindowState(width = 200.dp, height = 400.dp),
    ) {
        App()
    }
}

fun String.loadImageBitmapByURL(): ImageBitmap {
    val inputStream = URL(this).readBytes()
    return Image.makeFromEncoded(inputStream).toComposeImageBitmap()
}

@Composable
fun filmeParaExibir(
    titulo: String = "Super Mario Bros. - O Filme",
    nota: Double = 7.4,
    ano: Int = 2023,
    url: String =
        "https://m.media-amazon.com/images/M/MV5BZjA3MWM3MjMtYjk5Yy00NWRhLWIzM2ItYWY1MjcyNGIyYWU2XkEyXkFqcGdeQXVyMTU2MjY2Mjk3._V1_FMjpg_UX240_.jpg%20240w,%20https://m.media-amazon.com/images/M/MV5BZjA3MWM3MjMtYjk5Yy00NWRhLWIzM2ItYWY1MjcyNGIyYWU2XkEyXkFqcGdeQXVyMTU2MjY2Mjk3._V1_FMjpg_UY339_.jpg%20240w"
) {

    Box {
        Column(
            Modifier.fillMaxWidth()
                .background(Color.Black)
        ) {
            Column(
                Modifier.fillMaxWidth()
                    .background(Color.Black)

            ) {

                Image(
                    contentDescription = titulo,
                    bitmap = url.loadImageBitmapByURL(),
                    modifier = Modifier.width(200.dp)
                )

                Row {
                    Text(nota.toString()  , color = Color.White, fontFamily =  FontFamily.SansSerif )
                    Text(ano.toString(), color = Color.White)
                }

                Text(titulo, color = Color.White)
            }
        }
    }
}