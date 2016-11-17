package common;

/**
 * Created by kryo4096 on 16.11.2016.
 */
class BakedTerrainDensityProvider {
    private float[] densityArray;

    float valueAt(int y) {
        return densityArray[y];
    }

    BakedTerrainDensityProvider(int size, final ITerrainDensityProvider tdp, float scale){
        densityArray = new float[size];
        float unit = scale/size;
        for(int i = 0; i < size; i++) {
            densityArray[i] = (tdp.valueAt(i*unit));

        }


    }
}
