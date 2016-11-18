package common;

/**
 * Created by kryo4096 on 16.11.2016
 *
 * Basically a function that can be "baked" and is used for Terrain Generation
 **/
public interface ITerrainDensityProvider {

    default float[] bake(int height,float scale){
        float[] densityArray = new float[height];
        float unit = scale/height;
        for(int i = 0; i < height; i++) {
            densityArray[i] = (valueAt(i*unit));

        }

        return densityArray;
    }

    float valueAt(float f);


}
