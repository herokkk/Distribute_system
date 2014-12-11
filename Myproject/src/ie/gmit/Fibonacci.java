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
		StringBuffer container=new StringBuffer();
		
		
		List<Integer> results = new ArrayList<Integer>();
		for (int i=0; i<max; i++){
			results.add((int) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		return results.toString();
	}
	
	public static int fibonacciRecusion(int i){
		if(i==0){
			return 0;
		}else if(i==1){
			return 1;
		}
		return fibonacciRecusion(i-1)+fibonacciRecusion(i-2);
	}

}
