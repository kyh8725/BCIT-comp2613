/**
 * Project: Lab01
 * File: FileManager.java
 * Date: Apr 12, 2017
 * Time: 8:41:55 PM
 */

package a00904649.io;

/**
 * Manages files.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public interface FileManager {

	/**
	 * Save a file.
	 * 
	 * @param path
	 *            - the directory to save to
	 * @param fileName
	 *            - the name of the file being saved
	 */
	public void save(String path, String fileName);

	/**
	 * Delete a file
	 * 
	 * @param path
	 *            - the directory where the file is located
	 * @param fileName
	 *            - the name of the file to be deleted
	 */
	public void delete(String path, String fileName);
}