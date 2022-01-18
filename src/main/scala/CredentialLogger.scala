//class CredentialLogger(){
  import scala.io.StdIn._
  //Notes 1/18 -- need to create algorithm to upload input to user and then parse input saved at launch
  //

  object CredentialLogger {
    private var sysUserName = ""
    private var sysPassword = ""


    //def setUp(): Unit = {}

    def prompt(): Unit = {


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

    }

    def main(args: Array[String]): Unit = {
      //setUp()
      prompt()


    }
  }
//}