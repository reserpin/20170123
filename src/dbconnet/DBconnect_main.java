package dbconnet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnect_main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[][] = new int[3][20];
		String name[] = new String[20];
		int  i =0;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		
		try{
		while(rs.next()){
    		data[0][i] = rs.getInt("id");
    		name[i] = rs.getString("name");
    		data[1][i] = rs.getInt("year");
			data[2][i] = rs.getInt("ton");	
			
			i++;
    	}  
		}catch(SQLException e){
			e.printStackTrace();
		}
		Graph g = new Graph(data,i,name);
		g.setBounds(25,25,655,555);
		g.setVisible(true);
	}

}
