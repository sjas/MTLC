package de.mg.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.mg.acquaintance.DOTI;
import de.mg.main.app.CompilerControllerI;
import de.mg.main.app.GUIControllerI;

public class GUIController implements GUIControllerI {
	private CompilerControllerI cc;
	private MainWindow mw;
	private DOTI dot;
	private MyListModel list;
	private OptionWindow ow;

	public GUIController(CompilerControllerI cc) {
		this.cc = cc;
		this.cc.register(this);
		this.list = new MyListModel();
		this.mw = new MainWindow(this, this.list);
		this.initialize();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.mw.setLocation((d.width - this.mw.getSize().width) / 2,
				(d.height - this.mw.getSize().height) / 2);
		this.mw.setVisible(true);
	}

	@Override
	public void percentage(int percentage) {
		this.mw.setProgressBarVisible(true);
		this.mw.setProgress(percentage);
		if (percentage == 100) {
			this.mw.setProgressBarVisible(false);
		}

	}

	private void initialize() {
		this.dot = this.cc.getCurrent();
		if (this.dot != null) {
			this.list.add(this.dot.getMains());
			if (this.list.length() > 0) {
				this.mw.removeButton(true);
			}
			if (!this.dot.getOutdir().toString().equals("")) {
				this.mw.setjTextField3(this.dot.getOutdir().toString());
			} else {
				if (this.dot.getMains() != null
						&& this.dot.getMains()[0].getParent() != null) {
					this.mw.setjTextField3(this.dot.getMains()[0].getParent()
							.toString());
				}
			}
			this.mw.setjTextField4(this.dot.getPdfdir().toString());
		}
	}

	public void compile() {
		this.initializeDOT();
		this.cc.initialize(dot);
		Thread t1 = new Thread(this.cc);
		t1.start();

	}

	private void initializeDOT() {
		if (this.dot != null) {
			if (!this.dot.getMains().equals(this.list.getFiles())) {
				this.dot.setTexMains(this.list.getFiles());
			}
			if (!this.dot.getOutdir().toString().equals(
					this.mw.getjTextField3().trim())) {
				this.dot.setOutdir(new File(this.mw.getjTextField3().trim()));
			}
			if (!this.dot.getPdfdir().toString().equals(
					this.mw.getjTextField4().trim())) {
				this.dot.setPdfdir(new File(this.mw.getjTextField4().trim()));
			}
		}
	}

	public void display() {
		this.initializeDOT();
		this.cc.initialize(dot);
		this.cc.show();
	}

	public void shutdown() {
		this.mw.setVisible(false);
		this.cc.kill();

	}

	@Override
	public void showError(String message, int level) {
		this.mw.displayError(message, level);
		if (level == 0) {
			this.shutdown();
		}
	}

	public void open() {
		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("tex file", "tex");
		fileopen.addChoosableFileFilter(filter);

		if (this.list.getFiles().length != 0) {
			fileopen.setSelectedFiles(this.list.getFiles());
		}

		fileopen.setMultiSelectionEnabled(true);
		int ret = fileopen.showDialog(this.mw, "Öffnen");

		if (ret == JFileChooser.APPROVE_OPTION) {
			File[] files = fileopen.getSelectedFiles();
			this.list.add(files);
			this.mw.removeButton(true);
			this.mw.setjTextField3(files[0].getParent().toString());
		}
	}

	public void openCfg() {
		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("cfg file", "cfg");
		fileopen.addChoosableFileFilter(filter);

		if (!this.cc.getConfig().toString().equals("")) {
			fileopen.setSelectedFile(this.cc.getConfig());
		}

		fileopen.setMultiSelectionEnabled(true);
		int ret = fileopen.showDialog(this.mw, "Öffnen");

		if (ret == JFileChooser.APPROVE_OPTION) {
			File[] files = fileopen.getSelectedFiles();
			this.list.add(files);
			this.mw.setjTextField3(files[0].getParent().toString());
		}
	}

	public void openExecutable() {
		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("exe files", "exe");
		if (!this.mw.getjTextField4().trim().equals("")) {
			fileopen.setSelectedFile(new File(this.mw.getjTextField4().trim()));
		}
		fileopen.addChoosableFileFilter(filter);
		int ret = fileopen.showDialog(this.mw, "Öffnen");

		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			this.mw.setjTextField4(file.toString());
		}
	}

	public void openDirectory() {

		JFileChooser fileopen = new JFileChooser();
		fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (!this.mw.getjTextField3().trim().equals("")) {
			fileopen.setSelectedFile(new File(this.mw.getjTextField3().trim()));
		}
		int ret = fileopen.showDialog(this.mw, "Öffnen");

		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			this.mw.setjTextField3(file.toString());
		}
	}

	public void remove() {
		this.list.remove();
		if (this.list.length() == 0) {
			this.mw.removeButton(false);
		}
	}

	public void options() {
		this.ow = new OptionWindow(this);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.ow.setLocation((d.width - this.ow.getSize().width) / 2,
				(d.height - this.ow.getSize().height) / 2);
		this.ow.setjTextField1(this.cc.getConfig().toString());
		this.ow.setMode(this.cc.getCurrent().getMode());
		this.ow.setjTextField2(this.cc.getCurrent().getMakeIndex());
		this.ow.setVisible(true);
	}

	public void cancel() {
		this.ow.setVisible(false);
		this.ow.dispose();
	}

	public JFrame getMain() {
		return this.mw;
	}

	public void save() {
		this.cc.setConfig(new File(this.ow.getjTextField1().trim()));
		this.initialize();
		this.dot.setMode(this.ow.getMode());
		this.dot.setMakeIndex(this.ow.getjTextField2().trim());
		this.ow.setVisible(false);
		this.ow.dispose();
	}

}
