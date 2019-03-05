package class15.caged;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

/**
 * A graphical view of the world.
 */
public class GView extends GCompound implements View {

	/** The view's width. */
	public static final int WIDTH = 500;
	/** The view's height. */
	public static final int HEIGHT = 500;

	/** The background rectangle. */
	private final GRect bg;
	/** The Nicholas Cage image. */
	private final GImage image;
	private final GRect Grect1;
	private final GPolygon Lblock;
	private final GPolygon Lblock2;
	private final GPolygon Lblock3;
	private final GPolygon Lblock4;

	/**
	 * Creates a new instance.
	 */
	public GView() {
		// Initialize the background
		bg = new GRect(WIDTH, HEIGHT);
		bg.setFillColor(Color.WHITE);
		bg.setFilled(true);
		add(bg);

		// Initialize Nick
		image = new GImage("class15/caged/nicholas-caged.jpg");
		add(image);
		/** adding up the big 2x2 block. */
		Grect1 = new GRect(WIDTH, HEIGHT);
		Grect1.setFilled(true);
		Grect1.setColor(Color.BLUE);
		add(Grect1);

		/** adding the small l blocks. */
		Lblock = new GPolygon();
		Lblock.addVertex(0, 0);
		Lblock.addEdge(62, 0);
		Lblock.addEdge(0, +42);
		Lblock.addEdge(+63, 0);
		Lblock.addEdge(0, +45);
		Lblock.addEdge(-125, 0);
		Lblock.setFilled(true);
		Lblock.setColor(Color.GREEN);
		Lblock.scale(2);
		add(Lblock);

		/** adding another small Lblock. */
		Lblock2 = new GPolygon();
		Lblock2.addVertex(0, 0);
		Lblock2.addEdge(+125, 0);
		Lblock2.addEdge(0, +83);
		Lblock2.addEdge(-62, 0);
		Lblock2.addEdge(0, -42);
		Lblock2.addEdge(-63, 0);
		Lblock2.scale(2);
		Lblock2.setFilled(true);
		Lblock2.setColor(Color.ORANGE);
		add(Lblock2);

		/** adding another small Lblock. */
		Lblock3 = new GPolygon();
		Lblock3.addVertex(0, 0);
		Lblock3.addEdge(+125, 0);
		Lblock3.addEdge(0, +41);
		Lblock3.addEdge(-63, 0);
		Lblock3.addEdge(0, +45);
		Lblock3.addEdge(-62, 0);
		Lblock3.setFilled(true);
		Lblock3.setColor(Color.RED);
		Lblock3.scale(2);
		add(Lblock3);

		/** adding the last small Lblock. */
		Lblock4 = new GPolygon();
		Lblock4.addVertex(0, 0);
		Lblock4.addEdge(+62, 0);
		Lblock4.addEdge(0, +87);
		Lblock4.addEdge(-125, 0);
		Lblock4.addEdge(0, -45);
		Lblock4.addEdge(+63, 0);
		Lblock4.setFilled(true);
		Lblock4.setColor(Color.PINK);
		Lblock4.scale(2);
		add(Lblock4);

	}

	@Override
	public void update(World world) {
		double cellWidth = WIDTH / world.getWidth();
		double cellHeight = HEIGHT / world.getHeight();

		// Update Nick's size and location
		image.setSize(cellWidth, cellHeight);
		image.setLocation(world.getPlayerX() * cellWidth, world.getPlayerY() * cellHeight);
		Grect1.setSize(cellWidth * 2, cellHeight * 2);
		Grect1.setLocation(world.getPlayerX() * cellWidth + cellWidth, world.getPlayerY() * cellHeight + cellHeight);
		Lblock.setLocation(world.getPlayerX() * cellWidth, world.getPlayerY() * cellHeight + 2 * cellHeight);
		Lblock2.setLocation(world.getPlayerX() * cellWidth + 2 * cellWidth, world.getPlayerY() * cellHeight);
		Lblock3.setLocation(world.getPlayerX() * cellWidth, world.getPlayerY() * cellHeight);
		Lblock4.setLocation(world.getPlayerX() * cellWidth + 3 * cellWidth,
				world.getPlayerY() * cellHeight + 2 * cellHeight);
	}

}
