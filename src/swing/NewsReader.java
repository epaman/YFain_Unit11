package swing;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, Object> {
	File newsFile = null;
	TextArea textAreaToFill = null;

	NewsReader(File file, TextArea textArea) {
		if (file.exists()) {
			newsFile = file;
			textAreaToFill = textArea;
		} else {
			JOptionPane.showMessageDialog(null, "File ".concat(file.getName()).concat(" not found"));
		}
	}

	protected String doInBackground() throws Exception {
		String fileContent = null;
		try (FileReader fr = new FileReader(newsFile);
				BufferedReader br = new BufferedReader(fr)) {
			
			fileContent = new String();
			String currentLine = new String();

			while ((currentLine = br.readLine()) != null) {
				fileContent = fileContent.concat(currentLine + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}

	protected void done() {
		try {
			textAreaToFill.setText(get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
