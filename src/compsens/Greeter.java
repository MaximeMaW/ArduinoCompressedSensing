package compsens;

// Several helper functions to print stuffs
import org.joda.time.LocalTime;

public class Greeter {
    public String sayHello() {
	LocalTime currentTime = new LocalTime();
        return "-- Starting compressed sensing mode, time is: " + currentTime;
    }
    public String sayGoodbye() {
	LocalTime currentTime = new LocalTime();
        return "-- Ending compressed sensing mode, time is: " + currentTime;
    }
    
}
