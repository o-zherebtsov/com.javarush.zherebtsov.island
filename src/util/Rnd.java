package util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Rnd {

    public static int random(int max) {
      return ThreadLocalRandom.current().nextInt(max);
    }

}
