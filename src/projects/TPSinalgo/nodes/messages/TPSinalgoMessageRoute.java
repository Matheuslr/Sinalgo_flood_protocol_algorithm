package projects.TPSinalgo.nodes.messages;

import sinalgo.nodes.messages.Message;

public class TPSinalgoMessageRoute extends Message {
	
	
	private int sinkID;
	private int nextHop;
	private int numberOfHops;
	private int TTL; 

	
	
	
	


	public TPSinalgoMessageRoute(int sinkID, int nextHop, int numberOfHops, int TTL) {
		super();
		this.sinkID = sinkID;
		this.nextHop = nextHop;
		this.numberOfHops = numberOfHops;
		this.TTL = TTL;
	}







	@Override
	public Message clone() {
		
		return new TPSinalgoMessageRoute(sinkID, nextHop, numberOfHops, TTL);
		
	}







	public int getSinkID() {
		return sinkID;
	}







	public void setSinkID(int sinkID) {
		this.sinkID = sinkID;
	}







	public int getNextHop() {
		return nextHop;
	}







	public void setNextHop(int nextHop) {
		this.nextHop = nextHop;
	}







	public int getNumberOfHops() {
		return numberOfHops;
	}







	public void setNumberOfHops(int numberOfHops) {
		this.numberOfHops = numberOfHops;
	}







	public int getTTL() {
		return TTL;
	}







	public void setTTL(int tTL) {
		TTL = tTL;
	}







	@Override
	public String toString() {
		return "TPSinalgoMessageRoute [sinkID=" + sinkID + ", nextHop=" + nextHop + ", numberOfHops=" + numberOfHops
				+ ", TTL=" + TTL + "]";
	}
	
	
	




	


}