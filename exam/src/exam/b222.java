/**
 * Project: exam
 * File: b222.java
 * Date: Jul 4, 2017
 * Time: 11:13:08 PM
 */

package exam;

import java.awt.EventQueue;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class b222 {

	public static B22 b22 = new B2().getB22();

	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					B2 frame = new B2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static void main(String[] args) {
		run();
	}

}
