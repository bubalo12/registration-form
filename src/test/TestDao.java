package test;

import java.sql.SQLException;

import dao.DAO;
import model.User;

public class TestDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DAO dao = new DAO();
		
		System.out.println(dao.selectUserByUsernameAndPassword("danilob", "medvedja"));
		
		System.out.println(dao.isUsernameAvailable("danilob"));
		User u = new User(0, "danilo", "Bubalo", "danilo", "bubalo", 1987, null);
		dao.insertUser(u);

	}

}
