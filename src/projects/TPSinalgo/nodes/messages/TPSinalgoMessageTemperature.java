package projects.TPSinalgo.nodes.messages;

import projects.TPSinalgo.nodes.nodeImplementations.TPSinalgoNode;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Message;

public class TPSinalgoMessageTemperature extends Message {

	private Double temperature;
	private int nextHop;
	
	
	
	public TPSinalgoMessageTemperature(Double temperature, int nextHop) {
		super();
		this.temperature = temperature;
		this.nextHop = nextHop;
	}



	@Override
	public Message clone() {
		
		return new TPSinalgoMessageTemperature(temperature,nextHop);
		
	}



	public Double getTemperature() {
		return temperature;
	}



	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}



	public int getNextHop() {
		return nextHop;
	}



	public void setNextHop(int nextHop) {
		this.nextHop = nextHop;
	}



	@Override
	public String toString() {
		return "TPSinalgoMessageTemperature [temperature=" + temperature + ", nextHop=" + nextHop + "]";
	}
	
	

}
