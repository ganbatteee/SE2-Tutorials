package tuts.tut9.todo.bridge.remotes;

import tuts.tut9.todo.bridge.devices.Device;

public class BasicRemote implements Remote {
	protected Device device;

	public BasicRemote() {
	}

	public BasicRemote(Device device) {
		this.device = device;
	}

	@Override
	public void power() {
		System.out.println("Remote: power toggle");
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
		}
	}

	//TO-DO: Implement the volumeDown() method
	@Override
	public void volumeDown() {
		//Display the current status is 'volume down'
        this.volumeDown();
        //Decrease the current volume for 10
		int volume = device.getVolume();
		volume -= 10;
		System.out.println("Decrease the current volume for 10: " + volume);
	}

	//TO-DO: Implement the volumeUp() method
	@Override
	public void volumeUp() {
		//Display the current status is 'volume up'
        this.volumeUp();
        //Increase the current volume for 10
		int volume = device.getVolume();
		volume += 10;
		System.out.println("Increase the current volume for 10: " + volume);
	}

	//TO-DO: Implement the channelDown() method
	@Override
	public void channelDown() {
		//Display the current status is 'channel down'
		this.channelDown();
        
        //Decrease the current channel for 1
		int chanel = device.getChannel();
		chanel -= 1;
		System.out.println("Decrease the current channel for 1: " + chanel);
	}
	
	//TO-DO: Implement the channelUp() method
	@Override
	public void channelUp() {
		//Display the current status is 'channel up'
        this.channelUp();
        //Increase the current channel for 1
		int chanel = device.getChannel();
		chanel += 1;
		System.out.println("Increase the current channel for 1: " + chanel);
	}
}
