package refactoring.chap12;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

@SuppressWarnings("serial")
public class IntegerDisplay extends JFrame implements ActionListener {
	private JPanel contentPane;
	private int value;
	private JLabel lblOctal;
	private JLabel lblDecimal;
	private JLabel lblHexadecimal;
	private JButton btnIncrement;
	private JButton btnDecrement;

	public IntegerDisplay() {
		setTitle("IntegerDisplay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbl8Title = new JLabel("8진수");
		lbl8Title.setForeground(new Color(255, 255, 255));
		lbl8Title.setOpaque(true);
		lbl8Title.setBackground(new Color(70, 130, 180));
		lbl8Title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl8Title);

		lblOctal = new JLabel("0");
		lblOctal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblOctal);

		JLabel lbl10Title = new JLabel("10진수");
		lbl10Title.setForeground(new Color(255, 255, 255));
		lbl10Title.setOpaque(true);
		lbl10Title.setBackground(new Color(70, 130, 180));
		lbl10Title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl10Title);

		lblDecimal = new JLabel("0");
		lblDecimal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDecimal);

		JLabel lbl16Title = new JLabel("16진수");
		lbl16Title.setForeground(new Color(255, 255, 255));
		lbl16Title.setOpaque(true);
		lbl16Title.setBackground(new Color(70, 130, 180));
		lbl16Title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl16Title);

		lblHexadecimal = new JLabel("0");
		lblHexadecimal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHexadecimal);

		btnIncrement = new JButton("+");
		btnIncrement.addActionListener(this);
		btnIncrement.setFont(new Font("굴림", Font.PLAIN, 30));
		contentPane.add(btnIncrement);

		btnDecrement = new JButton("-");
		btnDecrement.addActionListener(this);
		btnDecrement.setFont(new Font("굴림", Font.PLAIN, 30));
		contentPane.add(btnDecrement);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIncrement) {
			setValue(value + 1);
		}
		if (e.getSource() == btnDecrement) {
			setValue(value - 1);
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		lblOctal.setText(Integer.toOctalString(value));
		lblDecimal.setText(Integer.toString(value));
		lblHexadecimal.setText(Integer.toHexString(value));
	}

}
