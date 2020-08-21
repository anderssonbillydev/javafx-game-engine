package game_engine.render;

// FORMAT BGRA
// BLUE, GREEN, RED, ALPHA
public class Color {

	public static final byte[] WHITE = {(byte) 255, (byte) 255, (byte) 255, (byte) 255};
	public static final byte[] BLACK = {0, 0, 0, (byte) 255};

	public static final byte[] RED = {0, 0, (byte) 255, (byte) 255};
	public static final byte[] GREEN = {0, (byte) 255, 0, (byte) 255};
	public static final byte[] BLUE = {(byte) 255, 0, 0, (byte) 255};
}
