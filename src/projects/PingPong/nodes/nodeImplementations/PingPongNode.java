package projects.PingPong.nodes.nodeImplementations;

import java.awt.Color;

import projects.PingPong.nodes.messages.PingPongMessage;
import projects.PingPong.nodes.timers.PingPongTimer;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.tools.statistics.UniformDistribution;

public class PingPongNode extends Node {
	
	private int local_r , local_g , local_b ;
	
	@Override
	public void handleMessages(Inbox inbox) {
		while (inbox.hasNext()) {
			Message message = inbox.next();
			if(message instanceof PingPongMessage) {
				PingPongMessage pkt = (PingPongMessage) message;
				this.local_r = pkt.getR();
				this.local_g = pkt.getG();
				this.local_b = pkt.getB();
				
				this.setColor(new Color(local_r, local_g, local_b));
				
				UniformDistribution ud = new UniformDistribution(0, 255);
				
				pkt.setR((int) ud.nextSample());
				pkt.setG((int) ud.nextSample());
				pkt.setB((int) ud.nextSample());
				
				PingPongTimer timer = new PingPongTimer(pkt);
				timer.startRelative(1,this);
			}
		}

	}
	
	@NodePopupMethod(menuText = "Init pingPong")
	public void initPingPong() {
		PingPongMessage msg = new PingPongMessage (0, 0, 0);
		PingPongTimer t = new PingPongTimer(msg);
		t.startRelative(1, this);
	}

	@Override
	public void preStep() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

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

}
