package hw_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 
 * @author aaron stahley
 * @version 1.0 jan 26, 2017.
 *
 */

public class MainPanel extends JPanel{
	
	private JComboBox optionCB; 
	
	private JLabel hexLabel;
	private JLabel binaryLabel;
	private JLabel decimalLabel; 
	
	private JTextArea hexBinaryTA; 
	private JTextArea decimalTA;
	
	private JButton evalButton;
	private JButton clearButton;
	
	/**
	 * 
	 * Contains all the GUI components
	 * 
	 */
	public MainPanel(){
		
		setLayout(null);
		
		String[] options = {"Binary to Decimal","Hex to Decimal"};
		
		// Lets you chose which evaluation you want to choose. 
		this.optionCB = new JComboBox(options);
		this.optionCB.setVisible(true);
		this.optionCB.setBounds(145,20,300,30);
		this.optionCB.setSelectedIndex(0);
		add(optionCB); 
		
		this.binaryLabel = new JLabel("Binary String: ");
		this.binaryLabel.setVisible(true);
		this.binaryLabel.setBounds(45, 101, 100, 13);
		add(binaryLabel);
		
		this.hexLabel = new JLabel("Hex String: ");
		this.hexLabel.setVisible(false);
		this.hexLabel.setBounds(58, 101, 80, 13);
		add(hexLabel);
		
		this.decimalLabel = new JLabel("Decimal String: ");
		this.decimalLabel.setVisible(true);
		this.decimalLabel.setBounds(32 , 138, 100, 13);
		add(decimalLabel);
		
		this.evalButton = new JButton("Evaluate");
		this.evalButton.setVisible(true);
		this.evalButton.setEnabled(false);
		this.evalButton.setBounds(200,175,80,20);
		add(evalButton);
		
		this.clearButton = new JButton("Clear");
		this.clearButton.setVisible(true);
		this.clearButton.setEnabled(true);
		this.clearButton.setBounds(300,175,80,20);
		add(clearButton); 
		
		this.hexBinaryTA = new JTextArea();
		this.hexBinaryTA.setBounds(132,98,330,21);
		this.hexBinaryTA.setAutoscrolls(false);
		add(hexBinaryTA);
		
		this.decimalTA = new JTextArea();
		this.decimalTA.setBounds(132,135,330,21); 
		this.decimalTA.setAutoscrolls(false);
		this.decimalTA.setEnabled(false);
		add(decimalTA);		
	
		
		hexBinaryTA.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				String str = hexBinaryTA.getText();
				int strLength = str.length();
				
				// Finds and validates the last value that the user enters.
				validate(str.charAt(strLength - 1));
		
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
		
				String str = hexBinaryTA.getText();
				int strLength = str.length();
			
				// Finds and validates the last value that the user enters.
				if(str.length() > 0){
					
					validate(str.charAt(strLength - 1));

				}
								
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
				
				String str = hexBinaryTA.getText();
				int strLength = str.length();
			
				// Finds and validates the last value that the user enters.
				validate(str.charAt(strLength - 1));

			}

			/**
			 * 
			 * Takes in character c and then validates that based on the conditions.
			 * if converting from binary to decimal the conditions are that c can only be 0 or 1.
			 * 
			 * If converting from hexadecimal to decimal than the conditions are that c has to be either 
			 * 0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f 
			 * 
			 * If neither of these conditions are satisfied it will throw the appropriate exception.
			 * 
			 * @param c
			 * @throws BinaryNumberFormatException
			 * @throws HexNumberFormatException
			 */
			
			//Validates if the user is inputing correct values in real time
			public void validate(char c) throws BinaryNumberFormatException, HexNumberFormatException{
				
				if(optionCB.getSelectedIndex() == 0){
					
				
						if(hexBinaryTA.getText() != null){
							optionCB.setEnabled(false);
						}
					
						if(c == '1' || c == '0'){
							
						decimalTA.setText("");
						evalButton.setEnabled(true);
							
						}
						
						else{
							
						decimalTA.setText("The character " + c + " is an invalid binary digit" );
						evalButton.setEnabled(false);

						throw new BinaryNumberFormatException(Character.toString(c));	
					}
						
					
						
				}else if(optionCB.getSelectedIndex() == 1){
										
				
					
					if(c == '0' || c == '1' || c == '2' ||  c == '3' ||  c =='4' ||
							 c == '5' || c == '6' || c == '7' || c =='8' ||  c == '9' ||
							 c == 'a' || c == 'b' || c == 'c' ||  c == 'd' ||  c == 'e'||
							 c == 'f' || c == 'A' || c == 'B' || c == 'C' ||  c == 'D' ||  c == 'E'||
							 c == 'F'){
						
						if(hexBinaryTA.getText() != null){
							optionCB.setEnabled(false);
						}
					
						
						decimalTA.setText("");
						evalButton.setEnabled(true);
						
					}
					else{
						
						decimalTA.setText("The character " + c + " is an invalid hexadecimal value");
						evalButton.setEnabled(false);
						
						throw new HexNumberFormatException(Character.toString(c));
					}
				}
			}
		});
		
    	// This is what will happen when the evaluation button is pressed
		evalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
        		// Determines if the hex or binary option is selected. 
            	
                if(optionCB.getSelectedIndex() == 0){
            	
            		String str = hexBinaryTA.getText();
            		int decimalValue = Integer.parseInt(str, 2);

            		decimalTA.setText(Integer.toString(decimalValue));
            		
            	}else if(optionCB.getSelectedIndex() == 1){
            		
            		String str = hexBinaryTA.getText();
            		int decimalValue = Integer.parseInt(str, 16);

            		decimalTA.setText(Integer.toString(decimalValue));
            	}
        
            	
            }
		});
		
		// This is what will happen when the clear button is pressed
		clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	hexBinaryTA.setText(null);
            	decimalTA.setText(null);
            	optionCB.setEnabled(true);
            	
            }
		});
		
		optionCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(optionCB.getSelectedIndex() == 0){
            		
            		hexLabel.setVisible(false);
            		binaryLabel.setVisible(true);
            		
            	}else if(optionCB.getSelectedIndex() == 1){
            		
            		hexLabel.setVisible(true);
            		binaryLabel.setVisible(false);
            		
            	}
            	
            }
		});
		
	
	}


}
