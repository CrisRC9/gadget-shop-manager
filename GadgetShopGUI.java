//// Import necessary libraries for Swing GUI components, event handling, and ArrayList
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Define the class GadgetShopGUI and implement the ActionListener
public class GadgetShopGUI implements ActionListener {
    // Declare class variables
    private JFrame frame; // JFrame for the main window
    private JLabel modelLabel; // JLabels for displaying text labels
    private JLabel priceLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JLabel creditLabel;
    private JLabel memoryLabel;
    private JLabel phoneNumberLabel;
    private JLabel durationLabel;
    private JLabel downloadLabel;
    private JLabel displayNumberLabel;

    // JTextFields for user input
    private JTextField modelTextBox;
    private JTextField priceTextBox;
    private JTextField weightTextBox;
    private JTextField sizeTextBox;
    private JTextField creditTextBox;
    private JTextField memoryTextBox;
    private JTextField phoneNumberTextBox;
    private JTextField durationTextBox;
    private JTextField downloadTextBox;
    private JTextField displayNumberTextBox;

    // JButtons for user interaction
    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeCallButton;
    private JButton downloadMusicButton;

    // ArrayList to store Gadget objects
    ArrayList<Gadget> item = new ArrayList<Gadget>();

    // Constructor of GUI
    public GadgetShopGUI() {
        // Initialize the main JFrame and its content pane
        frame = new JFrame("Gadget Shop");
        Container contentPane = frame.getContentPane();
        
        // Create and add JLabels and JTextFields for user input
        modelLabel = new JLabel("Model: ");
        modelTextBox = new JTextField(10);
        contentPane.add(modelLabel);
        contentPane.add(modelTextBox);

        priceLabel = new JLabel("Price: ");
        priceTextBox = new JTextField(10);
        contentPane.add(priceLabel);
        contentPane.add(priceTextBox);

        weightLabel = new JLabel("Weight: ");
        weightTextBox = new JTextField(10);
        contentPane.add(weightLabel);
        contentPane.add(weightTextBox);

        sizeLabel = new JLabel("Size: ");
        sizeTextBox = new JTextField(10);
        contentPane.add(sizeLabel);
        contentPane.add(sizeTextBox);

        creditLabel = new JLabel("Credit: ");
        creditTextBox = new JTextField(10);
        contentPane.add(creditLabel);
        contentPane.add(creditTextBox);

        memoryLabel = new JLabel("Available Memory: ");
        memoryTextBox = new JTextField(10);
        contentPane.add(memoryLabel);
        contentPane.add(memoryTextBox);

        phoneNumberLabel = new JLabel("Phone Number: ");
        phoneNumberTextBox = new JTextField(10);
        contentPane.add(phoneNumberLabel);
        contentPane.add(phoneNumberTextBox);

        durationLabel = new JLabel("Duration: ");
        durationTextBox = new JTextField(10);
        contentPane.add(durationLabel);
        contentPane.add(durationTextBox);

        downloadLabel = new JLabel("Download Size: ");
        downloadTextBox = new JTextField(10);
        contentPane.add(downloadLabel);
        contentPane.add(downloadTextBox);

        displayNumberLabel = new JLabel("Display Number: ");
        displayNumberTextBox = new JTextField(10);
        contentPane.add(displayNumberLabel);
        contentPane.add(displayNumberTextBox);

        // Create and add JButtons for user interaction
        addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(this);

        addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(this);

        makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(this);

        downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(this);
        // Set the layout of the content pane to a GridLayout with 0 rows and 4 columns
        contentPane.setLayout(new GridLayout(0, 4));

        // Add JButtons to the content pane
        contentPane.add(addMobileButton);
        contentPane.add(addMP3Button);
        contentPane.add(clearButton);
        contentPane.add(displayAllButton);
        contentPane.add(makeCallButton);
        contentPane.add(downloadMusicButton);

        // Pack the frame and make it visible
        frame.pack();
        frame.setVisible(true);

    }
    
