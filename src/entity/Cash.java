package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This is the cash icon for the E-Bank
 */
public class Cash{
	public BufferedImage IMAGE;
	
	public Cash() {
		File file = new File("D:/New folder/Bank/src/money.jpeg");
		try {
			IMAGE = ImageIO.read(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
