package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class FibService {
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
  
}
