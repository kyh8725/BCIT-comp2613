/**
 * Project: exam
 * File: B2.java
 * Date: Jul 4, 2017
 * Time: 10:09:08 PM
 */

package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class B2 extends JFrame {

	private JPanel contentPane;
	private JButton btnMoveMe;

	public B2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnX = new JButton("x1");
		btnX.setBounds(12, 10, 56, 23);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				btnMoveMe.setBounds(btnMoveMe.getX() + 1, btnMoveMe.getY(), 100, 30);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnX);

		JButton btnX10 = new JButton("x10");
		btnX10.setBounds(74, 10, 56, 23);
		btnX10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMoveMe.setBounds(btnMoveMe.getX() + 10, btnMoveMe.getY(), 100, 30);
			}
		});
		contentPane.add(btnX10);

		JButton btnY = new JButton("y1");
		btnY.setBounds(139, 10, 56, 23);
		btnY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMoveMe.setBounds(btnMoveMe.getX(), btnMoveMe.getY() + 1, 100, 30);
			}
		});
		contentPane.add(btnY);

		JButton btnY_1 = new JButton("y10");
		btnY_1.setBounds(207, 10, 56, 23);
		btnY_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnMoveMe.setBounds(btnMoveMe.getX(), btnMoveMe.getY() + 10, 100, 30);
			}
		});
		contentPane.add(btnY_1);
		btnMoveMe = new JButton("Move me!");
		contentPane.add(btnMoveMe);
	}

	public B2(B22 b22) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnX = new JButton("x1");
		btnX.setBounds(12, 10, 56, 23);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				btnMoveMe.setBounds(btnMoveMe.getX() + 1, btnMoveMe.getY(), 100, 30);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnX);

		JButton btnX10 = new JButton("x10");
		btnX10.setBounds(74, 10, 56, 23);
		btnX10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMoveMe.setBounds(btnMoveMe.getX() + 10, btnMoveMe.getY(), 100, 30);
			}
		});
		contentPane.add(btnX10);

		JButton btnY = new JButton("y1");
		btnY.setBounds(139, 10, 56, 23);
		btnY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMoveMe.setBounds(btnMoveMe.getX(), btnMoveMe.getY() + 1, 100, 30);
			}
		});
		contentPane.add(btnY);

		JButton btnY_1 = new JButton("y10");
		btnY_1.setBounds(207, 10, 56, 23);
		btnY_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnMoveMe.setBounds(btnMoveMe.getX(), btnMoveMe.getY() + 10, 100, 30);
			}
		});
		contentPane.add(btnY_1);
		btnMoveMe = new JButton("Move me!");
		setMoveBound(b22);
		contentPane.add(btnMoveMe);
	}

	public B22 getB22() {
		B22 b22 = new B22(btnMoveMe.getX(), btnMoveMe.getY());
		return b22;
	}

	public void setMoveBound(B22 b22) {
		btnMoveMe.setBounds(b22.getXxx(), b22.getYyy(), 100, 30);
	}

}