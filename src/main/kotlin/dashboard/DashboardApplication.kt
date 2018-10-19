package dashboard

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class DashboardApplication

fun main(args: Array<String>) {
    SpringApplication.run(DashboardApplication::class.java, *args)
}