package app

import data.HelloMessageData
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import service.HelloService
import service.HelloServiceImpl

val helloModule = module {
    single { HelloMessageData() }
    single { HelloServiceImpl(get()) as HelloService }
}

class HelloApplication : KoinComponent {
    // Inject HelloService
    val helloService by inject<HelloService>()

    // display our data
    fun sayHello() = println(helloService.hello())
}

fun main(vararg args: String) {
    startKoin(listOf(helloModule))
    HelloApplication().sayHello()
}