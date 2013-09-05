package de.mg.gui;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class MyListModel extends JList {

	private static final long serialVersionUID = 3244830509315607742L;

	private DefaultComboBoxModel model;
	private HashMap<String, File> connector;
	private File[] texmains;
	private int count;

	public MyListModel() {
		this.texmains = new File[0];
		this.model = new DefaultComboBoxModel();
		this.connector = new HashMap<String, File>();
		this.setModel(model);
		this.count = 0;
	}

	public void add(File[] files) {
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getName().toString().replace(".tex", "");
			if (!this.connector.containsKey(name) && !name.equals("")) {
				this.model.addElement(name);
				this.connector.put(name, files[i]);
				this.count++;
			}
		}
	}

	public void remove() {
		for (int i = 0; i < this.getSelectedValues().length; i++) {
			this.connector.remove(this.getSelectedValues()[i].toString());
			this.model.removeElement(this.getSelectedValues()[i]);
			this.count--;
		}
		if (this.getSelectedValue() != null) {
			this.connector.remove(this.getSelectedValue().toString());
			this.model.removeElement(this.getSelectedValue());
			this.count--;
		}
	}

	public File[] getFiles() {
		int i = 0;
		Iterator<String> keys = this.connector.keySet().iterator();
		this.texmains = new File[this.count];

		while (keys.hasNext()) {
			this.texmains[i] = this.connector.get(keys.next());
			i++;
		}
		return this.texmains;
	}

	public int length() {
		return this.count;
	}
}
