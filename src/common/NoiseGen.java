package common;


import java.util.Random;

/**
 * Created by kryo4096 on 16.11.2016.
 */
public class NoiseGen {

    private Random random;
    public NoiseGen(long seed){
        random = new Random(seed);
    }

    public float gauss(){
        return (float) random.nextGaussian()*2-1;
    }

    public float[][] generateNoiseMap(int w, int h, int seed,float mult, ITerrainDensityProvider idp){

        BakedTerrainDensityProvider bread = idp.bake(h, mult); //lol funny
        float[][] map = new float[w][h];
        for(int x = 0; x<w;x++) {
            for(int y = 0; y<h;y++) {
                map[w][h] = gauss()+bread.valueAt(y);
            }
        }

        return map;

    }
}
