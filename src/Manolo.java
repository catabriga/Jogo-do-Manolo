import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Manolo 
{
	private Graphics frameGraphics;
	
	private BufferedImage backBuffer;
	private Graphics2D g;
	
	public Manolo()
	{
		JFrame frame = new JFrame("Manolo");
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		frameGraphics = frame.getGraphics();
		
		backBuffer = new BufferedImage(400, 400, BufferedImage.TYPE_4BYTE_ABGR);
		g = backBuffer.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public void mainLoop()
	{
		while(true)
		{
			process();
			paint(g);
			sleep();
		}
	}
	
	private void process()
	{
		
	}
	
	private void paint(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 400);
		
		g.setColor(Color.RED);
		g.fillOval(50, 50, 50, 50);
		
		g.setColor(Color.GREEN);
		g.drawOval(80, 65, 50, 50);
		
		g.setColor(Color.BLUE);
		g.fillRect(58, 80, 50, 50);
		
		Color someColor = new Color(123,43,78);
		g.setColor(someColor);
		g.fillRoundRect(200, 200, 100, 60, 15, 15);
		
		frameGraphics.drawImage(backBuffer, 0, 0, null);
	}
	
	private void sleep()
	{
		try 
		{
			Thread.sleep(15);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Manolo manolo = new Manolo();
		
		manolo.mainLoop();
	}
}
