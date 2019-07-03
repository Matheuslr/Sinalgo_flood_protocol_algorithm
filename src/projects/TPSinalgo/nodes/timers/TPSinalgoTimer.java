package projects.TPSinalgo.nodes.timers;

import projects.TPSinalgo.nodes.messages.TPSinalgoMessageRoute;
import sinalgo.nodes.timers.Timer;

public class TPSinalgoTimer extends Timer {

	private TPSinalgoMessageRoute msg = null;
	
	
	public TPSinalgoTimer(TPSinalgoMessageRoute msg) {

		this.msg = msg;
	}


	@Override
	public void fire() {
		
		this.node.broadcast(msg);
		
	}

}
