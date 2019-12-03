public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String output = "IPhone "+this.getVersionNumber() +" says "+this.getRingTone()+ "!";
        return output;
        		
    }
    @Override
    public String unlock() {
    	String output = "Unlocking via facial recognition.";
    	return output;
    }
    @Override
    public void displayInfo() {
    	System.out.println("IPhone "+this.getVersionNumber() +" from "+this.getCarrier()+".");

    }
}