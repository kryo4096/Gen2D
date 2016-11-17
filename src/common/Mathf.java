package common;

/**
 * Created by kryo4096 on 17.11.2016.
 */
public final class Mathf {

    private Mathf(){
        //Static Class
    }

    public static float clamp(float min, float max, float value){

        float result = Math.min(max,value);
        result = Math.max(min,result);
        return result;
    }


}
