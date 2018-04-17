package usna.mvc.singlewindow;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import usna.util.AppProperties;

/**
 * A simple JFrame extension with the abilities to store/restore window size
 * @author usna
 */
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	protected final static String PROP_WIDTH = "APP_USNA_WIDTH";
	protected final static String PROP_HEIGHT = "APP_USNA_HEIGHT";
	protected final static String PROP_XPOS = "APP_USNA_XPOS";
	protected final static String PROP_YPOS = "APP_USNA_YPOS";
	protected final static String PROP_EXT = "APP_USNA_EXTENDED";

	protected void center() {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	public void loadProperties(final AppProperties prop) {
		int width, height, xPos, yPos;
		if(prop.containsKey(PROP_WIDTH)) {
			width = prop.getIntProperty(PROP_WIDTH);
			height = prop.getIntProperty(PROP_HEIGHT, 380);
			xPos = prop.getIntProperty(PROP_XPOS, 0);
			yPos = prop.getIntProperty(PROP_YPOS, 0);
		} else {
			final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			width = screenSize.width / 2;
			height = screenSize.height / 2;
			xPos = (screenSize.width - width) / 2;
			yPos = (screenSize.height - height) / 2;
		}
		this.setBounds(xPos, yPos, width, height);
		final boolean extState = prop.getBoolProperty(PROP_EXT);
		if(extState) {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			//setUndecorated(true);
		}
	}

	public void storeProperties(final AppProperties prop) {
		final boolean extState = (getExtendedState() == JFrame.MAXIMIZED_BOTH);
		prop.setBoolProperty(PROP_EXT, extState);
		if(extState == false) {
			prop.setIntProperty(PROP_WIDTH, this.getWidth());
			prop.setIntProperty(PROP_HEIGHT, this.getHeight());
			prop.setIntProperty(PROP_XPOS, this.getX());
			prop.setIntProperty(PROP_YPOS, this.getY());
		}
	}
}