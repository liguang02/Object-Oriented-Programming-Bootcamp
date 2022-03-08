import java.util.Random;

public class Utils {
        public static int getRandomConsumption() {
            Random r = new Random();
            int low = 0;
            int high = 1500;
            return (r.nextInt(high - low) + low);
        }



}
