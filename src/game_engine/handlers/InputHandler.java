package game_engine.handlers;

import game_engine.model.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

	private List<KeyCode> keys;
	private Point2D mousePosition;
	private List<MouseButton> mouseButtons;
	private boolean scrollUp, scrollDown;

	public InputHandler(){
		keys = new ArrayList<>();
		mousePosition = new Point2D(0,0);
		mouseButtons = new ArrayList<>();
		scrollUp = false;
		scrollDown = false;
	}

	public void addKey(KeyCode key){
		if(!keys.contains(key))
			keys.add(key);
	}

	public void removeKey(KeyCode key){
		keys.remove(key);
	}

	public boolean isKeyPressed(KeyCode key){
		return keys.contains(key);
	}

	public void addMouseButton(MouseButton button){
		if(!mouseButtons.contains(button))
			mouseButtons.add(button);
	}

	public void removeMouseButton(MouseButton button){
		mouseButtons.remove(button);
	}

	// If scrolling gets set to true, it's true until consumed
	public void setScrollUp(boolean scrollUp){
		scrollDown = false;
		this.scrollUp = scrollUp;
	}

	public void setScrollDown(boolean scrollDown){
		scrollUp = false;
		this.scrollDown = scrollDown;
	}

	public boolean isMouseButtonPressed(MouseButton button){
		return mouseButtons.contains(button);
	}

	public boolean isScrollingUp(){
		boolean value = scrollUp;
		scrollUp = false;
		return value;
	}

	public boolean isScrollingDown(){
		boolean value = scrollDown;
		scrollDown = false;
		return value;
	}

	public void setMouseX(int x){
		mousePosition.setX(x);
	}

	public int getMouseX(){
		return mousePosition.getX();
	}

	public void setMouseY(int y){
		mousePosition.setY(y);
	}

	public int getMouseY(){
		return mousePosition.getY();
	}
}
