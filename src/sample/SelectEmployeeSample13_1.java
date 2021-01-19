package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployeeSample13_1 {
	public static void main(String[] args) {
		//		EmployeeDAO empDAO = new EmployeeDAO();
		//		List<Employee> empList = empDAO.findAll();
		//
		//		for(Employee emp : empList) {
		//			System.out.println(emp.getId());
		//			System.out.println(emp.getName());
		//			System.out.println(emp.getAge());
		//		}
		//
		//	}
		//データベース接続先の指定
		String JDBC_URL = "jdbc:h2:";//使用データベース:H2 DB
		boolean judge = true;
		while(judge) {
			System.out.println("データベースへの接続方法を選んでください");
			System.out.println("1:組み込みモード(非常駐モード)");
			System.out.println("2:サーバーモード(常駐モード)");
			System.out.println(">");
			String select = new java.util.Scanner(System.in).nextLine();

			switch(select) {
			case "1":
				JDBC_URL += "file:~/Documents/data/example";
				judge = false; break;
			case "2":
				JDBC_URL += "tcp://localhost/~/Documents/data/example";
				judge = false; break;
			}
		}
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, "sa", "")) {

			String sql = "SELECT ID,NAME,AGE FROM EMPLOYEE";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				System.out.println("ID" + id);
				System.out.println("名前" + name);
				System.out.println("年齢" + age + "\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
