import configuration.AppConfig
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import resources.TodoController

class App : Application<AppConfig>()
{
    companion object {
        @JvmStatic fun main(args : Array<String>) = App().run(*args)
    }
    override fun run(config: AppConfig, env: Environment) {
        env.jersey().register(TodoController())
    }
}

