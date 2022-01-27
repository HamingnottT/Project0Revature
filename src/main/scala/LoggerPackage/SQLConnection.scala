package LoggerPackage
import java.sql.{Connection, DriverManager, SQLException}
import java.io.File
import java.io.FileNotFoundException
import java.util.{InputMismatchException, Scanner}
import scala.io.StdIn._

object SQLConnection{
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/project0"
  val username = "root"
  val password = "RiffRaff68#$"
  val scanner = new Scanner(System.in)
  var connection:Connection = DriverManager.getConnection(url, username, password)

}
