package dogs.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dogs.controller.DogController;
import dogs.controller.IDogController;
import dogs.dto.DogDTOForCreate;

public class CreateDogView extends JDialog implements IView, ActionListener {

	private static final String VIEW_TITLE = "Inscrire un chien";
	private static final String BUTTON_TEXT_REGISTER_DOG = "Enregistrer";
	private static final String ACTION_REGISTER_DOG = "Register";
	private static final String NAME_TEXT_FIELD = "Name";
	private static final String BREED_TEXT_FIELD = "Breed";
	private static final Object THANK_YOU_MESSAGE = "Merci";
	private static final String THANK_YOU_TITLE_DIALOG = "Le chien a ete enregistrer";
	
	
	
	private IDogController controller;
	
	private JTextField nameField = new JTextField(30);
	private JTextField breedField = new JTextField(30);
	
	private String dogName;
	private String dogBreed;

	public CreateDogView(DogController dogController) {
		super();
		
		this.controller = dogController;
		
		this.setUpComponents();
		this.initialize();
		this.pack();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}

	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	private void setUpComponents() {
		this.setUpTextFieldPanel();
		this.setUpActionPanel();
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
		this.addButton(actionPanel, BUTTON_TEXT_REGISTER_DOG, ACTION_REGISTER_DOG);
	}
	
	private void setUpTextFieldPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		panel.add(new JLabel(NAME_TEXT_FIELD));
		panel.add(this.nameField);
		panel.add(new JLabel(BREED_TEXT_FIELD));
		panel.add(this.breedField);
		this.add(panel);
	}

	private void addButton(JPanel actionPanel, String buttonTextRegisterDog, String actionRegisterDog) {
		JButton button = new JButton(buttonTextRegisterDog);
		button.setActionCommand(actionRegisterDog);
		button.addActionListener(this);
		actionPanel.add(button);
	}
	
	private void createDog() {
		DogDTOForCreate dogToCreate = new DogDTOForCreate(this.dogName, this.dogBreed);
		this.controller.add(dogToCreate);
		JOptionPane.showMessageDialog(this, THANK_YOU_MESSAGE, THANK_YOU_TITLE_DIALOG, HIDE_ON_CLOSE);
		this.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ACTION_REGISTER_DOG)) {
			this.dogName = nameField.getText();
			this.dogBreed = breedField.getText();
			this.createDog();
		}
	}
	
	
}
