package ie.gmit;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Requestservlett extends HttpServlet {

	FibService fibService;
	
	int jobnumberTemp;
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		fibService=new FibService();
		
		try {
			RemoteFibonacci fib=new Fibonacci(1099);
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("fib", fib);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	
	}

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	
		File file=new File("\\my.txt");
		if(file.createNewFile())
		System.out.println(file.getAbsolutePath());
		
		
		 
		 String type=request.getParameter("request-type");
		 
		 if(type.equals("add")){
			 String max=request.getParameter("max");// get String representation of users input
			 int jobNum=fibService.add(Integer.valueOf(max));// get random job number
			 
			 try {
				 request.setAttribute("max",max);
					request.setAttribute("jobnum",jobNum);
					 request.getRequestDispatcher("response.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }else if(type.equals("poll")){
			 RemoteFibonacci remoteFibonacci;
			try {
				remoteFibonacci = (RemoteFibonacci) Naming.lookup("rmi://localhost:1099/fib");
				
				String result=remoteFibonacci.getFibancciSequence(Integer.parseInt(request.getParameter("num")));
			
				 if(result!=null){
					 request.setAttribute("result", result);
						response.sendRedirect("result.jsp?result="+result);
						return;
					 }else {
						 response.sendRedirect("response.jsp");
						 return;
					}
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}

	public void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	

}
