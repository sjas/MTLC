package de.mg.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoWindow extends JDialog {
	private static final long serialVersionUID = -3300096997659331059L;

	private JLabel info_ = null;

	/**
	 * Methode zum Initialisieren des <code>Info</code> Screens
	 * 
	 */
	public InfoWindow(JFrame main) {
		super(main, true);
		initialize();
	}

	/**
	 * Methode zum Initialiseren der Ansicht.
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(250, 150));

		this.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this
				.getSize().height) / 2);
		this.add(getInfo());
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});

		this.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					setVisible(false);
					dispose();
				}
			}
		});
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (e.getClickCount() >= 2) {
					setVisible(false);
					dispose();
				}
			}
		});
	}

	/**
	 * Initialiserung eines <code>JLabel</code> zur Aufnahme des Infobanners.
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getInfo() {
		if (info_ == null) {
			info_ = new JLabel(new ImageIcon(InfoWindow.class
					.getResource("images/infoscreen.jpg")));
			info_.setBounds(new Rectangle(0, 0, 400, 250));
			info_.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						setVisible(false);
						dispose();
					}
				}
			});
		}
		return info_;
	}

}
