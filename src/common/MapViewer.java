package common;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kryo4096 on 17.11.2016.
 */
public class MapViewer extends JFrame{

    private MapPanel panel;

    public MapViewer(final float[][] map, int size){
        super();
        panel = new MapPanel();
        panel.pixelMap = map;
        panel.size = size;
        add(panel);

    }

    public static void main(String[] args) {
        NoiseGen gen = new NoiseGen(1234L);
        ITerrainDensityProvider l = new QuadraticDensityProvider(-0.5f,0f,0.7f);
        MapViewer mvp = new MapViewer(gen.generateNoiseMap(100,100,l,0,1,0.2f,2), 2);
        mvp.setSize(120,120);
        mvp.setVisible(true);
    }
}

class MapPanel extends JPanel {

    public float[][] pixelMap;
    public int size;

    @Override
    public void paintComponent(Graphics g){

        int h = pixelMap.length;
        int w = pixelMap[0].length;

        for(int x = 0; x<w;x++)
            for (int y = 0; y < h; y++) {
                float val = pixelMap[x][y] / 2f + 0.5f;
                g.setColor(new Color(val,val,val));
                //(g.setColor(Color.RED);
                g.fillRect(x*size, y*size, size, size);
            }
    }
}