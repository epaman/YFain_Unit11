package swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestSwingWorker {

	JFrame currentFrame = null;
	JPanel framePanel = null;
	static TextArea leftTextArea = null;
	static TextArea rightTextArea = null;
	JButton buttonOK = null;

	private void createFrame() {
		currentFrame = new JFrame("TestSwingWorker");
		currentFrame.setSize(500, 234);
		currentFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		framePanel = new JPanel();
		framePanel.setLayout(new GridBagLayout());

		currentFrame.add(framePanel);

		leftTextArea = new TextArea();
		rightTextArea = new TextArea();

		buttonOK = new JButton("Get the News");
		buttonOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new NewsReader(new File("left.txt"), leftTextArea).execute();
				new NewsReader(new File("right.txt"), rightTextArea).execute();
			}
		});

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;

		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		framePanel.add(leftTextArea, c);

		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		framePanel.add(rightTextArea, c);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		framePanel.add(buttonOK, c);

		currentFrame.setVisible(true);
	}

	public static void main(String[] args) {
		TestSwingWorker tsw = new TestSwingWorker();
		tsw.createFrame();
	}
}
