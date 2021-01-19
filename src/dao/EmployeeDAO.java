package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	//データベース接続に使用する情報
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	//★改修(ここから)
	private String JDBC_URL = "jdbc:h2:";//使用データベース:H2 DB

	//コンストラクタ
	public EmployeeDAO(String judge) {
		switch(judge) {
		case "1":
			JDBC_URL += "file:~/Documents/data/example";
			break;
		case "2":
			JDBC_URL += "tcp://localhost/~/Documents/data/example";
		}
	}
	public EmployeeDAO() {};

	//★(ここまで)
	//メソッド
	public List<Employee> findAll(){
		List<Employee> empList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT ID,NAME,AGE FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Employee employee = new Employee(id,name,age);
				empList.add(employee);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
}
