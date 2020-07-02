/**
 * Project: Lab01
 * File: MusicMedia.java
 * Date: Apr 12, 2017
 * Time: 8:05:40 PM
 */

package a00904649.data;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public abstract class MusicMedia {
	private String title;
	private String artist;

	/**
	 * default constructor
	 */
	public MusicMedia() {
	}

	/**
	 * @param title
	 *            - used to set the title field
	 * @param artist
	 *            - used to set the artist field
	 */
	public MusicMedia(String title, String artist) {
		setTitle(title);
		setArtist(artist);
	}

	/**
	 * abstract method to be implemented by sub classes. Used to play a music media type.
	 */
	public abstract void play();

	/**
	 * @return the title as a String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
		}
	}

	/**
	 * @return the artist as a String
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist
	 *            the artist to set
	 */
	public void setArtist(String artist) {
		if (artist != null && !artist.isEmpty()) {
			this.artist = artist;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "MusicMedia [title=" + title + ", artist=" + artist + "]";
	}

}
