package de.mg.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
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
public class MainWindow extends JFrame {

	private GUIController gui;

	private JMenuBar jMenuBar1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton jButton5;
	private JButton jButton4;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem3;
	private JMenu jMenu2;
	private JButton jButton3;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField jTextField4;

	private JTextField jTextField3;
	private JProgressBar jProgressBar1;
	private JMenuItem jMenuItem2;
	private JSeparator jSeparator1;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private JButton jButton6;
	private JMenuItem jMenuItem5;
	private JMenu jMenu3;
	private MyListModel jList1;
	private JScrollPane jScrollPane1;
	private JButton jButton7;

	private static final long serialVersionUID = 7589195980936710778L;

	public MainWindow(GUIController gui, MyListModel list) {
		this.gui = gui;
		this.jList1 = list;
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();

		}

		this.initGUI();
	}

	private void initGUI() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				gui.shutdown();
			}
		});
		this.setTitle("LaTeX-Compiler");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				MainWindow.class.getResource("images/icon.png")));

		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1 };
		thisLayout.rowHeights = new int[] { 7, 7, 7, 7, 7 };
		thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1 };
		thisLayout.columnWidths = new int[] { 7, 7, 7, 20, 7 };
		getContentPane().setLayout(thisLayout);
		this.setFocusable(false);
		this.setResizable(false);
		{
			jLabel2 = new JLabel();
			getContentPane().add(
					jLabel2,
					new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			jLabel2.setText("<html><body>Zu kompilierende<br/> LaTeX-Dateien</body></html>");

		}
		{
			jLabel3 = new JLabel();
			getContentPane().add(
					jLabel3,
					new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			jLabel3.setText("PDF-Ausgabe");

		}
		{
			jLabel4 = new JLabel();
			getContentPane().add(
					jLabel4,
					new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			jLabel4.setText("PDF-Reader");

		}
		{
			jProgressBar1 = new JProgressBar();
			jProgressBar1.setVisible(false);
			jProgressBar1.setStringPainted(true);
			jProgressBar1.setEnabled(true);
			jProgressBar1.setMaximum(100);
			jProgressBar1.setMinimum(0);
			jProgressBar1.setValue(1);
			getContentPane().add(
					jProgressBar1,
					new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(8, 8, 8, 8), 0, 0));
		}
		{
			jTextField3 = new JTextField();
			getContentPane().add(
					jTextField3,
					new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));

		}
		{
			jTextField4 = new JTextField();
			getContentPane().add(
					jTextField4,
					new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));

		}
		{
			jButton1 = new JButton();
			getContentPane().add(
					jButton1,
					new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(8, 8, 8, 8), 0, 0));
			jButton1.setText("Kompilieren");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.compile();
				}
			});
		}
		{
			jButton2 = new JButton();
			getContentPane().add(
					jButton2,
					new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(8, 8, 8, 8), 0, 0));
			jButton2.setText("Anzeigen");
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.display();
				}
			});
		}
		{
			jButton3 = new JButton();
			getContentPane().add(
					jButton3,
					new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(8, 8, 8, 8), 0, 0));
			jButton3.setText("Beenden");
			jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.shutdown();
				}
			});
		}
		{
			jButton4 = new JButton();
			getContentPane().add(
					jButton4,
					new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			jButton4.setIcon(new ImageIcon(MainWindow.class
					.getResource("images/add.png")));
			jButton4.setMargin(new Insets(0, 0, 0, 0));
			jButton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.open();
				}
			});
		}
		{
			jButton5 = new JButton();
			getContentPane().add(
					jButton5,
					new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));

			jButton5.setIcon(new ImageIcon(MainWindow.class
					.getResource("images/remove.png")));
			jButton5.setMargin(new Insets(0, 0, 0, 0));
			jButton5.setEnabled(false);
			jButton5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.remove();
				}
			});
		}
		{
			jButton7 = new JButton();
			getContentPane().add(
					jButton7,
					new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			jButton7.setText("...");
			jButton7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.openExecutable();
				}
			});
		}
		{
			jScrollPane1 = new JScrollPane();
			getContentPane().add(
					jScrollPane1,
					new GridBagConstraints(1, 0, 3, 2, 1.0, 1.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			{

				jScrollPane1.setViewportView(jList1);
			}
		}
		{
			jButton6 = new JButton();
			getContentPane().add(
					jButton6,
					new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(5, 5, 5, 5), 0, 0));
			jButton6.setText("...");
			jButton6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					gui.openDirectory();
				}
			});
		}
		{
			jMenuBar1 = new JMenuBar();
			setJMenuBar(jMenuBar1);
			{
				jMenu1 = new JMenu();
				jMenuBar1.add(jMenu1);
				jMenu1.setText("Menü");
				{
					jMenuItem1 = new JMenuItem();
					jMenu1.add(jMenuItem1);
					jMenuItem1.setText("Kompilieren");
					jMenuItem1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gui.compile();
						}
					});
				}
				{
					jMenuItem4 = new JMenuItem();
					jMenu1.add(jMenuItem4);
					jMenuItem4.setText("Anzeigen");
					jMenuItem4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gui.display();
						}
					});
				}
				{
					jSeparator1 = new JSeparator();
					jMenu1.add(jSeparator1);
				}
				{
					jMenuItem2 = new JMenuItem();
					jMenu1.add(jMenuItem2);
					jMenuItem2.setText("Beenden");
					jMenuItem2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gui.shutdown();
						}
					});
				}

			}
			{
				jMenu3 = new JMenu();
				jMenuBar1.add(jMenu3);
				jMenu3.setText("Optionen");
				{
					jMenuItem5 = new JMenuItem();
					jMenu3.add(jMenuItem5);
					jMenuItem5.setText("Konfiguration");
					jMenuItem5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							gui.options();
						}
					});
				}
			}
			{
				jMenu2 = new JMenu();
				jMenuBar1.add(jMenu2);
				jMenu2.setText("Info");
				{
					jMenuItem3 = new JMenuItem();
					jMenu2.add(jMenuItem3);
					jMenuItem3.setText("Über");
					jMenuItem3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							displayInfo();
						}
					});
				}
			}

			this.setSize(519, 278);
		}

	}

	public void setjTextField4(String jTextField4) {
		this.jTextField4.setText(jTextField4);
	}

	public void setProgress(int percentage) {
		this.jProgressBar1.setValue(percentage);
	}

	public void setProgressBarVisible(boolean visible) {
		this.jProgressBar1.setVisible(visible);
	}

	public String getjTextField4() {
		return jTextField4.getText();
	}

	public String getjTextField3() {
		return jTextField3.getText();
	}

	public void setjTextField3(String jTextField3) {
		this.jTextField3.setText(jTextField3);
	}

	public void displayError(String message, int level) {
		switch (level) {
		case 0:
			JOptionPane.showMessageDialog(new JDialog(), message, "Fehler",
					JOptionPane.ERROR_MESSAGE);
			break;
		case 1:
			JOptionPane.showMessageDialog(new JDialog(), message, "Warnung",
					JOptionPane.WARNING_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(new JDialog(), message,
					"Information", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

	}

	public void displayInfo() {
		InfoWindow info = new InfoWindow(this);
		info.setVisible(true);
	}

	public void removeButton(boolean enabled) {
		this.jButton5.setEnabled(enabled);
	}
}
