package lt.codeacademy.swing.games;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallGame extends JPanel {
	int ballSize = 30;

	int xMove = 1;
	int yMove = 1;
	int x = 0;
	int y = 0;

	private void moveBall() {

		if (x > (getWidth()-ballSize) || x < 0) {
			xMove *= -1;
		}

		if (y > (getHeight()-ballSize) || y < 0) {
			yMove *= -1;
		}

		x = x + xMove;
		y = y + yMove;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, ballSize, ballSize);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Sample Frame");
		BallGame game = new BallGame();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(5);
		}
	}
}
