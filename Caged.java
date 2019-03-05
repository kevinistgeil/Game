package class15.caged;

import java.awt.Color;

import acm.program.GraphicsProgram;

/**
 * This is our main program. It is responsible for creating all of the objects
 * that are part of the MVC pattern and connecting them with each other.
 */
public class Caged extends GraphicsProgram {

	@Override
	public void init() {
		setSize(750,750);
		this.setBackground(Color.LIGHT_GRAY);

		// Create the world
		World world = new World(4, 6);

		// Create two views and let the world know about them
		GView gview = new GView();
		add(gview);
		world.registerView(gview);

		ConsoleView cview = new ConsoleView();
		world.registerView(cview);

		// Create the controller
		new GController(world, this);
	}

}
