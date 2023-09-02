/*
Cermisoni Marco, MATRICOLA 748739, VA
Oldani Marco, MATRICOLA 748243, VA
De Vito Francesco, MATRICOLA 749044, VA
Auteri Samuele, MATRICOLA 749710, VA
*/
package EmotionalSongs;

import Database.serverES;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

/**
 * Progetto Laboratorio B: "Emotional Songs", anno scolastico 2022-2023; contains the main.
 * @author Cermisoni Marco
 * @author Auteri Samuele
 * @version 2.0
 */
public class EmotionalSongs {

    /**
     * Launches the application
     * @param args Main arguments
     * @throws SQLException Exception that occurs in Java when there's an error while working with a database using SQL (Structured Query Language) operations; SQL exceptions are typically thrown when there are issues such as: connection errors, syntax errors, constraint violations, data type mismatches, transaction issues, deadlocks and resource exhaustion.
     * @throws RemoteException Exception that occurs in Java applications using the Remote Method Invocation (RMI) technology; this exception is thrown when issues arise during the invocation of remote methods through RMI; some of the situations that can cause a RemoteException include: connection issues, remote exceptions, class not found, timeouts, security issues and serialization issues.
     * @throws NotBoundException Exception that occurs in the context of the Remote Method Invocation (RMI) technology; it is part of the java.rmi package and is thrown when a client tries to access or invoke a remote object that is not currently bound in the RMI registry.
     */
    public static void main(String[] args) throws SQLException, RemoteException, NotBoundException {
        serverES serverImpl = new serverES();
        Registry registry = LocateRegistry.createRegistry(8999);
        registry.rebind("SERVER", serverImpl);

        clientEs emsong = new clientEs();

    }
}
