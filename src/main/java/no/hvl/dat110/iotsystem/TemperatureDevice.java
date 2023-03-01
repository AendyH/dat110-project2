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
		Client klient = new Client("Sensor", Common.BROKERHOST, Common.BROKERPORT);
		int temp;
		String temperatur;
		// - connect to the broker
		klient.connect();
		// - publish the temperature(s)
		for (int x = 0; x < COUNT; x++) {
			temp = sn.read();
			temperatur = Integer.toString(temp);
		klient.publish(Common.TEMPTOPIC, temperatur);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		// - disconnect from the broker
		klient.disconnect();
		// TODO - end

		System.out.println("Temperature device stopping ... ");

	}
}