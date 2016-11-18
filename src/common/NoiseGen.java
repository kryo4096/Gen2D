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

    public float[][] generateNoiseMap(int w, int h,ITerrainDensityProvider idp, int iterations, int size, float deviation, float verticalChange){

        System.out.println("Baking density provider...");
        float[] bread = idp.bake(h,verticalChange); //lol funny

        System.out.println("Generating noisemap...");

        float[][] map = new float[w][h];
        for(int x = 0; x<w;x++) {
            for(int y = 0; y<h;y++) {
                map[x][y] = gauss()*deviation+bread[y];
            }
        }


        final float[][] old = map;

        System.out.println("Generating terrain...");
        for (int i = 0; i < iterations; i++) {
            System.out.println("Entering Phase " + (i+1) + "...");
            for(int x = 0; x < w;x++) {
                for (int y = 0; y < h; y++) {
                    int count = 0;
                    float sum = 0;
                    for(int rel_x= -size; rel_x < size;rel_x++) {
                        for (int rel_y = -size; rel_y < size; rel_y++) {

                            int abs_x;
                            if (x + rel_x > 0 && x + rel_x < w) abs_x = x + rel_x;
                            else abs_x = -1;

                            int abs_y;
                            if (y + rel_y > 0 && x + rel_y < w) abs_y = x + rel_y;
                            else abs_y = -1;
                            if(abs_x!=-1&&abs_y!=-1){
                                count++;
                                sum+=old[abs_x][abs_y];
                            }

                        }
                    }
                    map[x][y]+=sum/(float)count;
                }
            }
        }
        System.out.println("Clamping values...");
        for(int x = 0; x<w;x++) {
            for(int y = 0; y<h;y++) {
                map[x][y] = Mathf.clamp(-1f,1f,map[x][y]);
            }
        }
        System.out.println("Done");


        return map;


    }

    
}
