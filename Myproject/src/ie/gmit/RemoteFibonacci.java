package ie.gmit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;

public interface RemoteFibonacci extends Remote{

    public String getFibancciSequence(int max) throws RemoteException;	
}
