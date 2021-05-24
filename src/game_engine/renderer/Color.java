package game_engine.renderer;

// FORMAT BGRA
// BLUE, GREEN, RED, ALPHA
public class Color {

	/**
	 *	RGB Int Value: 0, 0, 0
	 *  <div style="border:1px solid black;width:50px;height:50px"></div>
	 */
	public static final byte[] TRANSPARENT				= {(byte) 0, (byte)  0, (byte)  0, (byte) 0};

	//////
	// Red colors
	/**
	 *	RGB Int Value: 205, 92, 92
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(205, 92, 92)"></div>
	 */
	public static final byte[] INDIAN_RED				= {(byte) 92, (byte)  92, (byte)  205, (byte) 255};
	/**
	 *	RGB Int Value: 240, 128, 128
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(240,128,128)"></div>
	 */
	public static final byte[] LIGHT_CORAL				= {(byte) 128, (byte) 128, (byte) 240, (byte) 255};
	/**
	 *	RGB Int Value: 250, 128, 114
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(250,128,114)"></div>
	 */
	public static final byte[] SALMON					= {(byte) 114, (byte) 128, (byte) 250, (byte) 255};
	/**
	 *	RGB Int Value: 233, 150, 122
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(233,150,122)"></div>
	 */
	public static final byte[] DARK_SALMON				= {(byte) 122, (byte) 150, (byte) 233, (byte) 255};
	/**
	 *	RGB Int Value: 220, 20, 60
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(220, 20, 60)"></div>
	 */
	public static final byte[] CRIMSON					= {(byte) 60, (byte)  20, (byte)  220, (byte) 255};
	/**
	 *	RGB Int Value: 255, 0, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,  0,  0)"></div>
	 */
	public static final byte[] RED						= {(byte) 0, (byte)   0, (byte)   255, (byte) 255};
	/**
	 *	RGB Int Value: 178, 34, 34
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(178, 34, 34)"></div>
	 */
	public static final byte[] FIRE_BRICK				= {(byte) 34, (byte)  34, (byte)  178, (byte) 255};
	/**
	 *	RGB Int Value: 139, 0, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(139,  0,  0)"></div>
	 */
	public static final byte[] DARK_RED					= {(byte) 0, (byte)   0, (byte)   139, (byte) 255};

