/**
 * Project: Lab01
 * File: CompactDisk.java
 * Date: Apr 12, 2017
 * Time: 9:27:39 PM
 */

package a00904649.data.music;

import a00904649.data.MusicMedia;

/**
 * A Compact Disk.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompactDisk extends MusicMedia {
	private int numberOfTracks;

	/**
	 * Default constructor
	 */
	public CompactDisk() {
	}

	/**
	 * Constructor allowing all the attributes to be set.
	 * 
	 * @param title
	 *            - to set the title
	 * @param artist
	 *            - to set the artist
	 * @param numberOfTracks
	 *            - to set the number of tracks
	 */
	public CompactDisk(String title, String artist, int numberOfTracks) {
		super(title, artist);
		setNumberOfTracks(numberOfTracks);
	}

	/**
	 * Get the number of tracks.
	 * 
	 * @return the numberOfTracks
	 */
	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	/**
	 * Set the number of tracks.
	 * 
	 * @param numberOfTracks
	 *            the numberOfTracks to set
	 */
	public void setNumberOfTracks(int numberOfTracks) {
		if (numberOfTracks > 0) {
			this.numberOfTracks = numberOfTracks;
		}
	}

	/**
	 * Plays a CD. For now, it needs only to output a message to the console indicating that the CD is being played.
	 */
	@Override
	public void play() {
		System.out.println("Playing " + '"' + getTitle() + '"' + " CD.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompactDisk [numberOfTracks=" + numberOfTracks + ", toString()= " + super.toString() + "]";
	}

}
