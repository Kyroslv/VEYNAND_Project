import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req3 qui correspont a la requ�te de la question 3
 * @author lucas
 * 
 */

public class Req3 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations � afficher dans un String
	 */

	private String res="";

	/**
	 * Requ�te effectu� lors du clic sur le boutton "continuer" dans la classe Q3
	 * @throws Exception
	 */

	public Req3() throws Exception{

		/**
		 * Connection a la base de donn�e grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne les nom des chercheurs
		 */

		PreparedStatement ps = cnt.prepareStatement("SELECT nomchercheur from Chercheur ");

		/**
		 * Selectionne par chercheur de la requ�te pr�c�dente, les laboratoire dans lequel le chercheur travail
		 */

		PreparedStatement ps2 = cnt.prepareStatement("Select Laboratoire.nomlabo from Laboratoire inner join Travailler on Laboratoire.nomlabo = Travailler.NomLabo inner join Chercheur on Travailler.Email = Chercheur.email where nomchercheur = ?");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			res+=rs.getString("nomchercheur")+":\n";
			ps2.setString(1,rs.getString("nomchercheur"));
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				res+="-"+rs2.getString("nomlabo")+"\n";
			}
			res+="\n";
			rs2.close();
		}
		ps.close();
		ps2.close();
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

