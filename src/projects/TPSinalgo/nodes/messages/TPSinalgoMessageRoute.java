package projects.TPSinalgo.nodes.messages;

import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Message;

public class TPSinalgoMessageRoute extends Message {
	
	
	private int sinkID;
	private int nextHop;
	private int numberOfHops;

	
	
	public TPSinalgoMessageRoute(int sinkID, int nextHop, int numberOfHops) {
		super();
		this.sinkID = sinkID;
		this.nextHop = nextHop;
		this.numberOfHops = numberOfHops;
	}



	@Override
	public Message clone() {
		
		return new TPSinalgoMessageRoute(sinkID, nextHop, numberOfHops);
		
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
	
	


}