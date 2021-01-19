import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class SelectEmployeeSample {
	public static void main(String[] args) {
		//DAOを利用して全従業員情報を検索するクラス

		//★データベース接続方法の指定(ここから)
		String JDBC_URL = "jdbc:h2:";//使用データベース:H2 DB
		String judge = null;
		while(true) {
			System.out.println("データベースへの接続方法を選んでください");
			System.out.println("1:組み込みモード(非常駐モード)");
			System.out.println("2:サーバーモード(常駐モード)");
			System.out.println(">");
			judge = new java.util.Scanner(System.in).nextLine();
			if(judge.equals("1")||judge.equals("2")) {
				break;
			}
		}
		//employeeテーブルの全レコードを取得
		EmployeeDAO empDAO = new EmployeeDAO();
		//★(ここまで)
		List<Employee> empList = empDAO.findAll();
	}
}
