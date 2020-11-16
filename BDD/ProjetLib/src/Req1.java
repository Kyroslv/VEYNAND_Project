import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req1 qui correspont a la requ�te de la question 1
 * @author lucas
 * 
 */

public class Req1 {
	
	Identifiant i = new Identifiant();
	
	/*
	 * On stock les informations � afficher dans un String
	 */
	
	private String res="";
	
	/**
	 * Requ�te effectu� lors du clic sur le boutton "continuer" dans la classe Q1
	 * @param param
	 * @throws Exception
	 */
	
	public Req1(String param) throws Exception{
		
		/**
		 * Connection a la base de donn�e grace aux identifiants
		 */
		
		Connection cnt = i.connect();
		
		/**
		 * Selectionne les titres quand le nom du chercheur correspond au param�tre "param"
		 */
		
		PreparedStatement ps = cnt.prepareStatement("select titre from ecrire inner join Chercheur on Ecrire.Email = Chercheur.email where nomchercheur = ?");
		ps.setString(1,param);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			res+=rs.getString("Titre")+"\n";
		}
		ps.close();
		rs.close();
		cnt.close();
	}
	
	/**
	 * M�thode qui retourne le r�sultat de la requ�te
	 * @return
	 */
	
	public String getRes() {
		return res;
	}
}
