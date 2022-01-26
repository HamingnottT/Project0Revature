package TEST

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
  var connection:Connection = DriverManager.getConnection(url, username, password)

  //val sysUserName = readLine("Username:")
  val TESTusername = "HamingnottT"
  val msgMain =
    """--------------------------------
      |Returning results are in this order:
      |[Website] - [Username], [Password], [Email Address]
      |--------------------------------""".stripMargin


  //C - create new website data to sql_user table - should be used with the read function below
  def createWebsite(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(
      f"""================================
        |Welcome $TESTusername to the website creation tool.
        |Here you will be asked to input the following values in this order:
        |[Website] - [Username], [Password], [Email Address]
        |
        |If certain fields are not required for login simply type 'N/A'
        |and we will handle the rest.
        |
        |Any information entered can be updated and deleted for future use.
        |Thank you for using this tool and don't forget to leave feedback!
        |================================""".stripMargin)
    var newWebsite = readLine("\nInput new website name: ")
    var newUsername = readLine("\nInput the username (if any) for this website: ")
    var newPassword = readLine("\nInput the password for this website: ")
    var newEmail = readLine("\nInput the email for this website: ")
    println()
    println(msgMain)
    val addNew = statement.executeUpdate(f"INSERT INTO sql_user(`website`, `username`, `password`, `email`, `cl_user`) VALUES('$newWebsite', '$newUsername', '$newPassword', '$newEmail', '$TESTusername');")
    println("New credentials are added. Returning the new info from our database to verify changes:")
    val getChanges = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$newWebsite';")
    while ( getChanges.next() ) {
      println(getChanges.getString(1) + " - " + getChanges.getString(2) + ", " + getChanges.getString(3) + ", " + getChanges.getString(4)) //testQuery1.getString(5), testQuery1.getString(6))
    }
  }
  /* INSERT INTO sql_user(`website`, `username`, `password`, `email`, `cl_user`) VALUES('Test Website', 'Test User', 'p455w0rd', 'email@address.com', 'HamingnottT'); */
  /* INSERT INTO sql_user(`website`, `username`, `password`, `email`, `cl_user`) VALUES('$newWebsite', '$newUsername', '$newPassword', '$newEmail', '$TESTusername'); */



  //R - Get all websites of the application user - Functional :)

  def getAllWebsites(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(msgMain)
    println("\nReturning all websites of this application user:\n")
    val getAllSites = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername';")
    while ( getAllSites.next() ) {
      println(getAllSites.getString(1) + " - " + getAllSites.getString(2) + ", " + getAllSites.getString(3) + ", " + getAllSites.getString(4)) //testQuery1.getString(5), testQuery1.getString(6))
    }
  }

  //R - returns specific website info from query - Functional :)

  def getCertainWebsite(){
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(msgMain)
    var userInput4Website = readLine("\nWhat website are you looking for? ")
    println("\nHere is what I found:\n")
    var getAllSites = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$userInput4Website';")
    while ( getAllSites.next() ) {
      println(getAllSites.getString(1) + " - " + getAllSites.getString(2) + ", " + getAllSites.getString(3) + ", " + getAllSites.getString(4)) //testQuery.getString(5), testQuery.getString(6))
    }
  }

  //U - Updates the website name if there is a typo - Functional :)

  def updateWebsite(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(msgMain)
    var inputWebsite4User = readLine("\nWhat Website are you looking for? ")
    //var inputUser4User = readLine("What username are you looking for? ")
    println("\nHere is what I found:\n")

    var updateWebUsername = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$inputWebsite4User';")
    while ( updateWebUsername.next() ) {
      println(updateWebUsername.getString(1) + " - " + updateWebUsername.getString(2) + ", " + updateWebUsername.getString(3) + ", " + updateWebUsername.getString(4)) //testQuery.getString(5), testQuery.getString(6))
    }
    var updateSite = readLine("\nUpdate website name here: ")

    statement.executeUpdate(f"UPDATE sql_user SET website = '$updateSite' WHERE website = '$inputWebsite4User';")

    println(f"\nWebsite: '$inputWebsite4User' has username updated to '$updateSite'\n")

    var postUpdate = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$updateSite';")
    while ( postUpdate.next() ) {
      println(postUpdate.getString(1) + " - " + postUpdate.getString(2) + ", " + postUpdate.getString(3) + ", " + postUpdate.getString(4)) //testQuery.getString(5), testQuery.getString(6))
    }
  }

  //D - deletes all data by specific website
