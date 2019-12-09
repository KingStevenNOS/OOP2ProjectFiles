package Homerealtor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends AuthenticationImpl{
    public Server(){}

    public static void main(String[] args) {
        try{
            //Instantiating the Implementation Class
            AuthenticationImpl obj = new AuthenticationImpl();

            //Exporting the object of the implementation class
            Methods_RMI stub = (Methods_RMI) UnicastRemoteObject.exportObject(obj,2545);

            //Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Methods_RMI",stub);
            System.err.println("Server Ready");
        }catch(Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}