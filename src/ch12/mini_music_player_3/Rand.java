package ch12.mini_music_player_3;
import java.util.Random;

public class Rand {

    public static int rnd(int bound) {
        return new Random().nextInt(bound);
    }

    public static int rnd(int min, int max) {
        int res = rnd(max - min + 1) + min;
        return res;
    }
}
