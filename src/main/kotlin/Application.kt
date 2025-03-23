import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.kotlinModule
import divkit.dsl.*
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.cors.routing.*
import kotlin.random.Random
import kotlin.random.asJavaRandom

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
                val rnd = Random(0)
                    .asJavaRandom()
                    .nextInt(0, 10)
                println("Rnd $rnd")
                if (rnd % 2 == 0) {
                    call.respond(ForthSample.makeDivan())
                } else {
                    call.respond(divan {
                        data(
                            logId = "Not Found",
                            div = stack(
                                items = listOf(
                                    text(
                                        text = "Not Found",
                                        fontSize = 48,
                                        alignmentHorizontal = center,
                                        alignmentVertical = center
                                    )
                                )
                            )
                        )
                    })
                }
            }

            get("/screen") {
                call.respond(ThirdSample.makeDivan())
            }
        }
    }.start(wait = true)
}