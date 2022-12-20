package model;

import java.util.ArrayList;

public class Database {
	public static ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		
		
		users.add(new User("admin", "admin", UserTypes.ADMIN));
		users.add(new User("user", "user", UserTypes.USER));
		
		users.add(new User("petar", "petar123", UserTypes.USER));
		users.add(new User("jovan", "sifra", UserTypes.USER));
		users.add(new User("marko", "sifra", UserTypes.ADMIN));
		users.add(new User("user123", "mojasifra", UserTypes.ADMIN));
		users.add(new User("admina", "sifra", UserTypes.USER));
		
		return users;
	}
}
