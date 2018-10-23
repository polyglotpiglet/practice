import database.*

import java.net.InetAddress
import java.net.UnknownHostException
import java.nio.charset.Charset


/**
 * Convert this file to Kotlin, then alter the code to use the Kotlin "apply" expression instead of assignment:
 *
 * Can you reduce the entire function to a single expression with no return statement?
 */
class DatabaseConnectionBuilder {

    @Throws(UnknownHostException::class)
    fun build(username: String, password: String, host: String, databasePortNumber: Int): DatabaseConnection {

        val credentials = Credentials(username).apply {
            this.charsetForDatabase = Charset.defaultCharset()
            this.passwordForDatabase = password

        }

        val port = Port().apply {
            this.databasePortNumber = databasePortNumber
        }

        val database = Database().apply {
            this.databaseInetAddress = InetAddress.getByName(host)
            this.databasePort = port
        }

        return DatabaseConnection().apply {

            this.applyDatabaseTransactionRetryBehaviour(TransactionRetryBehaviour.Retry)
            this.databaseCredentials = credentials
            this.database = database

        }
    }

    @Throws(UnknownHostException::class)
    fun build2(username: String, password: String, host: String, databasePortNumber: Int): DatabaseConnection =
            DatabaseConnection().apply {
                this.applyDatabaseTransactionRetryBehaviour(TransactionRetryBehaviour.Retry)
                this.databaseCredentials = Credentials(username).apply {
                    charsetForDatabase = Charset.defaultCharset()
                    passwordForDatabase = password

                }
                this.database = Database().apply {
                    databaseInetAddress = InetAddress.getByName(host)
                    databasePort = Port().apply {
                        this.databasePortNumber = databasePortNumber
                    }
                }
            }
}
