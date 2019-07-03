package projects.PingPong.nodes.timers;

import projects.PingPong.nodes.messages.PingPongMessage;
import projects.PingPong.nodes.nodeImplementations.PingPongNode;
import sinalgo.nodes.timers.Timer;

public class PingPongTimer extends Timer {
	
	private PingPongMessage pkt = null;

	
	
	public PingPongTimer(PingPongMessage pkt) {
		this.pkt = pkt;
	}



	@Override
	public void fire() {
		((PingPongNode)node).broadcast(this.pkt);
	}

}
