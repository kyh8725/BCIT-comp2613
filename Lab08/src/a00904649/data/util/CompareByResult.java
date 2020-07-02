/**
 * Project: Lab08
 * File: CompareByResult.java
 * Date: Jun 3, 2017
 * Time: 2:10:12 AM
 */

package a00904649.data.util;

import java.util.Comparator;

import a00904649.data.Runners;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CompareByResult implements Comparator<Runners> {

	@Override
	public int compare(Runners runner1, Runners runner2) {
		return Double.compare(runner1.getResult(), runner2.getResult());
	}

}
