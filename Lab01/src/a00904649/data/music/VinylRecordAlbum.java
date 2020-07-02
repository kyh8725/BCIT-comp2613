/**
 * Project: Lab01
 * File: VinylRecordAlbum.java
 * Date: Apr 12, 2017
 * Time: 9:40:36 PM
 */

package a00904649.data.music;

import a00904649.data.MusicMedia;

/**
 * A vinyl record album.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class VinylRecordAlbum extends MusicMedia {
	public static final int STANDARD_WEIGHT = 120;
	private int numberOfTracks;
	private int weight;

	/**
	 * Default constructor
	 */
	public VinylRecordAlbum() {
	}

	/**
	 * Constructor allowing all the attributes to be set, except for the weight. The weight is set to STANDARD_WEIGHT.
	 * 
	 * @param title
	 *            - the title to set
	 * @param artist
	 *            - the artist to set
	 * @param numberOfTracks
	 *            - the number of tracks to set
	 */
	public VinylRecordAlbum(String title, String artist, int numberOfTracks) {
		super(title, artist);
		setNumberOfTracks(numberOfTracks);
		weight = STANDARD_WEIGHT;
	}

	/**
	 * Constructor allowing all the attributes to be set.
	 * 
	 * @param title
	 *            - the title to set
	 * @param artist
	 *            - the artist to set
	 * @param numberOfTracks
	 *            - the number of tracks to set
	 * @param weight
	 *            - the weight to set
	 */
	public VinylRecordAlbum(String title, String artist, int numberOfTracks, int weight) {
		super(title, artist);
		setNumberOfTracks(numberOfTracks);
		setWeight(weight);
	}

	/**
	 * Get the number of tracks
	 * 
	 * @return the numberOfTracks as an int
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
	 * Get the weight.
	 * 
	 * @return the weight as an int
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight. Only weight greater than STANDARD_WEIGHT are allowed.
	 * 
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		if (weight > STANDARD_WEIGHT) {
			this.weight = weight;
		}
	}

	/**
	 * Plays a vinyl record album. For now, it needs only to output a message to the console indicating that a record is being played.
	 */
	@Override
	public void play() {
		System.out.println("Playing " + '"' + getTitle() + '"' + " record.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VinylRecordAlbum [numberOfTracks=" + numberOfTracks + ", weight=" + weight + ", toString()= " + super.toString() + "]";
	}

}
