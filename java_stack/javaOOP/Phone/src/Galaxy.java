public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	String output = "Galaxy "+this.getVersionNumber() +" says Ring, Ring, Ring!";
        return output;
    }
    @Override
    public String unlock() {
    	String output = "Unlocking via fingerprint.";
    	return output;
    }
    @Override
    public void displayInfo() {
    	System.out.println("Galaxy "+this.getVersionNumber() +" from "+this.getCarrier()+".");            
    }
}