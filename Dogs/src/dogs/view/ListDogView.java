package dogs.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dogs.controller.IDogController;
import dogs.dto.DogDTOForList;

public class ListDogView extends JDialog implements IView, ActionListener{

	private static final String ID_LABEL_TITLE = "ID";
	private static final String NAME_LABEL_TITLE = "Nom";
	private static final String BREED_LABEL_TITLE = "Race";
	
	private IDogController controller;
	private ArrayList<DogDTOForList> listOfDogs;
	
	public ListDogView(IDogController controller, ArrayList<DogDTOForList> dogDTOForList) {
		super();
		
		this.controller = controller;
		this.listOfDogs = dogDTOForList;
		
		this.setUpComponents();
		this.initialize();
	}

	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		this.pack();
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private void setUpComponents() {
		this.setUpListDogsPanel();
	}
	
	private void setUpListDogsPanel() {
		this.setUpTable();
	}

	private void setUpTable() {
		JPanel displayDataPanel = new JPanel();
		displayDataPanel.setLayout(new GridLayout(0,3));
		
		JLabel idLabelTitle = new JLabel(ID_LABEL_TITLE);
        JLabel nameLabelTitle = new JLabel(NAME_LABEL_TITLE);
        JLabel breedLabelTitle = new JLabel(BREED_LABEL_TITLE);
        displayDataPanel.add(idLabelTitle);
        displayDataPanel.add(nameLabelTitle);
        displayDataPanel.add(breedLabelTitle);
		 for (DogDTOForList dog : listOfDogs) {
	         int idNumberDog = dog.id;
	         String idNumberText = Integer.toString(idNumberDog);
	         JLabel idLabel = new JLabel(idNumberText);
	         JLabel nameLabel = new JLabel(dog.name);
	         JLabel breedLabel = new JLabel(dog.breed);
	         displayDataPanel.add(idLabel);
	         displayDataPanel.add(nameLabel);
	         displayDataPanel.add(breedLabel);
	        }
		 this.add(displayDataPanel);
	}
	
	/*private void setUpTable() {
		JPanel displayDataPanel = new JPanel();
		displayDataPanel.setBorder(new EmptyBorder(20,20,20,20));
		this.add(displayDataPanel);
		
		String[] columnNames = {
				ID_LABEL_TITLE, 
				NAME_LABEL_TITLE,
				BREED_LABEL_TITLE
		};
		Object[][] data = new Object[this.listOfDogs.size()][3];
		int rowNb = 0;
		for(DogDTOForList dog:this.listOfDogs) {
			data[rowNb][0] = String.valueOf(dog.id);
			data[rowNb][1] = dog.name;
			data[rowNb][2] = dog.breed;
			rowNb++;
		}
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
