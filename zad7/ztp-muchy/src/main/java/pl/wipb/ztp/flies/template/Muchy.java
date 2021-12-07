package pl.wipb.ztp.flies.template;

import pl.wipb.ztp.flies.strategy.MuchaCircleStrategy;
import pl.wipb.ztp.flies.strategy.MuchaRandomStrategy;
import pl.wipb.ztp.flies.strategy.MuchaStreightStrategy;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Muchy extends JPanel implements Runnable {

	private Mucha[] ar;

	public Muchy() {
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Mucha[30];
		for (int i = 0; i < ar.length; ++i) {
			int min=0,max=3;
			int index = (int) ((Math.random() * (max - min)) + min);

			if(index==0)
				ar[i] = new MuchaCircle();
			else if(index==1)
				ar[i] = new MuchaRandom();
			else{
				ar[i] = new MuchaStreight();
			}

		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ar.length; ++i) {
			ar[i].draw(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < ar.length; ++i) {
				ar[i].move();
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");

		JFrame frame = new JFrame("Muchy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Muchy m = new Muchy();
		frame.getContentPane().add(m);
		frame.pack();
		frame.setVisible(true);
		new Thread(m).start();
	}
}