/**
 * Project: Lab01
 * File: AudioFile.java
 * Date: Apr 12, 2017
 * Time: 8:53:01 PM
 */

package a00904649.data.music;

import a00904649.data.MusicMedia;
import a00904649.io.FileManager;

/**
 * An Audio File.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class AudioFile extends MusicMedia implements FileManager {

	private String fileName;
	private double fileSize;

	/**
	 * Default constructor
	 */
	public AudioFile() {
	}

	/**
	 * Constructor allowing all the attributes to be set.
	 * 
	 * @param title
	 *            - the title to set
	 * @param artist
	 *            - the artist to set
	 * @param fileName
	 *            - the filename to set
	 * @param fileSize
	 *            - the size of the file
	 */
	public AudioFile(String title, String artist, String fileName, double fileSize) {
		super(title, artist);
		setFileName(fileName);
		setFileSize(fileSize);
	}

	/**
	 * Get the filename.
	 * 
	 * @return the fileName as a String
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Set the filename.
	 * 
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		if (fileName != null && !fileName.isEmpty()) {
			this.fileName = fileName;
		}
	}

	/**
	 * Get the file size.
	 * 
	 * @return the fileSize as a double
	 */
	public double getFileSize() {
		return fileSize;
	}

	/**
	 * Set the file size.
	 * 
	 * @param fileSize
	 *            the fileSize to set
	 */
	public void setFileSize(double fileSize) {
		if (fileSize > 0) {
			this.fileSize = fileSize;
		}
	}

	/**
	 * Plays an audio file. For now, it needs only to output a message to the console indicating that the audio file is being played.
	 */
	@Override
	public void play() {
		System.out.println("Playing " + '"' + getFileName() + '"' + ".");
	}

	/**
	 * Saves a file to the hard disk. For now, it needs only to output a message to the console indicating that the audio file is being saved.
	 * 
	 * @param path
	 *            - the directory to save to
	 * @param fileName
	 *            - the name of the file being saved
	 */
	@Override
	public void save(String path, String fileName) {
		System.out.println("Saving " + '"' + getFileName() + '"' + " to " + '"' + path + '"' + " folder.");
	}

	/**
	 * Deletes a file from the hard disk. For now, it needs only to output a message to the console indicating that the audio file is being deleted.
	 * 
	 * @param path
	 *            - the directory where the file is located
	 * @param fileName
	 *            - the name of the file to be deleted
	 */
	@Override
	public void delete(String path, String fileName) {
		System.out.println("Deleting " + '"' + getFileName() + '"' + " from " + '"' + path + '"' + " folder.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AudioFile [fileName=" + fileName + ", fileSize=" + fileSize + ", toString()= " + super.toString() + "]";
	}

}
