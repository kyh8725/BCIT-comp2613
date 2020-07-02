/**
 * Project: Lab01
 * File: Lab1.java
 * Date: 2017. 4. 12.
 * Time: ¿ÀÈÄ 7:42:27
 */

package a00904649;

import a00904649.data.music.AudioFile;
import a00904649.data.music.CompactDisk;
import a00904649.data.music.VinylRecordAlbum;

/**
 * This program demonstrates an understanding of the purpose and use object oriented design, including the use of interfaces, abstract parent classes,
 * and inheritance. It also demonstrates the use of code commenting, and the purpose and correct use oftoString(). The Lab1 class tests the validation
 * process, including values that are out of range. Finally, all of the code demonstrates proper coding practices.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab1 {

	/**
	 * The main driver for Lab1. It creates a Lab1
	 * 
	 * @param args
	 *            - not used in this application
	 */
	public static void main(String[] args) {
		Lab1 Lab1 = new Lab1();
		Lab1.test();
	}

	/**
	 * Tests MusicMedia objects.
	 */
	public void test() {
		System.out.println("> create a vinyl record and test weight validation...");
		VinylRecordAlbum VinylRecordAlbum1 = new VinylRecordAlbum("Spin Me", "The Spinners", 12);
		System.out.println(VinylRecordAlbum1);
		System.out.println("> set the weight to 110 (weight is less than the standard weight, so should not change)");
		VinylRecordAlbum1.setWeight(110);
		System.out.println(VinylRecordAlbum1);
		System.out.println("> set the weight to 180 (weight is greater than the standard weight, so should change)");
		VinylRecordAlbum1.setWeight(180);
		System.out.println(VinylRecordAlbum1);
		VinylRecordAlbum1.play();
		System.out.println("> create and play a compact disk");
		CompactDisk CompactDisk1 = new CompactDisk("Turnabout Intruder", "Jim Kirk", 9);
		System.out.println(CompactDisk1);
		CompactDisk1.play();
		System.out.println("> create, play, and delete an audio file");
		AudioFile AudioFile1 = new AudioFile("Buzz-Click", "Cyber Punks", "Wish I Bought Vinyl.m4a", 3.46);
		System.out.println(AudioFile1);
		AudioFile1.save("C:/My Music/iTunes", "Wish I Bought Vinyl.m4a");
		AudioFile1.play();
		AudioFile1.delete("C:/My Music/iTunes", "Wish I Bought Vinyl.m4a");
	}

}
