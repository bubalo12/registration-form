package model;

public class User {

	private String username;
	private String password;
	private int id;
	private String ime, prezime;
	private int godiste;
	private String tip_usera;
	// admin, user

	public String getUsername() {
		return username;
	}

	public User(int id, String username, String password, String ime, String prezime, int godiste, String tip_usera) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.godiste = godiste;
		this.tip_usera = tip_usera;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return tip_usera;
	}

	public void setType(String tip_usera) {
		this.tip_usera = tip_usera;
	}

	public User(String username, String password, UserTypes type) {
		super();
		this.username = username;
		this.password = password;
		this.tip_usera = tip_usera;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", ime=" + ime + ", prezime="
				+ prezime + ", godiste=" + godiste + ", tip_usera=" + tip_usera + "]";
	}

}
