package ie.gmit;

public class FibRequest {
    private int jobNum;
    private int max;
	public FibRequest(int jobNum, int max) {
		super();
		this.jobNum = jobNum;
		this.max = max;
	}
    
    public FibRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getJobNum() {
		return jobNum;
	}

	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
    
    
}
