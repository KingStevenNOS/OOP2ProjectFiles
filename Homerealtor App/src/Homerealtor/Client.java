package Homerealtor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client(){}

    public static void main(String[] args) throws RemoteException, NotBoundException {
        //Getting the registry
        Registry registry = LocateRegistry.getRegistry(2545);

        //Looking Up the Registry For the remote Object
        Methods_RMI stub = (Methods_RMI) registry.lookup("Methods_RMI");


    }
}
