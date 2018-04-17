package usna.swing;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class SimpleFileFilter extends FileFilter {

	private final String [] extensions;
	private final String description;
    
    public SimpleFileFilter(final String description, final String ... extensions) {
    	this.extensions = new String [extensions.length];
    	for(int i = 0; i < extensions.length; i++) {
    		this.extensions[i] = extensions[i].toLowerCase();
    	}
		this.description = description;
    }

    @Override
	public boolean accept(final File file) {
		return file.isDirectory() || nameHasExtension(file.getName());
	}

    @Override
	public String getDescription() {
		return description;
	}
	
	private boolean nameHasExtension(String fileName) {
		fileName = fileName.toLowerCase();
		for(final String ext: extensions) {
			if(fileName.endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
	
	public String getDefaultExtension() {
		return extensions[0];
	}
}