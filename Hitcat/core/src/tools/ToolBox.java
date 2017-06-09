package tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.hitcat.GameConstants;

public class ToolBox implements GameConstants
{
	private static float tilePixelWidth;
	private static float tilePixelHeight;
	private static int mapWidth;
	private static int mapHeight;
	
	public static final float getDistanceBetwenPoints(float x1, float y1, float x2, float y2)
	{
		return (float) Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
	}
	
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
    	
    	point[0] = x / PPM;;
    	point[1] = y / PPM;;
    	
    	return point;
	}
	
	public static final float[] reverseIsometricTransform(float[] vertices)
	{
		vertices[1]*=2;
		float x, y;
		y = (vertices[0] + vertices[1])/2;
		x = vertices[0] - y;
		
		x += tilePixelWidth/4;
    	y -= tilePixelHeight/2;
    	
    	
    	vertices[0] = x-15.8f;
    	vertices[1] = y+15.85f;
    	
    	return vertices;
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
        mapWidth = map.getProperties().get("width", Integer.class);
        mapHeight = map.getProperties().get("height", Integer.class);
	}
}
