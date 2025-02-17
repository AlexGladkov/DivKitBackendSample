import base.renderButton
import base.renderOutlinedButton
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.yandex.div.dsl.model.DivAction
import divkit.dsl.*
import divkit.dsl.Url
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.cors.routing.*

fun main() {
    embeddedServer(Netty, port = 9090, host = "0.0.0.0") {
        install(CORS) {
            anyHost()
            allowMethod(HttpMethod.Get)
            allowMethod(HttpMethod.Post)
            allowHeader(HttpHeaders.ContentType)
            allowHeader(HttpHeaders.Authorization)
            allowCredentials = true // Разрешаем куки/авторизацию
        }

        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT) // Красивый JSON
                registerModule(kotlinModule()) // Поддержка Kotlin data классов
                disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // Формат дат как строки
            }
        }

        routing {
            get("/") {
                call.respond(ForthSample.makeDivan())
            }
        }
    }.start(wait = true)
}