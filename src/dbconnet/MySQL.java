package dbconnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	//JDBCドライバの登録
    String driver;
    // データベースの指定
    String server, dbname, url, user, password;
    Connection con;
    Statement stmt;
    ResultSet rs;
	public MySQL() {
		this.driver  = "org.gjt.mm.mysql.Driver";
		this.server  = "ms000.sist.ac.jp";      // MySQLサーバ ( IP または ホスト名 );
		this.dbname  = "java2016";         // データベース名;
		this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
		this.user = "java2016";         // データベース作成ユーザ名;
		this.password  = "java2016";     // データベース作成ユーザパスワード;
	
		try{
			this.con = DriverManager.getConnection(url, user, password);
			this.stmt = con.createStatement ();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
		Class.forName (driver);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public void close(){
		try{
			rs.close();
			stmt.close();
			con.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ResultSet selectAll(){
		String sql = "SELECT * FROM `50516041`";
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery (sql);  //try catchで囲む
			
		}catch(SQLException e){
			e.printStackTrace();
		
		}
		return rs;
	}


}