    // ActionListener implementation for handling buttons
    public void actionPerformed(ActionEvent event)
    {
    String command = event.getActionCommand();// Get the action command of the event
        // Check the action command and perform corresponding actions
    if (command.equals("Add Mobile")) {
            try {
                addMobile(); // Call method to add a mobile gadget
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame,"Error! Enter only numeric values");                
            }
        }
    if (command.equals("Add MP3")) {
        addMP3(); // Call method to add an MP3 gadget
    }
    if (command.equals("Display All")) {
        displayGadgetDetails(); // Call method to display details of all gadgets
        }
    if (command.equals("Make A Call")) {
        makeACall(); // Call method to make a call
        }
    if (command.equals("Download Music")) {
        downloadMusic(); // Call method to clear text fields
        }
    if (command.equals("Clear")) {
        clear();
        }
    
}

    // Method to add a mobile to gadget
    public void addMobile()
    {
        // Create a new Mobile object with user input and add it to the ArrayList
        Mobile newMobile = new Mobile(getModel(), getPrice(), getWeight(), getSize(), getCredit());
        item.add(newMobile);
        // Show a message dialog to confirm the addition
        JOptionPane.showMessageDialog(frame, "New mobile added");
    }

    // Method to add an MP3 gadget
    public void addMP3()
    {
        // Create a new MP3 object with user input and add it to the ArrayList
        MP3 newMP3 = new MP3(getModel(), getPrice(), getWeight(), getSize(), getMemory());
        item.add(newMP3);
        JOptionPane.showMessageDialog(frame, "A new MP3 has been added");
    }

    // Method to display details of all gadgets
    public void displayGadgetDetails() {
        // Creating a string builder to store the result
        StringBuilder result = new StringBuilder();
        // Looping through the array list of gadgets
        for (int i = 0; i < item.size(); i++) {
            // Getting the gadget at the current index
            Gadget gadget = item.get(i);
            // Appending the display number and a new line to the result
            result.append("Display Number: " + i + "\n");
            // Calling the display method of the gadget and appending the output to the result
            result.append(gadget.displayGadgetDetails() + "\n");
        }
        JOptionPane.showMessageDialog(frame, result.toString());
        }

    // Method to make a call
    public void makeACall() {
        // Get the display number, phone number, and duration from the text fields
        int displayNumber = Integer.parseInt(displayNumberTextBox.getText());
        String phoneNumber = phoneNumberTextBox.getText();
        int duration = Integer.parseInt(durationTextBox.getText());

        // Check if the display number is valid
        if (displayNumber >= 0 && displayNumber < item.size()) {
            // Get the gadget at the display number index from the ArrayList
            Gadget gadget = item.get(displayNumber);

            // Check if the gadget is an instance of Mobile
            if (gadget instanceof Mobile) {
                Mobile mobile = (Mobile) gadget;
                // Call the makeCall method of the Mobile object
                mobile.makeACall(phoneNumber, duration);
                // Display a confirmation message
                JOptionPane.showMessageDialog(frame, "Call made successfully.");
            } else {
                // Display an error message if the gadget is not a Mobile
                JOptionPane.showMessageDialog(frame, "The selected gadget is not a mobile phone.");
            }
        } else {
            // Display an error message if the display number is invalid
            JOptionPane.showMessageDialog(frame, "Error! Invalid display number.");
        }
    }

    // Method to download music
    public void downloadMusic() {
        // Get the display number and download size from the text fields
        int displayNumber = Integer.parseInt(displayNumberTextBox.getText());
        int downloadSize = Integer.parseInt(downloadTextBox.getText());

        // Check if the display number is valid
        if (displayNumber >= 0 && displayNumber < item.size()) {
            // Get the gadget at the display number index from the ArrayList
            Gadget gadget = item.get(displayNumber);

            // Check if the gadget is an instance of MP3
            if (gadget instanceof MP3) {
                MP3 mp3 = (MP3) gadget;
                // Call the downloadMusic method of the MP3 object
                mp3.downloadMusic(downloadSize);
                // Display a confirmation message
                JOptionPane.showMessageDialog(frame, "Music downloaded successfully.");
            } else {
                // Display an error message if the gadget is not an MP3 player
                JOptionPane.showMessageDialog(frame, "The selected gadget is not an MP3 player.");
            }
        } else {
            // Display an error message if the display number is invalid
            JOptionPane.showMessageDialog(frame, "Invalid display number.");
        }
    }

    // Method to get credit value from creditTextBox
    public int getCredit(){
        int callCredit = Integer.parseInt(creditTextBox.getText());
        return callCredit;
    }

    // Method to get model value from modelTextBox
    public String getModel(){
        String aModel = modelTextBox.getText();
        return aModel;
    }

    public int getDuration(){
       try {
        return Integer.parseInt(durationTextBox.getText());
    } catch (NumberFormatException e) {
        // Display error message for non-integer input
        JOptionPane.showMessageDialog(frame, "Duration must be an integer.");
        return -1; // Return -1 to indicate an error
    }
        
    }
    // Method to get the price from the price text field
    private double getPrice(){
        double aPrice = Double.parseDouble(priceTextBox.getText());
        return aPrice;
    }

    // Method to get the weight from the weight text field
   private int getWeight(){
    try {
        int aWeight = Integer.parseInt(weightTextBox.getText());
        return aWeight;
    } catch (NumberFormatException e) {
        // Display error message for non-integer input
        JOptionPane.showMessageDialog(frame, "Error! Only integers allowed on weight.");
        return -1; // Return -1 to indicate an error
    }
}

    // Method to get the size from the size text field
    private String getSize(){
        String aSize = sizeTextBox.getText();
        return aSize;
    }

    // Method to get the memory from the memory text field
    public int getMemory(){
        int aMemory = Integer.parseInt((memoryTextBox.getText()));
        return aMemory;
    }

    // Method to get the display number from the display number text field
    public int getDisplayNumber(){
    int displayNumber = -1; // Initialize display number to -1
    String displayNumberText = displayNumberTextBox.getText(); // Get text from display number text field
    
    try {
        displayNumber = Integer.parseInt(displayNumberText); // Try parsing the text to an integer
        
        // Check if display number is within the valid range
        if (displayNumber < 0 || displayNumber >= item.size()) {
            JOptionPane.showMessageDialog(frame, "The display number must be between 0 and " + (item.size() - 1), "Error", JOptionPane.ERROR_MESSAGE);
            displayNumber = -1; // Reset display number to -1 if out of range
        }
    } catch (NumberFormatException e) {
        // Display error message if the input is not a valid integer
        JOptionPane.showMessageDialog(frame, "The display number must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    return displayNumber; // Return the display number
}
   
    // Method to clear all text fields
    private void clear() {
        modelTextBox.setText("");
        priceTextBox.setText("");
        weightTextBox.setText("");
        sizeTextBox.setText("");
        creditTextBox.setText("");
        memoryTextBox.setText("");
        phoneNumberTextBox.setText("");
        durationTextBox.setText("");
        downloadTextBox.setText("");
        displayNumberTextBox.setText("");
    }

    // Main method to start the GUI application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GadgetShopGUI::new);
    }
}
