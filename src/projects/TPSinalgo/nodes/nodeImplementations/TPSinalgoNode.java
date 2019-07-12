package projects.TPSinalgo.nodes.nodeImplementations;

import java.awt.Color;
import java.awt.Graphics;

import projects.TPSinalgo.nodes.messages.TPSinalgoMessageRoute;
import projects.TPSinalgo.nodes.messages.TPSinalgoMessageTemperature;
import projects.TPSinalgo.nodes.timers.TPSinalgoTimer;
import projects.TPSinalgo.nodes.timers.TPSinalgoTimerTemperature;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.gui.transformation.PositionTransformation;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;


public class TPSinalgoNode extends Node {
	
	private int sinkID ;
	private int nextHop ;
	private int numberOfHops;
	private int TTL; //Implementation of a time to live.

	@Override
	public void handleMessages(Inbox inbox) {

		while(inbox.hasNext()) {
			Message message = inbox.next();
			
			if(message instanceof TPSinalgoMessageRoute) {
				TPSinalgoMessageRoute msg = (TPSinalgoMessageRoute) message;
				
				if(this.numberOfHops > msg.getNumberOfHops() ) {
					this.sinkID = msg.getSinkID();
					this.numberOfHops = msg.getNumberOfHops() + 1;
					this.nextHop = inbox.getSender().ID;
					this.TTL = 0;
					
					
					TPSinalgoMessageRoute routeMsg = new TPSinalgoMessageRoute(this.sinkID, this.nextHop, this.numberOfHops, this.TTL);
					TPSinalgoTimer timer = new TPSinalgoTimer(routeMsg);
					timer.startRelative(1,this);
					
				}
				
				
			}
			
			if(message instanceof TPSinalgoMessageTemperature) {
				TPSinalgoMessageTemperature msg = (TPSinalgoMessageTemperature) message;
				boolean validationSinkId = msg.getNextHop() != this.sinkID;
				if(validationSinkId) {
					if(msg.getTTL() == 6) {
						System.out.println("Package die!");
					}else {
						this.TTL = (msg.getTTL() + 1);
						TPSinalgoMessageTemperature temperatureMsg = new TPSinalgoMessageTemperature(msg.getTemperature(), this.nextHop, this.TTL);
						TPSinalgoTimerTemperature timer = new TPSinalgoTimerTemperature(temperatureMsg);
						timer.startRelative(1,this);
					}
					
				} else {
					System.out.println(msg.toString());
				}
				
				
			}
			
		}

	}
	@NodePopupMethod(menuText = "Send Message")
	public void sendMessage() {

		Double temperature = generateTemperature(0, 30);
		TPSinalgoMessageTemperature msg = new TPSinalgoMessageTemperature(temperature, this.nextHop, this.TTL);
		TPSinalgoTimerTemperature timer = new TPSinalgoTimerTemperature(msg);
		timer.startRelative(1,this);
	}
	
	@NodePopupMethod(menuText = "Define Base Station")
	public void defineBaseStation() {
		this.sinkID = this.ID;
		this.nextHop = -1;
		this.numberOfHops = 0;
		TPSinalgoMessageRoute msg = new TPSinalgoMessageRoute(this.sinkID, this.nextHop, this.numberOfHops, this.TTL);
		TPSinalgoTimer timer = new TPSinalgoTimer(msg);
		timer.startRelative(1, this);
	}
	
	
	public Double generateTemperature(int min, int max) {
		
		return (Math.random()*((max-min)+1));
		
	}
	

	

	
	@Override
	public String toString() {
		return "TPSinalgoNode [sinkID=" + sinkID + ", nextHop=" + nextHop + ", numberOfHops=" + numberOfHops + ", TTL="
				+ TTL + "]";
	}
	
	@Override
	public void preStep() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		 sinkID = this.ID;
		 nextHop = 0;
		 numberOfHops = Integer.MAX_VALUE;
		 TTL = 0;
	}

	@Override
	public void neighborhoodChange() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postStep() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkRequirements() throws WrongConfigurationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, PositionTransformation pt, boolean highlight) {
		String text = ""+this.ID;
		super.drawNodeAsSquareWithText(g, pt, highlight, text, 12, Color.CYAN);
	}
	
	
	
	

}
