package common;

/**
 * Created by kryo4096 on 16.11.2016.
 *
 * A terrain density provider based on a linear function
 */
public class QuadraticDensityProvider implements ITerrainDensityProvider {

    private float a,b,c;

    public QuadraticDensityProvider(float a, float b, float c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public float valueAt(float x) {
        return (a*(x*x)+b*x+c);
    }

}
