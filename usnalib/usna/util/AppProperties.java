package usna.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>Title: AppProperties</p>
 * <p>Advanced Properties management.
 * <p>Copyright (c) 2003</p>
 * <p>Company: USNA</p>
 * @author Antonio Flaccomio
 * @version 1.0
 */
public class AppProperties extends Properties {

	private static final long serialVersionUID = 1L;
	private final String fileName; // = "Properties.conf";

	/**
	 * Constructor; read the configuration file
	 * @param fileName String - configuration file name
	 * @throws IOException
	 */
	public AppProperties(final String fileName) {
		this.fileName = fileName;
	}

	public AppProperties() {
		this.fileName = "properties.conf";
	}

	/**
	 * Store properties on a file;
	 * @param alsoEmpty true: save empty properties, false: do not save empty properties
	 * @throws IOException
	 */
	public void store(final boolean alsoEmpty) throws IOException {
		if (size() > 0 || alsoEmpty) {
			store();
		}
	}

	/** Save the properties on the file */
	public void store() throws IOException {
		final FileOutputStream file = new FileOutputStream(fileName);
		store(file, null);
		file.close();
	}

	public void load(final boolean acceptEmpty) throws IOException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(fileName);
			super.load(file);
		} catch(FileNotFoundException e) {
			if(acceptEmpty == false) {
				throw e;
			}
		} finally {
			if(file != null) {
				file.close();
			}
		}
	}

	public String getFileName() {
		return fileName;
	}

	/**
	 * Read an integer property
	 *  @return Property value or defaultValue se la proprieta' non esiste o non e' un valido intero
	 */
	public int getIntProperty(final String key, final int defaultValue) {
		final String val = getProperty(key);
		try {
			return Integer.parseInt(val);
		} catch (RuntimeException e) { // NumberFormatException, NullPointerException
			return defaultValue;
		}
	}

	public int getIntProperty(final String key) {
		final String val = getProperty(key);
		try {
			return Integer.parseInt(val);
		} catch (RuntimeException e) { // NumberFormatException, NullPointerException
			return 0;
		}
	}

	/** Scrive una proprieta' */
	public void setIntProperty(final String key, final int value) {
		setProperty(key, value + "");
	}
	
	public boolean getBoolProperty(final String key, final boolean defaultVal) {
		final String val = getProperty(key);
		return val == null ? defaultVal : "true".equals(val);
	}

	public boolean getBoolProperty(final String key) {
		return "true".equals(getProperty(key));
	}

	/** Scrive una proprieta' */
	public void setBoolProperty(final String key, final boolean value) {
		setProperty(key, value ? "true" : "false");
	}

	/** Legge una proprieta', la interpreta come un set di elementi e inserisce gli elementi in un array di String
	 * @param key il nome della chiave
	 * @param sep i separatori che delimitano gli elementi
	 * @return null se la proprieta' non esiste; un array di String altrimenti
	 */
	public String[] getMultipleProperty(final String key, final String sep) {
		final String val = getProperty(key);
		if (val == null) {
			return null;
		}
		return key.split(sep);
	}

	/**
	 * @param key
	 * @param array
	 * @param sep divider
	 */
	public void setMultipleProperty(final String key, final String[] array, final char sep) {
		String val = (array.length == 0) ? "" : array[0];
		for (int i = 1; i < array.length; i++) {
			val += (sep + array[i]);
		}
		setProperty(key, val);
	}
	
	@Override
	public Object setProperty(final String key, final String val) {
		if(val != null) {
			return super.setProperty(key, val);
		} else {
			return null;
		}
	}
}
