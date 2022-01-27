package LoggerPackage

import LoggerPackage.LoggerQueries._
import scala.io.StdIn._

object LoggerMain {
  var mainMenuLoop = true
  var webMenuLoop = true
  var userMenuLoop = true
  var emailMenuLoop = true
  var adminMenuLoop = true
  var signedIn = false

  val signInFail = "Sign in failed. Exiting program - please try again."

  def cancelProgram(): Unit = {
    println("Ending Program...")
  }

  def signIn(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(s"""Hello, This is my first programming project that will log your website sign-in data for easy recall.
               |WARNING: Authentication required before proceeding - please sign in.
               |""".stripMargin)
    val inputUserName = readLine("Username: ")
    val inputPassword = readLine("Password: ")
    val signInQuery= statement.executeQuery(f"SELECT cl_user, cl_pass FROM project0.sql_admin WHERE cl_user = '$inputUserName' AND cl_pass = '$inputPassword';")
    while (signInQuery.next()) {
      val userResult = signInQuery.getString(1).mkString
      val passResult = signInQuery.getString(2).mkString
      if (inputUserName == userResult && inputPassword == passResult){
        println(f"\nWelcome in $inputUserName!\n")
        signedIn = true
      } else return
    }
  }

  def admin(): Unit ={
    println(
      """Administrative option accessed.
        |1 = Get all users | 2 = Create New Account | cxl = Cancel & Exit
        |""".stripMargin)
    do{
      var webUserInput = readLine("What information are you looking for today? ")
      if (webUserInput == "1") {
        println()
        getAdmin()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          adminMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "2") {
        println()
        createAppAcct()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          adminMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput.toLowerCase == "cxl") {
        println()
        cancelProgram()
        println()
        adminMenuLoop = false
      }
      else {
        println("Please enter a valid command.\n")
        webUserInput = " "
      }
    }while (adminMenuLoop)
  }

  def website(): Unit ={
    println(
      """Website option selected. Please input one of the numbers into the field below:
        |1 = Add Website to Database | 2 = Find a Specific Website | 3 = Get All Websites | 4 = Edit Website Name |
        |5 = Delete Website Info     | cxl = Cancel & Exit
        |""".stripMargin)
    do{
      var webUserInput = readLine("What information are you looking for today? ")
      if (webUserInput == "1") {
        println()
        createWebsite()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          webMenuLoop = false
        } else webUserInput = " "

      } else if (webUserInput == "2") {
        println()
        getCertainWebsite()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          webMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "3") {
        println()
        getAllWebsites()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          webMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "4") {
        println()
        updateWebsite()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          webMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "5") {
        println()
        delWebsite()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          webMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput.toLowerCase == "cxl") {
        println()
        cancelProgram()
        println()
        webMenuLoop = false
      } else if (webUserInput.toLowerCase == "admin") {
        println()
        admin()
        webMenuLoop = false
      }
      else {
        println("Please enter a valid command.\n")
        webUserInput = " "
      }
    }while (webMenuLoop)
  }

  def user(): Unit ={
    println(
      """Usernames & Passwords option selected. Please input one of the numbers into the field below:
        |1 = Update Username of a Website | 2 = Find Websites by Username | 3 = Update a Password |4 = Go to Websites |
        |cxl = Cancel & Exit
        |""".stripMargin)
    do{
      var webUserInput = readLine("What information are you looking for today? ")
      if (webUserInput == "1") {
        println()
        updateUser()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          userMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "2") {
        println()
        getAllUser()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          userMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "3") {
        println()
        updatePass()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          userMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "4") {
        println()
        website()
        userMenuLoop = false
      } else if (webUserInput.toLowerCase == "cxl") {
        println()
        cancelProgram()
        println()
        userMenuLoop = false
      } else if (webUserInput.toLowerCase == "admin") {
        println()
        admin()
        userMenuLoop = false
      }
      else {
        println("Please enter a valid command.\n")
        webUserInput = " "
      }
    }while (userMenuLoop)
  }

  def email(): Unit ={
    println(
      """Email option selected. Please input one of the numbers into the field below:
        |1 = Get websites With Target Email | 2 = Update Email of a Website | 3 = Go to Usernames & Passwords |4 = Go to Websites |
        |cxl = Cancel & Exit
        |""".stripMargin)
    do{
      var webUserInput = readLine("What information are you looking for today? ")
      if (webUserInput == "1") {
        println()
        getEmail()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          emailMenuLoop = false
        } else webUserInput = " "
      } else if (webUserInput == "2") {
        println()
        updateEmail()
        val continueChecker = readLine("\nContinue looking [Y/N]? ")
        if (continueChecker.toUpperCase == "N") {
          emailMenuLoop = false
          } else webUserInput = " "
      } else if (webUserInput == "3") {
        println()
        user()
        emailMenuLoop = false
      } else if (webUserInput == "4") {
        println()
        website()
        emailMenuLoop = false
      } else if (webUserInput.toLowerCase == "cxl") {
        println()
        cancelProgram()
        println()
        emailMenuLoop = false
      } else if (webUserInput.toLowerCase == "admin") {
        println()
        admin()
        emailMenuLoop = false
      }
      else {
        println("Please enter a valid command.\n")
        webUserInput = " "
      }
    }while (emailMenuLoop)
  }

  def main(args:Array[String]): Unit ={
    signIn()
    if (signedIn) {
      println(
        s"""Please input one of the numbers into the field below:
           |1 = Websites | 2 = Usernames & Passwords | 3 = Email | cxl = Cancel & Exit
           |""".stripMargin)
      do {
        var whereTo = readLine("What information are you looking for today? ")
        println()
        if (whereTo == "1") {
          website()
          mainMenuLoop = false
        } else if (whereTo == "2") {
          user()
          mainMenuLoop = false
        } else if (whereTo == "3") {
          println("pending")
          mainMenuLoop = false
        } else if (whereTo.toLowerCase == "cxl") {
          cancelProgram()
          println()
          mainMenuLoop = false
        } else if (whereTo.toLowerCase == "admin") {
          admin()
          mainMenuLoop = false
        }
        else {
          println("Please enter a valid command.\n")
          whereTo = " "
        }
      } while (mainMenuLoop)
    } else println(signInFail)
  }
}
