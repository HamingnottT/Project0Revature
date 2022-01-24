import java.io.File
import java.io.PrintWriter
import scala.io.Source
import scala.io.StdIn.readLine
import scala.collection.mutable.ArrayBuffer
//Made by: Johnathan Cardoza, Grace Alberts, Jacob Monks,Brandon Conover, Diane Clarke, Jacob Nottingham, Yuechi Peng
object fileIO {

  def stringBuilder(buf: Array[Char]):String = {
    var result = ""
    buf.foreach(x => result += x.toString())
    return result;
  }

  def main(args: Array[String]):Unit = {
    val TESTPATH = "E:\\Users\\Public\\Programming\\Project Working\\~TestPath\\testTex1.txt";
    val USERBASE = "E:\\Users\\Public\\Programming\\Project Working\\~TestPath\\userAndPass.txt"
    val OTHERFILE = "E:\\Users\\Public\\Programming\\Project Working\\~TestPath\\testTex2.txt"
    var info = Source.fromFile(USERBASE).mkString.split(",").toBuffer
    info(1) = info(1).substring(0,info(1).length()-2)
    val stdIN = System.console()

    //ask for username and password
    println("To access this file, please enter a user name and password")
    val userInput = readLine("Username: ")
    val passInput = stdIN.readPassword("Password: ")
    val passCreated = stringBuilder(passInput)
    if(userInput != info(0) || passCreated != info(1)) {
      println("YIKES! wrong password.")
      return
    }
    println("Displaying text from file")
    val data = Source.fromFile(TESTPATH).mkString
    val writer = new PrintWriter(new File(OTHERFILE))

    writer.close()
  }
}
