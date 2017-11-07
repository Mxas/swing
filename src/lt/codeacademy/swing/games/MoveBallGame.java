package lt.codeacademy.swing.games;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveBallGame extends JPanel {
	int ballSize = 30;

	int xMove = 1;
	int yMove = 1;
	int x = 0;
	int y = 0;

	private void moveBall() {

		if (x > (getWidth() - ballSize) || x < 0) {
			xMove *= -1;
		}

		if (y > (getHeight() - ballSize) || y < 0) {
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
		MoveBallGame game = new MoveBallGame();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					game.left();
					break;
				case KeyEvent.VK_RIGHT:
					game.right();
					break;
				case KeyEvent.VK_UP:
					game.up();
					break;
				case KeyEvent.VK_DOWN:
					game.down();
					break;

				default:
					break;

				}
				game.repaint();
			}

		});

	}

	private void down() {
		System.out.println("Down");
		if (y <= (getHeight() - ballSize)) {
			y++;
		}
	}

	private void up() {
		System.out.println("Up");
		if (y >= 0) {
			y--;
		}
	}

	private void right() {
		System.out.println("Right");
		if (x <= (getWidth() - ballSize)) {
			x++;
		}
	}

	private void left() {
		System.out.println("Left");
		if (x >= 0) {
			x--;
		}
	}
}
