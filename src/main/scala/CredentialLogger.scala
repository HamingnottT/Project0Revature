//class CredentialLogger(){
  //import scala.sys.process._
  import scala.io.StdIn._
  //Notes 1/18 -- need to create algorithm to upload input to user and then parse input saved at launch


  object CredentialLogger {

    //private val sysAdmin = "Admin"
    //private val sysAdminPass = "P455W0rd"
    private val sysUserName = "TestDummy"
    //private var sysPassword = ""
    lazy val whereTo: String = readLine("What information are you looking for today? ")
    lazy val webQuery: String = readLine("What website are you looking for? ")

    def website(): Unit = {
      var doWhileSwitch = false
      //SQL SELECT-FROM to show website of choice
      println(
        s"""
           |Website option selected. What website
           |""".stripMargin)
      do{
        doWhileSwitch = true
        }while (!doWhileSwitch)
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
      } else if (whereTo == "cxl") {
        cancelProgram()
      } else if (whereTo == "admin"){
        admin()
      }
      else println("Hello")



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