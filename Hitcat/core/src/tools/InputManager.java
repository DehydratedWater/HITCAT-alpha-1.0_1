package tools;


import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;



public class InputManager implements InputProcessor{
 
	public boolean UP, DOWN, RIGHT, LEFT, 
	A, W, S, D, 
	PLUS, MINUS, 
	LEFT_CTRL, LEFT_SHIFT, 
	SPACE, ESCAPE, BACKSPACE,
	RIGHT_BRACKET, LEFT_BRACKET, 
	SCROLLED_UP, SCROLLED_DOWN;
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP){
			UP = true;
		}
		
		
		if(keycode == Keys.DOWN){
			DOWN = true;
		}
		
		
		if(keycode == Keys.RIGHT){
			RIGHT = true;
		}
		
		if(keycode == Keys.LEFT){
			LEFT = true;
		}
		
		
		if(keycode == Keys.A){
			A = true;
		}
		
		if(keycode == Keys.W){
			W = true;
		}
		
		if(keycode == Keys.S){
			S = true;
		}
		
		if(keycode == Keys.D){
			D = true;
		}
		
		if(keycode == Keys.CONTROL_LEFT){
			LEFT_CTRL = true;
		}
		
		if(keycode == Keys.SHIFT_LEFT){
			LEFT_SHIFT = true;
		}
		
		if(keycode == Keys.SPACE){
			SPACE = true;
		}
		
		if(keycode == Keys.ESCAPE){
			ESCAPE = true;
		}
		
		if(keycode == Keys.LEFT_BRACKET){
			LEFT_BRACKET = true;
		}
		
		if(keycode == Keys.RIGHT_BRACKET){
			RIGHT_BRACKET = true;
		}
		
		if(keycode == Keys.BACKSPACE){
			BACKSPACE = true;
		}
		
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP){
			UP = false;
		}
		
		if(keycode == Keys.UP){
			UP = false;
		}
		
		
		if(keycode == Keys.DOWN){
			DOWN = false;
		}
		
		
		if(keycode == Keys.RIGHT){
			RIGHT = false;
		}
		
		if(keycode == Keys.LEFT){
			LEFT = false;
		}
		
		
		if(keycode == Keys.A){
			A = false;
		}
		
		if(keycode == Keys.W){
			W = false;
		}
		
		if(keycode == Keys.S){
			S = false;
		}
		
		if(keycode == Keys.D){
			D = false;
		}
		
		if(keycode == Keys.CONTROL_LEFT){
			LEFT_CTRL = false;
		}
		
		if(keycode == Keys.SHIFT_LEFT){
			LEFT_SHIFT = false;
		}
		
		if(keycode == Keys.SPACE){
			SPACE = false;
		}
		
		if(keycode == Keys.ESCAPE){
			ESCAPE = false;
		}
		
		if(keycode == Keys.LEFT_BRACKET){
			LEFT_BRACKET = false;
		}
		
		if(keycode == Keys.RIGHT_BRACKET){
			RIGHT_BRACKET = false;
		}
		
		if(keycode == Keys.BACKSPACE){
			BACKSPACE = false;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void refreshInput(){

		SCROLLED_DOWN = false;
		SCROLLED_UP = false;
	}

	@Override
	public boolean scrolled(int amount) {
		if(amount > 0){
			SCROLLED_DOWN = true;
			SCROLLED_UP = false;
		}
		
		if(amount < 0){
			SCROLLED_UP = true;
			SCROLLED_DOWN = false;
		}
		
		
		
		return false;
	}

}
