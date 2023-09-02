/*
Cermisoni Marco, MATRICOLA 748739, VA
Oldani Marco, MATRICOLA 748243, VA
De Vito Francesco, MATRICOLA 749044, VA
Auteri Samuele, MATRICOLA 749710, VA
*/
package EmotionalSongs;

import Database.Database;
import Database.*;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for implementing registration and login functions to the application
 * @author Auteri Samuele
 * @author De Vito Francesco
 */
public class Registrazione {
    /**
     * Void method that allows the user to register to the application
     * @param utente A parameter of type Utente
     * @param db A parameter of type Database
     * @throws SQLException Exception that occurs in Java when there's an error while working with a database using SQL (Structured Query Language) operations; SQL exceptions are typically thrown when there are issues such as: connection errors, syntax errors, constraint violations, data type mismatches, transaction issues, deadlocks and resource exhaustion.
     * @throws RemoteException Exception that occurs in Java applications using the Remote Method Invocation (RMI) technology; this exception is thrown when issues arise during the invocation of remote methods through RMI; some of the situations that can cause a RemoteException include: connection issues, remote exceptions, class not found, timeouts, security issues and serialization issues.
     */
    public static void registrazione(Utente utente, Database db) throws SQLException, RemoteException {
        Statement stm = db.getStatement();
        String in = "insert into utenti( nome, datanascita, cognome, codF, email, username, password) values ('" + utente.getNome() + "'" + "," + "'" + utente.getData() + "'" + "," + "'" + utente.getCognome() + "'" + "," + "'" +  utente.getCodiceFiscale() + "'" + "," + "'" + utente.getEmail() + "'" + "," + "'" + utente.getId() + "'" + "," + "'" + utente.getPassword() +"'" +")";
        Query query = new Query(in);
        stm.executeUpdate(query.getQuery());
    }

    /**
     * Method that implements the login function by returning a Boolean
     * @param username A parameter of type String that expresses the user's username
     * @param password A parameter of type String that expresses the user's password
     * @param db A parameter of type Database
     * @return The method returns a Boolean indicating whether or not the login is correct
     * @throws SQLException Exception that occurs in Java when there's an error while working with a database using SQL (Structured Query Language) operations; SQL exceptions are typically thrown when there are issues such as: connection errors, syntax errors, constraint violations, data type mismatches, transaction issues, deadlocks and resource exhaustion.
     * @throws RemoteException Exception that occurs in Java applications using the Remote Method Invocation (RMI) technology; this exception is thrown when issues arise during the invocation of remote methods through RMI; some of the situations that can cause a RemoteException include: connection issues, remote exceptions, class not found, timeouts, security issues and serialization issues.
     */
    public static Boolean login (String username, String password, Database db) throws SQLException, RemoteException {
        Statement stm = db.getStatement();
        String in = "select username, password from utenti where username = '" + username + "'";
        Query query = new Query(in);
        ResultSet rs = stm.executeQuery(query.getQuery());

        String user;
        String pwd;
        Boolean flag = false;

        while(rs.next() != false){
            user = rs.getString("username");
            pwd = rs.getString("password");

            if(user.equals(username) & pwd.equals(password)){
                flag = true;
                break;
            }
        }

        if(flag == true){
            return true;
        }else{
            return false;
        }
    }
}
