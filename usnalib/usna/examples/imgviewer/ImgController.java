package usna.examples.imgviewer;

import java.io.FileNotFoundException;
import java.io.IOException;

import usna.mvc.controller.ControllerImpl;
import usna.mvc.view.View;
import usna.util.AppProperties;

public class ImgController extends ControllerImpl<ImgModel> {
	private final ImgDesktopWindow desktop;
	
	public ImgController() throws Exception {
		desktop = new ImgDesktopWindow(this);
		loadProperties();
		desktop.validate();
		desktop.setVisible(true);
	}
	
	/**
	 * Overridden to write property file
	 */
	public boolean closeApp() {
		storeProperties();
		return super.closeApp();
	}
	
	private void loadProperties() throws IOException {
		try {
			final AppProperties prop = new AppProperties(ImgApp.PROP_FILE);
			prop.load(true);
			desktop.loadProperties(prop);
		} catch (FileNotFoundException e) {
			// No file, probably first run
		}
	}
	
	private void storeProperties() {
		final AppProperties prop = new AppProperties(ImgApp.PROP_FILE);
		desktop.storeProperties(prop);
		try {
			prop.store(false);
		}
		catch (IOException ex) {
			ImgApp.error(ex);
		}
	}
	
	public ImgView openModel(final String theFile) {
		final ImgModel newMod = new ImgModel(theFile);
		final ImgView win = new ImgView(newMod, this);
		super.addModel(newMod, win);
		desktop.getViewSelectionBar().addView(win);
		desktop.modelExists(true);
		return win;
	}
	
	/**
	 * Overridden to manage view selection bar and desktop title
	 */
	public void viewClosed(final View theView) {
		super.viewClosed(theView);
		desktop.getViewSelectionBar().removeView(theView);
		if(currentActive == null) { // no more opened models in the application
			desktop.setTitle(ImgApp.APP_NAME);
			desktop.modelExists(false);
		}
	}
	
	/**
	 * Overridden to manage view selection bar and desktop title
	 */
	public void viewGainedFocus(final View theView) {
		desktop.getViewSelectionBar().viewSelected(theView, true);
		desktop.setTitle(ImgApp.APP_NAME + " - " + theView.getViewName());
	}
	
	/**
	 * Overridden to manage view selection bar
	 */
	public void viewLoosedFocus(final View theView) {
		desktop.getViewSelectionBar().viewSelected(theView, false);
	}
}