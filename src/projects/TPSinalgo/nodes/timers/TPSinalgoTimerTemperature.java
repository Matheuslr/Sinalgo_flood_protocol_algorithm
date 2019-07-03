package projects.TPSinalgo.nodes.timers;

import projects.TPSinalgo.nodes.messages.TPSinalgoMessageTemperature;
import projects.TPSinalgo.nodes.nodeImplementations.TPSinalgoNode;
import sinalgo.nodes.timers.Timer;
import sinalgo.tools.Tools;



public class TPSinalgoTimerTemperature extends Timer {
	 
	private TPSinalgoMessageTemperature msg = null;
	
	
	
	public TPSinalgoTimerTemperature(TPSinalgoMessageTemperature msg) {
		this.msg = msg;
	}



	@Override
	public void fire() {
		int nextHop = msg.getNextHop();
		this.node.send(msg, Tools.getNodeByID(this.msg.getNextHop()));;
		
	}

}
