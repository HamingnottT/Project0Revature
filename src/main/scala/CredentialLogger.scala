//class CredentialLogger(){
  import scala.sys.process._
  import scala.io.StdIn._
  import java.sql

//Notes 1/18 -- need to create algorithm to upload input to user and then parse input saved at launch

  object CredentialLogger {

    //private val sysAdmin = "Admin"
    //private val sysAdminPass = "P455W0rd"
    private val sysUserName = "TestDummy"
    //private var sysPassword = ""
    lazy val whereTo: String = readLine("What information are you looking for today? ")


    def website(): Unit = {
      lazy val webQuery: String = readLine("What website are you looking for? ")
      lazy val continue = readLine("Continue [Y/N]? ")
      //SQL SELECT-FROM to show website of choice
      println(
        s"""
           |Website option selected.
           |""".stripMargin)

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

    def username(): Unit ={

    }

    def email(): Unit ={

    }

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
        lazy val CredentialLogger.whereTo = readLine("What information are you looking for today? ")
        main(args: Array[String])
      }



    }
  }
//}

//Unused Code
/*
def prompt1(): Unit = {
  println(
    s"""
       |Hello, This is my first programming project that will log your website sign-in data for easy recall.
       |WARNING: Authentication required before proceeding.
       |""".stripMargin)

  var doOnce = false
  var sysPromptUser = ""
  var sysPromptPass = ""

  do {
    sysPromptUser = readLine("Please set your Username: ")
    sysPromptPass = readLine("Please set your Password: ")

    //sysUserName
    //sysPromptPass

    doOnce = true
  } while (doOnce != true)

  sysUserName = sysPromptUser
  sysPassword = sysPromptPass

  println(sysUserName)
  println(sysPassword)

}*/