import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe pour se connecter � la base de donn�e
 * @author lucas
 *
 */

public class Identifiant {
	
	/**
	 * on stock l'url, le login et le mot de passe sous forme de String afin de se connecter
	 */
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String Login="";
	private static String MDP="";
	
	/**
	 * Methode pour se connecter � la base de donn�e
	 * @return
	 * @throws SQLException
	 */
	
	public Connection connect() throws SQLException {
		Connection cnt = DriverManager.getConnection(url,this.getLogin(), this.getMDP());
		return cnt;
	}
	
	/**
	 * M�thode pour r�cuperer le login
	 * @return
	 */
	
	public String getLogin() {
		return Identifiant.Login;
	}
	
	/**
	 * M�thode pour r�cuperer le mot de passe
	 * @return
	 */
	
	public String getMDP() {
		return Identifiant.MDP;
	}
	
	/**
	 * M�thode pour stocker le login
	 * @param l
	 */
	
	public void setLogin(String l) {
		Identifiant.Login = l;
	}
	
	/**
	 * M�thode pour stocker le mot de passe
	 * @param m
	 */
	
	public void setMDP(String m) {
		Identifiant.MDP=m;
	}
}
