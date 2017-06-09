package tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.hitcat.GameConstants;

public class ToolBox implements GameConstants
{
	private static float tilePixelWidth;
	private static float tilePixelHeight;
	
	public static final float[] translateIsometricPoint(float[] point)
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
	
	public static final float[] translateIsometricArray(float[] vertices)
	{
		if(tilePixelHeight==0||tilePixelWidth==0)
		{
			Gdx.app.error("Not loaded Tile Map Tiles sizes", "Tile Map Tiles sizes: "+tilePixelWidth+" "+tilePixelHeight);
			return null;
		}
        
        float worldVertices[] = new float[vertices.length];
        float x, y;    
        for(int i = 0; i < vertices.length; i+=2){
        	
        	vertices[i] -= tilePixelWidth/4;
        	vertices[i+1] += tilePixelHeight/2; 
        	x = (vertices[i] + vertices[i+1]);
        	y = -(vertices[i] - vertices[i+1]) / 2;
        	
        	vertices[i] = x;
        	vertices[i+1] = y;
        	
        }
        
        
        for(int i = 0; i < vertices.length; i++){
        	worldVertices [i] = vertices[i] / PPM;
        }
        
        return worldVertices;
	}
	
	public static final void setTileSize(TiledMap map)
	{
		tilePixelWidth = map.getProperties().get("tilewidth", Integer.class);
        tilePixelHeight = map.getProperties().get("tileheight", Integer.class);
	}
}
