package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * This is impl class for that remote interface
 * @author Siyi_Kong
 *
 */
public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci{

	protected Fibonacci(int port) throws RemoteException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFibancciSequence(int max) throws RemoteException {
		List<Long> results = new ArrayList<Long>();
		for (int i=0; i<max; i++){
			results.add((long) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		return results.toString();
	}
	
}
