package projects.TPSinalgo.nodes.messages;

import sinalgo.nodes.messages.Message;

public class TPSinalgoMessageTemperature extends Message {

	private Double temperature;
	private int nextHop;
	private int TTL ; 
	
	
	


	public TPSinalgoMessageTemperature(Double temperature, int nextHop, int TTL) {
		super();
		this.temperature = temperature;
		this.nextHop = nextHop;
		this.TTL = TTL;
	}





	@Override
	public Message clone() {
		
		return new TPSinalgoMessageTemperature(temperature,nextHop, TTL);
		
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





	public int getTTL() {
		return TTL;
	}





	public void setTTL(int tTL) {
		TTL = tTL;
	}




	@Override
	public String toString() {
		return "TPSinalgoMessageTemperature [temperature=" + temperature + ", nextHop=" + nextHop + ", TTL=" + TTL
				+ "]";
	}





	
	
	
	
}



	