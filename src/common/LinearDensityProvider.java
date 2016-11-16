package common;

/**
 * Created by kryo4096 on 16.11.2016.
 *
 * A terrain density provider based on a linear function
 */
public class LinearDensityProvider implements ITerrainDensityProvider {

    private float a,b;

    public LinearDensityProvider(float a, float b){
        this.a=a;
        this.b=b;

    }

    public float valueAt(float x) {
        return (a*x+b);
    }

}
