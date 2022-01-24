
object TestSQL_Connection {

  import java.sql.{Connection, DriverManager}

  object ScalaJdbcConnectSelect extends App {
    // connect to the database named "mysql" on port 3306 of localhost
    val url = "jdbc:project0://localhost:3306/mysql"
    val driver = "com.project0.jdbc.Driver"
    val username = "root"
    val password = "RiffRaff68#$"
    var connection: Connection = _
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement
      val rs = statement.executeQuery("SELECT * FROM sql_admin")
      while (rs.next) {
        val host = rs.getString("host")
        val user = rs.getString("user")
        println("host = %s, user = %s".format(host, user))
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
    connection.close
  }
  def main(args: Array[String]): Unit = {

  }
}