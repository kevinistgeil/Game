package class15.caged;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import acm.program.GraphicsProgram;

/**
 * Our controller listens for key events on the main window.
 */
public class GController implements KeyListener {

	/** The world that is updated upon every key press. */
	private World world;
	/** The sound clip we play whenever Nick moves. */
	private Clip sound;

	/**
	 * Creates a new instance.
	 * 
	 * @param world the world to be updated whenever Nick should move.
	 * @param caged the {@link GraphicsProgram} we want to listen for key presses
	 *              on.
	 */
	public GController(World world, Caged caged) {
		// Remember the world
		this.world = world;

		// Listen for key events
		caged.getGCanvas().addKeyListener(this);

		// Load the sound file
		try {
			URL url = this.getClass().getClassLoader().getResource("class15/caged/scream.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			sound = AudioSystem.getClip();
			sound.open(audioInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Check if we need to do something
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			world.setPlayerY(Math.max(0, world.getPlayerY() - 1));
			break;

		case KeyEvent.VK_DOWN:
			world.setPlayerY(Math.min(world.getHeight() - 1, world.getPlayerY() + 1));
			break;

		case KeyEvent.VK_LEFT:
			world.setPlayerX(Math.max(0, world.getPlayerX() - 1));
			break;

		case KeyEvent.VK_RIGHT:
			world.setPlayerX(Math.min(world.getWidth() - 1, world.getPlayerX() + 1));
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
