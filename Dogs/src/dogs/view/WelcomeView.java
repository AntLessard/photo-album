package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.IWelcomeController;
import util.image.ImageUtil;

public class WelcomeView extends JFrame implements IView, ActionListener {   // Configurer Eclipse pour ignorer les avertissements sur serial Id
	
	private static final String VIEW_TITLE = "Nos amis les chiens";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";
	
	private static final String BUTTON_TEXT_ADD_DOG = "Inscrire un chien...";
	private static final String ACTION_ADD_DOG = "add";
	private static final String BUTTON_TEXT_SHOW_LIST_DOGS = "Liste de chiens";
	private static final String ACTION_SHOW_LIST_DOGS = "show_list";
	

	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);

	private IWelcomeController controller;	
	
	public WelcomeView(IWelcomeController controller) {
		super(VIEW_TITLE);
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setUpComponents() {
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);

		welcomePanel.setLayout(new BorderLayout());	
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);		
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = ImageUtil.getImageIcon(this, WELCOME_PICTURE);
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);
	}

	private void setUpActionPanel() {
		JPanel actionPanel = new JPanel();
		this.add(actionPanel, BorderLayout.SOUTH);
		
		addButton(actionPanel, BUTTON_TEXT_ADD_DOG, ACTION_ADD_DOG);
		addButton(actionPanel, BUTTON_TEXT_SHOW_LIST_DOGS, ACTION_SHOW_LIST_DOGS);
	}
	
	private void addButton(JPanel actionPanel, String buttonText, String buttonAction) {
		JButton button = new JButton(buttonText);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		actionPanel.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ACTION_ADD_DOG)) {
			this.actionAddDogAsked();
		}
		if(e.getActionCommand().equals(ACTION_SHOW_LIST_DOGS)) {
			this.actionShowListDogsAsked();
		}
	}
	
	private void actionAddDogAsked() {
		this.controller.wantToCreateDog();
	}

	private void actionShowListDogsAsked() {
		this.controller.wantToShowListDogs();
	}
	


}
