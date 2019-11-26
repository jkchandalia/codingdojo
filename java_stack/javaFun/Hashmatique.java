import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Africa", "This is Africa!");
        trackList.put("Cheap Thrills", "I don't need no mo-ooo-ney.");
        trackList.put("Titanium", "I am titanium.");
        trackList.put("Clouds", "I'm here on Venus!");

        System.out.println(trackList.get("Africa"));
        // get the keys by using the keySet method
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ": " +trackList.get(key));
        }
    }
}