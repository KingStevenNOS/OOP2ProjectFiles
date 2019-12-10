package Homerealtor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Methods_RMI extends Remote {
    public boolean Authenticate(String username, String password, String Message) throws RemoteException, ClassNotFoundException, SQLException;
    public boolean Register(String name, String username, String phoneNum , String password, String propertyAddress, String email) throws RemoteException, ClassNotFoundException, SQLException;
}
