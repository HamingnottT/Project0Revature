//package TEST

//to get applications to run you must pass in object extends app as a whole
//or a def main (args: Array[String]) clause

import java.sql.{Connection, DriverManager, SQLException}
import java.io.File
import java.io.FileNotFoundException
import java.util.{InputMismatchException, Scanner}
import scala.io.StdIn._

object GetData extends App {
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/project0"
  val username = "root"
  val password = "RiffRaff68#$"
  val scanner = new Scanner(System.in)
  var connection: Connection = DriverManager.getConnection(url, username, password)

  //val sysUserName = readLine("Username:")
  val TESTusername = "HamingnottT"
  val msgMain =
    """--------------------------------
      |Returning results in this order:
      |[Website] - [Username], [Password], [Email Address]
      |--------------------------------""".stripMargin

  //R - Get all websites of the application user

  def getAllWebsites(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(msgMain)
    val getAllSites = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername';")
    while ( getAllSites.next() ) {
      println(getAllSites.getString(1) + " - " + getAllSites.getString(2) + ", " + getAllSites.getString(3) + ", " + getAllSites.getString(4)) //testQuery1.getString(5), testQuery1.getString(6))
    }
  }

//recalls all functions to test
  getAllWebsites()
  connection.close()
}