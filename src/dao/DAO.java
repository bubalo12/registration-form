package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class DAO {

	private Connection connect = null;
//	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/logovanje", "root", "");
	}

	// SELECT * FROM `korisnici_ab` WHERE `username` = 'danilob' and `password` =
	// 'medvedja'
	public User selectUserByUsernameAndPassword(String username, String password)
			throws ClassNotFoundException, SQLException {
		User pom = null;
		ArrayList<User> lista = new ArrayList<User>();
		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM korisnici_ab WHERE username = ? and password = ?");
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			int godiste = resultSet.getInt("godiste");
			// String username = resultSet.getString("username");
			// String password = resultSet.getString("password");
			String tip_usera = resultSet.getString("tip_usera");
			pom = new User(id, username, password, ime, prezime, godiste, tip_usera);
		}
		close();
		return pom;
	}

	public ArrayList<User> selectUsers() throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		ArrayList<User> lista = new ArrayList<User>();

		connect();
		preparedStatement = connect.prepareStatement("select * from korisnici_ab");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI
		// preparedStatement.setString(1, o.getJmbg());

		preparedStatement.execute();

		// ****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO
		resultSet = preparedStatement.getResultSet();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			int godiste = resultSet.getInt("godiste");
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String tip_usera = resultSet.getString("tip_usera");

			User o = new User(id, username, password, ime, prezime, godiste, tip_usera);
			// Osoba o = new Osoba(jmbg, ime, prezime);

			lista.add(o);
		}
		// ****KRAJ KRAJ OBRADE ResultSet-a

		close();
		return lista;
	}

	public boolean isUsernameAvailable(String username) throws ClassNotFoundException, SQLException {
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		// ArrayList<User> lista = new ArrayList<User>();

		connect();
		preparedStatement = connect.prepareStatement("select * from korisnici_ab where username = ?");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI
		preparedStatement.setString(1, username);

		preparedStatement.execute();

		// ****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO
		resultSet = preparedStatement.getResultSet();

		if (resultSet.next()) {
			return false;
		}
		// ****KRAJ KRAJ OBRADE ResultSet-a
		else
			close();
		return true;

	}
	
	public void insertUser(User user) throws ClassNotFoundException, SQLException {
		

		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO korisnici_ab (ime, prezime, godiste, username, password, tip_usera) VALUES(?,?,?,?,?, 'user')");

		// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI
		preparedStatement.setString(1, user.getIme());
		preparedStatement.setString(2, user.getPrezime());
		preparedStatement.setInt(3, user.getGodiste());
		preparedStatement.setString(4, user.getUsername());
		preparedStatement.setString(5, user.getPassword());
		

		preparedStatement.execute();

		// ****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO
		resultSet = preparedStatement.getResultSet();

		close();

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
