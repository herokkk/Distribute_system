package ie.gmit;

import java.rmi.Naming;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class FibonacciService {
  private LinkedList<FibRequest> inqueue=new LinkedList<FibRequest>();
  
  private Map<Integer, String> outqueue=new HashMap<Integer, String>();
  
  public int add(int max){
	  int random=new Random().nextInt(999999999);
	  inqueue.addLast(new FibRequest(random, max));
	  return random;
  }
  
  public void put(int jobNumber,String fibNumber){
	  outqueue.put(jobNumber, fibNumber);
  }
  
  public String getResult(int jobnumber){
	  if(outqueue.containsKey(jobnumber)){
		  String result=outqueue.get(jobnumber);
		  outqueue.remove(jobnumber);
		  return result;
	  }else {
		return null;
	}
  }

public void makeRMIcall(int max, int jobNum) {
	// TODO Auto-generated method stub
	 //outqueue.put(jobNumber, fibNumber);// put Result in outQueue
	  
	  RemoteFibonacci remoteFibonacci;
		try {
			remoteFibonacci = (RemoteFibonacci) Naming.lookup("rmi://localhost:1099/fib");
			
			String result=remoteFibonacci.getFibancciSequence(max);
             
			outqueue.put(jobNum, result);
			
}catch(Exception e){
	 e.printStackTrace();  
}
		
	
}
  
public static void main(String[] args) {
	
}
}