//This block may cause an Error in full implementation - Be Aware!
/* Deleting a row somehow throws an exception. Functionally it works on mySQL,
but a try-catch function was needed to handle this issue.
Could not get a return query on the rows post deletion
Update on status - anything in try-catch seems to be self contained including variables */

def delWebsite(): Unit ={
val statement = connection.createStatement()
statement.execute("use project0;")
println(msgMain)
try{
  var userInput4Del = readLine("\nWhat website do you no longer use? ")
  println("\nHere is what I found:\n")
  var delWebQuery = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$userInput4Del';")
  while ( delWebQuery.next() ) {
    println(delWebQuery.getString(1) + " - " + delWebQuery.getString(2) + ", " + delWebQuery.getString(3) + ", " + delWebQuery.getString(4)) //testQuery1.getString(5), testQuery1.getString(6))
  }

  var deleteWebsite = statement.executeUpdate(f"DELETE FROM sql_user WHERE cl_user = '$TESTusername' AND website = '$userInput4Del';")
  println(f"\nThe website, $userInput4Del, has been erased.\n")

  /* -- Unused query - post delete return
  var postDeleteWeb = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$userInput4Del';")
  while ( postDeleteWeb.next() ) {
    println(postDeleteWeb.getString(1) + " - " + postDeleteWeb.getString(2) + ", " + postDeleteWeb.getString(3) + ", " + postDeleteWeb.getString(4)) //testQuery1.getString(5), testQuery1.getString(6))
  }
  */
} catch{
  case e: SQLException => println("ERROR: Something went wrong!")
}
}

def website(): Unit = {
val statement = connection.createStatement()
statement.execute("use project0;")
println(msgMain)
//after displaying information asks user if they want to add or modify info given the displayed credentials
}

  //R - gets all websites that share this username - Functional :)
  def getAllUser(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(msgMain)
    var input4User = readLine("\nWhat username are you looking for? ")
    println(f"\nReturning all websites that use this username: $input4User\n")
    var getAllUsernames = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND username = '$input4User';")
    while ( getAllUsernames.next() ) {
      println(getAllUsernames.getString(1) + " - " + getAllUsernames.getString(2) + ", " + getAllUsernames.getString(3) + ", " + getAllUsernames.getString(4)) //testQuery1.getString(5), testQuery1.getString(6))
    }
  }

  //updates username of specific website - Functional :)
  def updateUser(): Unit ={
    val statement = connection.createStatement()
    statement.execute("use project0;")
    println(msgMain)
    var inputWebsite4User = readLine("\nWhat Website are you looking for? ")
    //var inputUser4User = readLine("What username are you looking for? ")
    println("\nHere is what I found:\n")

    var updateWebUsername = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$inputWebsite4User';")
    while ( updateWebUsername.next() ) {
      println(updateWebUsername.getString(1) + " - " + updateWebUsername.getString(2) + ", " + updateWebUsername.getString(3) + ", " + updateWebUsername.getString(4)) //testQuery.getString(5), testQuery.getString(6))
    }

    var webUpdateUser = readLine("\nWhat username are you using now? ")

    statement.executeUpdate(f"UPDATE sql_user SET username = '$webUpdateUser' WHERE website = '$inputWebsite4User';")

    println(f"\nWebsite: '$inputWebsite4User' has username updated to '$webUpdateUser'\n")

    var TestStatement = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND username = '$webUpdateUser';")
    while ( TestStatement.next() ) {
      println(TestStatement.getString(1) + " - " + TestStatement.getString(2) + ", " + TestStatement.getString(3) + ", " + TestStatement.getString(4)) //testQuery.getString(5), testQuery.getString(6))
    }
  }

def web_user(): Unit ={
val statement = connection.createStatement()
var webUserName = "Test User"
var userInputWebsite1 = "MySpace"
statement.execute("use project0;")
println(msgMain)
//after displaying information asks user if they want to add or modify info given the displayed credentials

}

//R - function to get password of a website

def getPass(): Unit ={
val statement = connection.createStatement()
statement.execute("use project0;")
println(msgMain)
var inputWebsite4Pass = readLine("What Website are you looking for? ")

println("\nHere is what I can find:\n")

var PasswordQuery = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$inputWebsite4Pass';")
while ( PasswordQuery.next() ) {
  println(PasswordQuery.getString(1) + " - " + PasswordQuery.getString(2) + ", " + PasswordQuery.getString(3) + ", " + PasswordQuery.getString(4)) //testQuery.getString(5), testQuery.getString(6))
}
}

