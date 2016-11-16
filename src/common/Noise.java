package common;

import java.util.Random;

/**
 * Created by ForcedWindows1 on 16.11.2016.
 */
public class Noise {

    public float[][] generateFlatNoiseMap(int w, int h, NoiseType type, int seed){
        Random random = new Random(seed);
        float[][] map = new float[w][h];
        for(int x = 0; x<w;x++) {
            for(int y = 0; y<h;y++) {
                switch (type) {
                    case RANDOM:
                        map[w][h] = random.nextFloat()*2-1;
                        break;
                    case GAUSSIAN:
                        map[w][h] = (float) random.nextGaussian()*2-1;
                        break;
                }
            }
        }

        return map;

    }
}
