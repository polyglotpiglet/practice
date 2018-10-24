import javax.print.attribute.standard.JobOriginatingUserName

object Connector{

    fun connection(fn: DatabaseConnectionBuilder.() -> Unit): DatabaseConnection =
            DatabaseConnectionBuilder().apply(fn).build()
}

class DatabaseConnectionBuilder {
    var userName: String? = null
    var password: String? = null
    var host: String? = null
    var port: Int? = null

    fun build(): DatabaseConnection = DatabaseConnection(userName!!, password ?: "", host ?: "localhost", port!!)
}

data class DatabaseConnection(val userName: String,
                              val password: String,
                              val host: String,
                              val port: Int)