//U - function to change password of a website - Functional :)

def updatePass(): Unit ={
val statement = connection.createStatement()
statement.execute("use project0;")
println(msgMain)
var inputWebsite4Pass = readLine("What Website are you looking for? ")

println("\nHere is what I can find:\n")

var PasswordQuery = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$inputWebsite4Pass';")
while ( PasswordQuery.next() ) {
println(PasswordQuery.getString(1) + " - " + PasswordQuery.getString(2) + ", " + PasswordQuery.getString(3) + ", " + PasswordQuery.getString(4)) //testQuery.getString(5), testQuery.getString(6))
}

var webUpdatePassword = readLine("\nWhat password are you using now? ")

statement.executeUpdate(f"UPDATE sql_user SET password = '$webUpdatePassword' WHERE website = '$inputWebsite4Pass';")

println(f"\nWebsite: '$inputWebsite4Pass' has password updated to '$webUpdatePassword'\n")

var PasswordResult = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND password = '$webUpdatePassword';")
while ( PasswordResult.next() ) {
println(PasswordResult.getString(1) + " - " + PasswordResult.getString(2) + ", " + PasswordResult.getString(3) + ", " + PasswordResult.getString(4)) //testQuery.getString(5), testQuery.getString(6))
}
}


//R - function to get all websites using this email address - Functional :)

def getEmail(): Unit ={
val statement = connection.createStatement()

println(msgMain)

var inputWebsite4email = readLine("What email address are you looking for? ")

println("\nHere is what I can find:\n")

var EmailQuery = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND email = '$inputWebsite4email';")
while ( EmailQuery.next() ) {
println(EmailQuery.getString(1) + " - " + EmailQuery.getString(2) + ", " + EmailQuery.getString(3) + ", " + EmailQuery.getString(4)) //testQuery.getString(5), testQuery.getString(6))
}

}

//U - function to change the email address of a website - Functional :)

def updateEmail(): Unit ={
val statement = connection.createStatement()

println(msgMain)

var inputWebsite4email = readLine("What Website are you looking for? ")

println("\nHere is what I can find:\n")

var EmailQuery = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND website = '$inputWebsite4email';")
while ( EmailQuery.next() ) {
println(EmailQuery.getString(1) + " - " + EmailQuery.getString(2) + ", " + EmailQuery.getString(3) + ", " + EmailQuery.getString(4)) //testQuery.getString(5), testQuery.getString(6))
}

var webUpdateEmail = readLine("\nWhat password are you using now? ")

statement.executeUpdate(f"UPDATE sql_user SET email = '$webUpdateEmail' WHERE website = '$inputWebsite4email';")

println(f"\nWebsite: '$inputWebsite4email' has email updated to '$webUpdateEmail'\n")

var EmailUpdateResult = statement.executeQuery(f"SELECT website, username, password, email FROM project0.sql_user WHERE cl_user = '$TESTusername' AND email = '$webUpdateEmail';")
while ( EmailUpdateResult.next() ) {
println(EmailUpdateResult.getString(1) + " - " + EmailUpdateResult.getString(2) + ", " + EmailUpdateResult.getString(3) + ", " + EmailUpdateResult.getString(4)) //testQuery.getString(5), testQuery.getString(6))
}

//D - function to delete email address in a website
//as an option: asks to delete an email address by adding N/A to the field if not using one

def delEmail(): Unit ={

}

//after displaying information asks user if they want to add or modify info given the displayed credentials



}
  //CRUD - Website
  //createWebsite()
  //getAllWebsites()
  //getCertainWebsite()
  //updateWebsite()
  // delWebsite()


  //RU - User
  //getAllUser()
  //updateUser()


  //RU - Passwords
  //getPass()
  //updatePass()

  //RU - email
  //getEmail()
  //updateEmail()

  connection.close()

}

// Proper Query example
/*
val statement = connection.createStatement()
var testQuery = statement.executeQuery("SELECT * FROM project0.sql_user;")
println(testQuery)
while ( testQuery.next() ) {
println(testQuery.getString(1)+", " +testQuery.getString(2) +", " +testQuery.getString(3), testQuery.getString(4),testQuery.getString(5),testQuery.getString(6))
*/