	//////
	// Pink colors
	/**
	 *	RGB Int Value: 255, 192, 203
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,192,203)"></div>
	 */
	public static final byte[] PINK						= {(byte) 203, (byte) 192, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 182, 193
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,182,193)"></div>
	 */
	public static final byte[] LIGHT_PINK				= {(byte) 193, (byte) 182, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 105, 180
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,105,180)"></div>
	 */
	public static final byte[] HOT_PINK					= {(byte) 180, (byte) 105, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 20, 147
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255, 20,147)"></div>
	 */
	public static final byte[] DEEP_PINK				= {(byte) 147, (byte)  20, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 199, 21, 133
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(199, 21,133)"></div>
	 */
	public static final byte[] MEDIUM_VIOLET_RED		= {(byte) 133, (byte)  21, (byte) 199, (byte) 255};
	/**
	 *	RGB Int Value: 219, 112, 147
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(219,112,147)"></div>
	 */
	public static final byte[] PALE_VIOLET_RED			= {(byte) 147, (byte) 112, (byte) 219, (byte) 255};

	//////
	// Orange colors
	/**
	 *	RGB Int Value: 255, 160, 122
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,160,122)"></div>
	 */
	public static final byte[] LIGHT_SALMON				= {(byte) 122, (byte) 160, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 127, 80
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,127, 80)"></div>
	 */
	public static final byte[] CORAL					= {(byte) 80, (byte) 127, (byte)  255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 99, 71
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255, 99, 71)"></div>
	 */
	public static final byte[] TOMATO					= {(byte) 71, (byte)  99, (byte)  255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 69, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255, 69,  0)"></div>
	 */
	public static final byte[] ORANGERED				= {(byte) 0, (byte)  69, (byte)   255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 140, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,140,  0)"></div>
	 */
	public static final byte[] DARK_ORANGE				= {(byte) 0, (byte) 140, (byte)   255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 165, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,165,  0)"></div>
	 */
	public static final byte[] ORANGE					= {(byte) 0, (byte) 165, (byte)   255, (byte) 255};

	//////
	// Yellow colors
	/**
	 *	RGB Int Value: 255, 215, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,215,  0)"></div>
	 */
	public static final byte[] GOLD						= {(byte) 0, (byte) 215, (byte)   255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 255, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,255,  0)"></div>
	 */
	public static final byte[] YELLOW					= {(byte) 0, (byte) 255, (byte)   255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 255, 224
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,255,224)"></div>
	 */
	public static final byte[] LIGHT_YELLOW				= {(byte) 224, (byte) 255, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 250, 205
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,250,205)"></div>
	 */
	public static final byte[] LEMON_CHIFFON			= {(byte) 205, (byte) 250, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 250, 250, 210
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(250,250,210)"></div>
	 */
	public static final byte[] LIGHT_GOLDENROD_YELLOW	= {(byte) 210, (byte) 250, (byte) 250, (byte) 255};
	/**
	 *	RGB Int Value: 255, 239, 213
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,239,213)"></div>
	 */
	public static final byte[] PAPAYA_WHIP				= {(byte) 213, (byte) 239, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 228, 181
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,228,181)"></div>
	 */
	public static final byte[] MOCCASIN					= {(byte) 181, (byte) 228, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 218, 185
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,218,185)"></div>
	 */
	public static final byte[] PEACH_PUFF				= {(byte) 185, (byte) 218, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 238, 232, 170
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(238,232,170)"></div>
	 */
	public static final byte[] PALE_GOLDENROD			= {(byte) 170, (byte) 232, (byte) 238, (byte) 255};
	/**
	 *	RGB Int Value: 240, 230, 140
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(240,230,140)"></div>
	 */
	public static final byte[] KHAKI					= {(byte) 140, (byte) 230, (byte) 240, (byte) 255};
	/**
	 *	RGB Int Value: 189, 183, 107
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(189,183,107)"></div>
	 */
	public static final byte[] DARK_KHAKI				= {(byte) 107, (byte) 183, (byte) 189, (byte) 255};

	//////
	// Purple colors
	/**
	 *	RGB Int Value: 230, 230, 250
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(230,230,250)"></div>
	 */
	public static final byte[] LAVENDER					= {(byte) 250, (byte) 230, (byte) 230, (byte) 255};
	/**
	 *	RGB Int Value: 216, 191, 216
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(216,191,216)"></div>
	 */
	public static final byte[] THISTLE					= {(byte) 216, (byte) 191, (byte) 216, (byte) 255};
	/**
	 *	RGB Int Value: 221, 160, 221
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(221,160,221)"></div>
	 */
	public static final byte[] PLUM						= {(byte) 221, (byte) 160, (byte) 221, (byte) 255};
	/**
	 *	RGB Int Value: 238, 130, 238
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(238,130,238)"></div>
	 */
	public static final byte[] VIOLET					= {(byte) 238, (byte) 130, (byte) 238, (byte) 255};
	/**
	 *	RGB Int Value: 218, 112, 214
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(218,112,214)"></div>
	 */
	public static final byte[] ORCHID					= {(byte) 214, (byte) 112, (byte) 218, (byte) 255};
	/**
	 *	RGB Int Value: 255, 0, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,  0,255)"></div>
	 */
	public static final byte[] FUCHSIA					= {(byte) 255, (byte)   0, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 0, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,  0,255)"></div>
	 */
	public static final byte[] MAGENTA					= {(byte) 255, (byte)   0, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 186, 85, 211
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(186, 85,211)"></div>
	 */
	public static final byte[] MEDIUM_ORCHID			= {(byte) 211, (byte)  85, (byte) 186, (byte) 255};
	/**
	 *	RGB Int Value: 147, 112, 219
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(147,112,219)"></div>
	 */
	public static final byte[] MEDIUM_PURPLE			= {(byte) 219, (byte) 112, (byte) 147, (byte) 255};
	/**
	 *	RGB Int Value: 153, 102, 204
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(153,102,204)"></div>
	 */
	public static final byte[] AMETHYST					= {(byte) 204, (byte) 102, (byte) 153, (byte) 255};
	/**
	 *	RGB Int Value: 138, 43, 226
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(138, 43,226)"></div>
	 */
	public static final byte[] BLUE_VIOLET				= {(byte) 226, (byte)  43, (byte) 138, (byte) 255};
	/**
	 *	RGB Int Value: 148, 0, 211
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(148,  0,211)"></div>
	 */
	public static final byte[] DARK_VIOLET				= {(byte) 211, (byte)   0, (byte) 148, (byte) 255};
	/**
	 *	RGB Int Value: 153, 50, 204
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(153, 50,204)"></div>
	 */
	public static final byte[] DARK_ORCHID				= {(byte) 204, (byte)  50, (byte) 153, (byte) 255};
	/**
	 *	RGB Int Value: 139, 0, 139
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(139,  0,139)"></div>
	 */
	public static final byte[] DARK_MAGENTA				= {(byte) 139, (byte)   0, (byte) 139, (byte) 255};
	/**
	 *	RGB Int Value: 128, 0, 128
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(128,  0,128)"></div>
	 */
	public static final byte[] PURPLE					= {(byte) 128, (byte)   0, (byte) 128, (byte) 255};
	/**
	 *	RGB Int Value: 75, 0, 130
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 75,  0,130)"></div>
	 */
	public static final byte[] INDIGO					= {(byte)  130, (byte)   0, (byte) 75, (byte) 255};
	/**
	 *	RGB Int Value: 106, 90, 205
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(106, 90,205)"></div>
	 */
	public static final byte[] SLATE_BLUE				= {(byte) 205, (byte)  90, (byte) 106, (byte) 255};
	/**
	 *	RGB Int Value: 72, 61, 139
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 72, 61,139)"></div>
	 */
	public static final byte[] DARK_SLATE_BLUE			= {(byte)  139, (byte)  61, (byte) 72, (byte) 255};

	//////
	// Green colors
	/**
	 *	RGB Int Value: 173, 255, 47
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(173,255, 47)"></div>
	 */
	public static final byte[] GREEN_YELLOW				= {(byte) 47, (byte) 255, (byte)  173, (byte) 255};
	/**
	 *	RGB Int Value: 127, 255, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(127,255,  0)"></div>
	 */
	public static final byte[] CHARTREUSE				= {(byte) 0, (byte) 255, (byte)   127, (byte) 255};
	/**
	 *	RGB Int Value: 124, 252, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(124,252,  0)"></div>
	 */
	public static final byte[] LAWN_GREEN				= {(byte) 0, (byte) 252, (byte)   124, (byte) 255};
	/**
	 *	RGB Int Value: 0, 255, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,255,  0)"></div>
	 */
	public static final byte[] LIME						= {(byte)   0, (byte) 255, (byte)   0, (byte) 255};
	/**
	 *	RGB Int Value: 50, 205, 50
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 50,205, 50)"></div>
	 */
	public static final byte[] LIME_GREEN				= {(byte)  50, (byte) 205, (byte)  50, (byte) 255};
	/**
	 *	RGB Int Value: 152, 251, 152
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(152,251,152)"></div>
	 */
	public static final byte[] PALE_GREEN				= {(byte) 152, (byte) 251, (byte) 152, (byte) 255};
	/**
	 *	RGB Int Value: 144, 238, 144
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(144,238,144)"></div>
	 */
	public static final byte[] LIGHT_GREEN				= {(byte) 144, (byte) 238, (byte) 144, (byte) 255};
	/**
	 *	RGB Int Value: 0, 250, 154
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,250,154)"></div>
	 */
	public static final byte[] MEDIUM_SPRING_GREEN		= {(byte)   154, (byte) 250, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 255, 127
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,255,127)"></div>
	 */
	public static final byte[] SPRING_GREEN				= {(byte)   127, (byte) 255, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 60, 179, 113
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 60,179,113)"></div>
	 */
	public static final byte[] MEDIUM_SEA_GREEN			= {(byte)  113, (byte) 179, (byte) 60, (byte) 255};
	/**
	 *	RGB Int Value: 46, 139, 87
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 46,139, 87)"></div>
	 */
	public static final byte[] SEA_GREEN				= {(byte)  87, (byte) 139, (byte)  46, (byte) 255};
	/**
	 *	RGB Int Value: 34, 139, 34
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 34,139, 34)"></div>
	 */
	public static final byte[] FOREST_GREEN				= {(byte)  34, (byte) 139, (byte)  34, (byte) 255};
	/**
	 *	RGB Int Value: 0, 128, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,128,  0)"></div>
	 */
	public static final byte[] GREEN					= {(byte)   0, (byte) 128, (byte)   0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 100, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,100,  0)"></div>
	 */
	public static final byte[] DARK_GREEN				= {(byte)   0, (byte) 100, (byte)   0, (byte) 255};
	/**
	 *	RGB Int Value: 154, 205, 50
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(154,205, 50)"></div>
	 */
	public static final byte[] YELLOW_GREEN				= {(byte) 50, (byte) 205, (byte)  154, (byte) 255};
	/**
	 *	RGB Int Value: 107, 142, 35
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(107,142, 35)"></div>
	 */
	public static final byte[] OLIVE_DRAB				= {(byte) 35, (byte) 142, (byte)  107, (byte) 255};
	/**
	 *	RGB Int Value: 128, 128, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(128,128,  0)"></div>
	 */
	public static final byte[] OLIVE					= {(byte) 0, (byte) 128, (byte)   128, (byte) 255};
	/**
	 *	RGB Int Value: 85, 107, 47
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 85,107, 47)"></div>
	 */
	public static final byte[] DARK_OLIVE_GREEN			= {(byte)  47, (byte) 107, (byte)  85, (byte) 255};
	/**
	 *	RGB Int Value: 102, 205, 170
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(102,205,170)"></div>
	 */
	public static final byte[] MEDIUM_AQUAMARINE		= {(byte) 170, (byte) 205, (byte) 102, (byte) 255};
	/**
	 *	RGB Int Value: 143, 188, 143
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(143,188,143)"></div>
	 */
	public static final byte[] DARK_SEA_GREEN			= {(byte) 143, (byte) 188, (byte) 143, (byte) 255};
	/**
	 *	RGB Int Value: 32, 178, 170
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 32,178,170)"></div>
	 */
	public static final byte[] LIGHT_SEA_GREEN			= {(byte)  170, (byte) 178, (byte) 32, (byte) 255};
	/**
	 *	RGB Int Value: 0, 139, 139
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,139,139)"></div>
	 */
	public static final byte[] DARK_CYAN				= {(byte)   139, (byte) 139, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 128, 128
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,128,128)"></div>
	 */
	public static final byte[] TEAL						= {(byte)   128, (byte) 128, (byte) 0, (byte) 255};

	//////
	// Blue colors
	/**
	 *	RGB Int Value: 0, 255, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,255,255)"></div>
	 */
	public static final byte[] AQUA						= {(byte)   255, (byte) 255, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 255, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,255,255)"></div>
	 */
	public static final byte[] CYAN						= {(byte)   255, (byte) 255, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 224, 255, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(224,255,255)"></div>
	 */
	public static final byte[] LIGHT_CYAN				= {(byte) 255, (byte) 255, (byte) 224, (byte) 255};
	/**
	 *	RGB Int Value: 175, 238, 238
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(175,238,238)"></div>
	 */
	public static final byte[] PALE_TURQUOISE			= {(byte) 238, (byte) 238, (byte) 175, (byte) 255};
	/**
	 *	RGB Int Value: 127, 255, 212
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(127,255,212)"></div>
	 */
	public static final byte[] AQUAMARINE				= {(byte) 212, (byte) 255, (byte) 127, (byte) 255};
	/**
	 *	RGB Int Value: 64, 224, 208
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 64,224,208)"></div>
	 */
	public static final byte[] TURQUOISE				= {(byte)  208, (byte) 224, (byte) 64, (byte) 255};
	/**
	 *	RGB Int Value: 72, 209, 204
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 72,209,204)"></div>
	 */
	public static final byte[] MEDIUM_TURQUOISE			= {(byte)  204, (byte) 209, (byte) 72, (byte) 255};
	/**
	 *	RGB Int Value: 0, 206, 209
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,206,209)"></div>
	 */
	public static final byte[] DARK_TURQUOISE			= {(byte)   209, (byte) 206, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 95, 158, 160
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 95,158,160)"></div>
	 */
	public static final byte[] CADET_BLUE				= {(byte)  160, (byte) 158, (byte) 95, (byte) 255};
	/**
	 *	RGB Int Value: 70, 130, 180
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 70,130,180)"></div>
	 */
	public static final byte[] STEEL_BLUE				= {(byte)  180, (byte) 130, (byte) 70, (byte) 255};
	/**
	 *	RGB Int Value: 176, 196, 222
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(176,196,222)"></div>
	 */
	public static final byte[] LIGHT_STEEL_BLUE			= {(byte) 222, (byte) 196, (byte) 176, (byte) 255};
	/**
	 *	RGB Int Value: 176, 224, 230
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(176,224,230)"></div>
	 */
	public static final byte[] POWDER_BLUE				= {(byte) 230, (byte) 224, (byte) 176, (byte) 255};
	/**
	 *	RGB Int Value: 173, 216, 230
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(173,216,230)"></div>
	 */
	public static final byte[] LIGHT_BLUE				= {(byte) 230, (byte) 216, (byte) 173, (byte) 255};
	/**
	 *	RGB Int Value: 135, 206, 235
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(135,206,235)"></div>
	 */
	public static final byte[] SKY_BLUE					= {(byte) 235, (byte) 206, (byte) 135, (byte) 255};
	/**
	 *	RGB Int Value: 135, 206, 250
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(135,206,250)"></div>
	 */
	public static final byte[] LIGHT_SKY_BLUE			= {(byte) 250, (byte) 206, (byte) 135, (byte) 255};
	/**
	 *	RGB Int Value: 0, 191, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,191,255)"></div>
	 */
	public static final byte[] DEEP_SKY_BLUE			= {(byte)   255, (byte) 191, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 30, 144, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 30,144,255)"></div>
	 */
	public static final byte[] DODGER_BLUE				= {(byte)  255, (byte) 144, (byte) 30, (byte) 255};
	/**
	 *	RGB Int Value: 100, 149, 237
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(100,149,237)"></div>
	 */
	public static final byte[] CORNFLOWER_BLUE			= {(byte) 237, (byte) 149, (byte) 100, (byte) 255};
	/**
	 *	RGB Int Value: 123, 104, 238
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(123,104,238)"></div>
	 */
	public static final byte[] MEDIUM_SLATE_BLUE		= {(byte) 238, (byte) 104, (byte) 123, (byte) 255};
	/**
	 *	RGB Int Value: 65, 105, 225
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 65,105,225)"></div>
	 */
	public static final byte[] ROYAL_BLUE				= {(byte)  225, (byte) 105, (byte) 65, (byte) 255};
	/**
	 *	RGB Int Value: 0, 0, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,  0,255)"></div>
	 */
	public static final byte[] BLUE						= {(byte)   255, (byte)   0, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 0, 205
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,  0,205)"></div>
	 */
	public static final byte[] MEDIUM_BLUE				= {(byte)   205, (byte)   0, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 0, 139
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,  0,139)"></div>
	 */
	public static final byte[] DARK_BLUE				= {(byte)   139, (byte)   0, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 0, 0, 128
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,  0,128)"></div>
	 */
	public static final byte[] NAVY						= {(byte)   128, (byte)   0, (byte) 0, (byte) 255};
	/**
	 *	RGB Int Value: 25,25, 112
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 25, 25,112)"></div>
	 */
	public static final byte[] MIDNIGHT_BLUE			= {(byte)  112, (byte)  25, (byte) 25, (byte) 255};

	//////
	// Brown colors
	/**
	 *	RGB Int Value: 255, 248, 220
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,248,220)"></div>
	 */
	public static final byte[] CORNSILK					= {(byte) 220, (byte) 248, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 235, 205
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,235,205)"></div>
	 */
	public static final byte[] BLANCHED_ALMOND			= {(byte) 205, (byte) 235, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 228, 196
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,228,196)"></div>
	 */
	public static final byte[] BISQUE					= {(byte) 196, (byte) 228, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 222, 173
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,222,173)"></div>
	 */
	public static final byte[] NAVAJO_WHITE				= {(byte) 173, (byte) 222, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 245, 222, 179
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(245,222,179)"></div>
	 */
	public static final byte[] WHEAT					= {(byte) 179, (byte) 222, (byte) 245, (byte) 255};
	/**
	 *	RGB Int Value: 222, 184, 135
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(222,184,135)"></div>
	 */
	public static final byte[] BURLY_WOOD				= {(byte) 135, (byte) 184, (byte) 222, (byte) 255};
	/**
	 *	RGB Int Value: 210, 180, 140
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(210,180,140)"></div>
	 */
	public static final byte[] TAN						= {(byte) 140, (byte) 180, (byte) 210, (byte) 255};
	/**
	 *	RGB Int Value: 188, 143, 143
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(188,143,143)"></div>
	 */
	public static final byte[] ROSY_BROWN				= {(byte) 143, (byte) 143, (byte) 188, (byte) 255};
	/**
	 *	RGB Int Value: 244, 164, 96
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(244,164, 96)"></div>
	 */
	public static final byte[] SANDY_BROWN				= {(byte) 96, (byte) 164, (byte)  244, (byte) 255};
	/**
	 *	RGB Int Value: 218, 165, 32
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(218,165, 32)"></div>
	 */
	public static final byte[] GOLDENROD				= {(byte) 32, (byte) 165, (byte)  218, (byte) 255};
	/**
	 *	RGB Int Value: 184, 134, 11
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(184,134, 11)"></div>
	 */
	public static final byte[] DARK_GOLDENROD			= {(byte) 11, (byte) 134, (byte)  184, (byte) 255};
	/**
	 *	RGB Int Value: 205, 133, 63
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(205,133, 63)"></div>
	 */
	public static final byte[] PERU						= {(byte) 63, (byte) 133, (byte)  205, (byte) 255};
	/**
	 *	RGB Int Value: 210, 105, 30
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(210,105, 30)"></div>
	 */
	public static final byte[] CHOCOLATE				= {(byte) 30, (byte) 105, (byte)  210, (byte) 255};
	/**
	 *	RGB Int Value: 139, 69, 19
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(139, 69, 19)"></div>
	 */
	public static final byte[] SADDLE_BROWN				= {(byte) 19, (byte)  69, (byte)  139, (byte) 255};
	/**
	 *	RGB Int Value: 160, 82, 45
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(160, 82, 45)"></div>
	 */
	public static final byte[] SIENNA					= {(byte) 45, (byte)  82, (byte)  160, (byte) 255};
	/**
	 *	RGB Int Value: 165, 42, 42
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(165, 42, 42)"></div>
	 */
	public static final byte[] BROWN					= {(byte) 42, (byte)  42, (byte)  165, (byte) 255};
	/**
	 *	RGB Int Value: 128, 0, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(128,  0,  0)"></div>
	 */
	public static final byte[] MAROON					= {(byte) 0, (byte)   0, (byte)   128, (byte) 255};

	//////
	// White colors
	/**
	 *	RGB Int Value: 255, 255, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,255,255)"></div>
	 */
	public static final byte[] WHITE					= {(byte) 255, (byte) 255, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 250, 250
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,250,250)"></div>
	 */
	public static final byte[] SNOW						= {(byte) 250, (byte) 250, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 240, 255, 240
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(240,255,240)"></div>
	 */
	public static final byte[] HONEYDEW					= {(byte) 240, (byte) 255, (byte) 240, (byte) 255};
	/**
	 *	RGB Int Value: 245, 255, 250
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(245,255,250)"></div>
	 */
	public static final byte[] MINT_CREAM				= {(byte) 250, (byte) 255, (byte) 245, (byte) 255};
	/**
	 *	RGB Int Value: 240, 255, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(240,255,255)"></div>
	 */
	public static final byte[] AZURE					= {(byte) 255, (byte) 255, (byte) 240, (byte) 255};
	/**
	 *	RGB Int Value: 240, 248, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(240,248,255)"></div>
	 */
	public static final byte[] ALICE_BLUE				= {(byte) 255, (byte) 248, (byte) 240, (byte) 255};
	/**
	 *	RGB Int Value: 248, 248, 255
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(248,248,255)"></div>
	 */
	public static final byte[] GHOST_WHITE				= {(byte) 255, (byte) 248, (byte) 248, (byte) 255};
	/**
	 *	RGB Int Value: 245, 245, 245
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(245,245,245)"></div>
	 */
	public static final byte[] WHITE_SMOKE				= {(byte) 245, (byte) 245, (byte) 245, (byte) 255};
	/**
	 *	RGB Int Value: 255, 245, 238
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,245,238)"></div>
	 */
	public static final byte[] SEASHELL					= {(byte) 238, (byte) 245, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 245, 245, 220
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(245,245,220)"></div>
	 */
	public static final byte[] BEIGE					= {(byte) 220, (byte) 245, (byte) 245, (byte) 255};
	/**
	 *	RGB Int Value: 253, 245, 230
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(253,245,230)"></div>
	 */
	public static final byte[] OLD_LACE					= {(byte) 230, (byte) 245, (byte) 253, (byte) 255};
	/**
	 *	RGB Int Value: 255, 250, 240
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,250,240)"></div>
	 */
	public static final byte[] FLORAL_WHITE				= {(byte) 240, (byte) 250, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 255, 240
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,255,240)"></div>
	 */
	public static final byte[] IVORY					= {(byte) 240, (byte) 255, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 250, 235, 215
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(250,235,215)"></div>
	 */
	public static final byte[] ANTIQUE_WHITE			= {(byte) 215, (byte) 235, (byte) 250, (byte) 255};
	/**
	 *	RGB Int Value: 250, 240, 230
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(250,240,230)"></div>
	 */
	public static final byte[] LINEN					= {(byte) 230, (byte) 240, (byte) 250, (byte) 255};
	/**
	 *	RGB Int Value: 255, 240, 245
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,240,245)"></div>
	 */
	public static final byte[] LAVENDER_BLUSH			= {(byte) 245, (byte) 240, (byte) 255, (byte) 255};
	/**
	 *	RGB Int Value: 255, 228, 225
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(255,228,225)"></div>
	 */
	public static final byte[] MISTY_ROSE				= {(byte) 225, (byte) 228, (byte) 255, (byte) 255};

	//////
	// Grey colors
	/**
	 *	RGB Int Value: 220, 220, 220
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(220,220,220)"></div>
	 */
	public static final byte[] GAINSBORO				= {(byte) 220, (byte) 220, (byte) 220, (byte) 255};
	/**
	 *	RGB Int Value: 211, 211, 211
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(211,211,211)"></div>
	 */
	public static final byte[] LIGHT_GREY				= {(byte) 211, (byte) 211, (byte) 211, (byte) 255};
	/**
	 *	RGB Int Value: 192, 192, 192
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(192,192,192)"></div>
	 */
	public static final byte[] SILVER					= {(byte) 192, (byte) 192, (byte) 192, (byte) 255};
	/**
	 *	RGB Int Value: 169, 169, 169
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(169,169,169)"></div>
	 */
	public static final byte[] DARK_GRAY				= {(byte) 169, (byte) 169, (byte) 169, (byte) 255};
	/**
	 *	RGB Int Value: 128, 128, 128
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(128,128,128)"></div>
	 */
	public static final byte[] GRAY						= {(byte) 128, (byte) 128, (byte) 128, (byte) 255};
	/**
	 *	RGB Int Value: 105, 105, 105
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(105,105,105)"></div>
	 */
	public static final byte[] DIM_GRAY					= {(byte) 105, (byte) 105, (byte) 105, (byte) 255};
	/**
	 *	RGB Int Value: 119, 136, 153
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(119,136,153)"></div>
	 */
	public static final byte[] LIGHT_SLATE_GRAY			= {(byte) 153, (byte) 136, (byte) 119, (byte) 255};
	/**
	 *	RGB Int Value: 112, 128, 144
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(112,128,144)"></div>
	 */
	public static final byte[] SLATE_GRAY				= {(byte) 144, (byte) 128, (byte) 112, (byte) 255};
	/**
	 *	RGB Int Value: 47, 79, 79
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb( 47, 79, 79)"></div>
	 */
	public static final byte[] DARK_SLATE_GRAY			= {(byte)  79, (byte)  79, (byte)  47, (byte) 255};
	/**
	 *	RGB Int Value: 0, 0, 0
	 *  <div style="border:1px solid black;width:50px;height:50px;background-color:rgb(  0,  0,  0)"></div>
	 */
	public static final byte[] BLACK					= {(byte)   0, (byte)   0, (byte)   0, (byte) 255};

}
