package game_engine.handler;

import game_engine.model.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

	// TODO Implement mouse wheel, scroll up and down
	private List<KeyCode> keys;
	private Point2D mousePosition;
	private List<MouseButton> mouseButtons;

	public InputHandler(){
		keys = new ArrayList<>();
		mousePosition = new Point2D(0,0);
		mouseButtons = new ArrayList<>();
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

	public boolean isMouseButtonPressed(MouseButton button){
		return mouseButtons.contains(button);
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
