/// AwtControlDemo.java

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Main
{

	/// private
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	/// constructor
	public Main()
	{
		prepareGUI();
	}

	public static void main(String[] args)
	{
		Main awt = new Main();
		awt.showEventDemo();
	}

	// prepareGUI();
	private void prepareGUI()
	{
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);

		statusLabel = new Label();
		statusLabel.setSize(350,100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	// showEventDemo();
	private void showEventDemo()
	{
		headerLabel.setText("Control in the Action : Button");

		Button okButton = new Button("OK");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");

		okButton.addActionListener(new ButtonClickListener());
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);

		mainFrame.setVisible(true);
	}

	// ButtonClickListener();
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if(command.equals("OK"))
			{
				statusLabel.setText("OK Button Was Clicked");
			}
			else if (command.equals("Submit"))
			{
				statusLabel.setText("Submit Button Clicked");
			}
			else
			{
				statusLabel.setText("Cancel Button Clicked");
			}
		}
	}
}