package common;

/**
 * Created by kryo4096 on 16.11.2016
 *
 * Basically a function that can be "baked" and is used for Terrain Generation
 **/
public interface ITerrainDensityProvider {

    default BakedTerrainDensityProvider bake(int height, float mult){
        return new BakedTerrainDensityProvider(height,this,mult);
    }

    float valueAt(float f);


}
