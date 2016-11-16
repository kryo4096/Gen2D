package common;

/**
 * Created by kryo4096 on 16.11.2016.
 */
class BakedTerrainDensityProvider {
    private float[] densityArray;

    protected float valueAt(int y) {
        return densityArray[y];
    }

    protected BakedTerrainDensityProvider(int size, final ITerrainDensityProvider tdp, float mult){
        densityArray = new float[size];

        for(int i = 0; i < size; i++) densityArray[i] = (tdp.valueAt(1 / (float) i)*2-1)*mult;


    }
}
