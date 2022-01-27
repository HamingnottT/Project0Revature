import java.sql.{Connection, DriverManager, SQLException}
import java.io.File
import java.io.FileNotFoundException
import java.util.{InputMismatchException, Scanner}
import scala.io.StdIn._

object CredLogger {
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/project0"
  val username = "root"
  val password = "RiffRaff68#$"
  val scanner = new Scanner(System.in)
  var connection:Connection = DriverManager.getConnection(url, username, password)
  //private val sysAdmin =
  //private val sysAdminPass =
  //val statement = connection.createStatement()
  //var testQuery = statement.executeQuery("SELECT * FROM project0.sql_user;")
  //println(testQuery)

  val sysUserName = readLine("What is your Username? ")
  //var sysPassword = readLine("What is your Username? ")

  lazy val whereTo: String = readLine("What information are you looking for today? ")


  def website(): Unit = {
    lazy val webQuery: String = readLine("What website are you looking for? ")
    lazy val continue = readLine("Continue [Y/N]? ")
    //SQL SELECT-FROM to show website of choice
    println("Website option selected.")

    //start of query
    webQuery



    //for end of query
    continue
    if (continue.toUpperCase == "Y")
      website()
    else println("Exiting Program...")

    //webQuery
    //println(whereTo)
  }
/*
  def userName(): Unit ={

  }

  def email(): Unit ={

  }
*/
  //A way to show all users created in system
  def admin(): Unit ={
    lazy val adminLogin = readLine("Please Log in to continue: ")
    //lazy val showAllUsers = readLine("Show all Users? ")
    println("\n!!!Administrative Access Window!!!")
    adminLogin

    println(adminLogin)

  }

  def cancelProgram(): Unit = {
    println("Ending Program...")
  }
  //def setUp(): Unit = {}

  def main(args: Array[String]): Unit = {
    //setUp()
    //prompt1()
    //def website:String = "1"

    println(s"""Hello, This is my first programming project that will log your website sign-in data for easy recall.
               |WARNING: Authentication required before proceeding.
               |""".stripMargin)

    println(f"Welcome in $sysUserName!\n")

    println(
      s"""Please input one of the numbers into the field below:
         |1 = Website | 2 = Username | 3 = Email | cxl = Cancel
         |""".stripMargin)

    whereTo

    if (whereTo == "1") {
      website()
    } else if (whereTo == "2") {
      println("pending")
    } else if (whereTo == "3") {
      println("pending")
    } else if (whereTo.toLowerCase == "cxl") {
      cancelProgram()
    } else if (whereTo.toLowerCase == "admin"){
      admin()
    }
    else{
      println("Please enter a valid command.")
      //val CredentialLogger.whereTo = readLine("What information are you looking for today? ")
      //main(args: Array[String])
    }
  }
  connection.close()
}
