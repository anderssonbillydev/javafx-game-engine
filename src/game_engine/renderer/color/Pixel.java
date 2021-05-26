package game_engine.renderer.color;

public class Pixel {

	private byte[] rgb;

	public Pixel(byte[] bgra) {
		rgb = bgra;
	}

	public Pixel(int r, int g, int b) {
		this(r, g, b, 255);
	}

	public Pixel(int r, int g, int b, int a) {
		rgb = new byte[4];
		rgb[0] = setValueValidRange(b);
		rgb[1] = setValueValidRange(g);
		rgb[2] = setValueValidRange(r);
		rgb[3] = setValueValidRange(a);
	}

	public byte[] getRGB() {
		return rgb;
	}

	public int getBlue() {
		return rgb[0] & 0xFF;
	}

	public int getGreen() {
		return rgb[1] & 0xFF;
	}

	public int getRed() {
		return rgb[2] & 0xFF;
	}

	public int getAlpha() {
		return rgb[3] & 0xFF;
	}

	public void setRed(int r) {
		rgb[2] = setValueValidRange(r);
	}

	public void setGreen(int g) {
		rgb[1] = setValueValidRange(g);
	}

	public void setBlue(int b) {
		rgb[0] = setValueValidRange(b);
	}

	public void setAlpha(int a) {
		rgb[3] = setValueValidRange(a);
	}

	private byte setValueValidRange(int value) {
		if (value > 255)
			value = 255;
		if (value < 0)
			value = 0;
		return (byte) value;
	}
}
