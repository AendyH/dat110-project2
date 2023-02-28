package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker
				Client klient = new Client("Sensor", Common.BROKERHOST, Common.BROKERPORT);
				int temp;
				String temperatur;
		
				klient.connect();
			
				for (int x = 0; x < COUNT; x++) {
					temp = sn.read();
					temperatur = Integer.toString(temp);
				klient.publish(Common.TEMPTOPIC, temperatur);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				klient.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");

	

	}
}
