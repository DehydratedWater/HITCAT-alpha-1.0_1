package tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class ToolBox 
{
	private static float tilePixelWidth;
	private static float tilePixelHeight;
	
	public static float[] translateIsometricView(float[] point)
	{
		if(tilePixelHeight==0||tilePixelWidth==0)
		{
			Gdx.app.error("Not loaded Tile Map Tiles sizes", "Tile Map Tiles sizes: "+tilePixelWidth+" "+tilePixelHeight);
			return null;
		}
		point[0] -= tilePixelWidth/4;
		point[1] += tilePixelHeight/2; 
		
		float x, y;
    	
    	x = (point[0] + point[1]);
    	y = -(point[0] - point[1]) / 2;
    	
    	point[0] = x;
    	point[1] = y;
    	
    	return point;
	}
	
	public static void setTileSize(TiledMap map)
	{
		tilePixelWidth = map.getProperties().get("tilewidth", Integer.class);
        tilePixelHeight = map.getProperties().get("tileheight", Integer.class);
	}
}
