package de.mg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class OptionWindow extends JDialog {

	private static final long serialVersionUID = -2935975642123056038L;
	private JRadioButton jRadioButton1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JButton jButton1;
	private JLabel jLabel3;
	private JTextField jTextField2;
	private JRadioButton jRadioButton3;
	private JButton jButton3;
	private JButton jButton2;
	private JLabel jLabel1;
	private JRadioButton jRadioButton2;
	private ButtonGroup buttonGroup1;
	private GUIController gui;

	public OptionWindow(GUIController gui) {
		super(gui.getMain(), true);
		this.gui = gui;
		this.initGUI();
	}

	private void initGUI() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				gui.cancel();
			}
		});
		this.setTitle("Optionen");

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				OptionWindow.class.getResource("images/icon.png")));

		{
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
			thisLayout.rowHeights = new int[] { 7, 7, 20, 7, 20, 7 };
			thisLayout.columnWeights = new double[] { 0.1, 0.0, 0.1, 0.1, 0.1,
					0.1 };
			thisLayout.columnWidths = new int[] { 7, -1, 7, 7, 20, 20 };
			getContentPane().setLayout(thisLayout);
			{
				getContentPane().add(
						getJLabel1(),
						new GridBagConstraints(0, 0, 3, 3, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 0, 0));
			}
			{
				jRadioButton1 = new JRadioButton();
				getContentPane().add(
						jRadioButton1,
						new GridBagConstraints(3, 0, 2, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 0, 0));
				jRadioButton1.setText("PDF-LaTeX");
				jRadioButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						setMode(0);
					}
				});
			}
			{
				jRadioButton2 = new JRadioButton();
				getContentPane().add(
						jRadioButton2,
						new GridBagConstraints(3, 1, 2, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 0, 0));
				getContentPane().add(
						getJTextField1(),
						new GridBagConstraints(2, 3, 3, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 0, 0));
				getContentPane().add(
						getJLabel2(),
						new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.NONE,
								new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(
						getJButton1(),
						new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 0, 0));
				getContentPane().add(
						getJButton2(),
						new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(8, 5, 8, 5), 0, 0));
				getContentPane().add(
						getJButton3(),
						new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(8, 5, 8, 5), 0, 0));
				getContentPane().add(
						getJRadioButton3(),
						new GridBagConstraints(3, 2, 2, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.BOTH,
								new Insets(5, 5, 5, 5), 0, 0));
				getContentPane().add(
						getJLabel3(),
						new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.NONE,
								new Insets(0, 0, 0, 0), 0, 0));
				getContentPane().add(getJTextField2(), new GridBagConstraints(2, 4, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
				jRadioButton2.setText("PDF-LaTeX + BibTeX");
				jRadioButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						setMode(1);
					}
				});

				this.getButtonGroup1();
			}

		}
		{
			this.setSize(411, 240);
		}

	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
			buttonGroup1.add(this.jRadioButton1);
			buttonGroup1.add(this.jRadioButton2);
			buttonGroup1.add(this.jRadioButton3);

		}
		return buttonGroup1;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("<html><body>Art des Kompiliervorgangs hier auswählen</body></html>");
		}
		return jLabel1;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("");
		}
		return jTextField1;
	}

	public String getjTextField1() {
		return this.jTextField1.getText();
	}

	public void setjTextField1(String jTextField1) {
		this.jTextField1.setText(jTextField1);
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("<html><body>Konfigurationsdatei auswählen</body></html>");
		}
		return jLabel2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("...");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.openCfg();
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Abbrechen");
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.cancel();
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Übernehmen");
			jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.save();
				}
			});
		}
		return jButton3;
	}

	public int getMode() {
		if (this.jRadioButton1.isSelected()) {
			return 0;
		} else {
			if (this.jRadioButton2.isSelected()) {
				return 1;
			} else {
				return 2;
			}
		}
	}

	public void setMode(int mode) {
		switch (mode) {
		case 1:
			this.jRadioButton2.setSelected(true);
			this.jTextField2.setVisible(false);
			this.jLabel3.setVisible(false);
			break;
		case 2:
			this.jRadioButton3.setSelected(true);
			this.jTextField2.setVisible(true);
			this.jLabel3.setVisible(true);
			break;
		default:
			this.jRadioButton1.setSelected(true);
			this.jTextField2.setVisible(false);
			this.jLabel3.setVisible(false);
			break;

		}
	}

	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setText("PDF-LaTeX + BibTeX + MakeIndex");
			jRadioButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					setMode(2);
				}
			});
		}
		return jRadioButton3;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("MakeIndex Parameter");
			jLabel3.setVisible(false);
		}
		return jLabel3;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("");
			jTextField2.setVisible(false);
		}
		return jTextField2;
	}

	public String getjTextField2() {
		return jTextField2.getText();
	}

	public void setjTextField2(String jTextField2) {
		this.jTextField2.setText(jTextField2);
	}

}
