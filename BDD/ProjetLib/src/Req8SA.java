import java.sql.Connection;
import java.sql.Statement;

/**
 * Classe Req8SA qui correspont a une des requ�tes de la question 8
 * @author lucas
 * 
 */

public class Req8SA {

	Identifiant i = new Identifiant();

	/**
	 * Requ�te effectu� lors du clic sur le boutton "Supprimer A" dans la classe Q8
	 * @throws Exception
	 */

	public Req8SA() throws Exception{

		/**
		 * Connection � la base de donn�e grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Supprime le trigger "ver_ins_note"
		 */
		Statement stmt = cnt.createStatement();
		stmt.execute("drop trigger ver_ins_note");
		cnt.close();

	}

}