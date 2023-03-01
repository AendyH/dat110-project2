package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
		// create a client object and use it to
		Client klient = new Client("Display", Common.BROKERHOST, Common.BROKERPORT);
		// - connect to the broker
		klient.connect();
		// - create the temperature topic on the broker
		klient.createTopic(Common.TEMPTOPIC);
		// - subscribe to the topic
		klient.subscribe(Common.TEMPTOPIC);
		// - receive messages on the topic
		for (int x = 0; x < COUNT; x++) {
			PublishMsg msg = (PublishMsg) klient.receive();
			System.out.println(msg.getMessage());
		}
		
		// - unsubscribe from the topic
		klient.unsubscribe(Common.TEMPTOPIC);
		// - disconnect from the broker
		klient.disconnect();
		System.out.println("Display stopping ... ");
		
	}
}