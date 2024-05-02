/**
 * This class represents an MP3 player, which is a type of Gadget.
 * It includes attributes and methods specific to an MP3 player.
 */

public class MP3 extends Gadget
{
    // Attribute
    private int availableMemory;

    // Constructor 
    public MP3(String model, double price, int weight, String size, int availableMemory)
    {
        super(model, price, weight, size); // Call the constructor of the gadget superclass
        this.availableMemory = availableMemory; // Initialize the  MP3-specific attribute
    }

    // Accessor method for availableMemory
    public int getAvailableMemory()
    {
        return availableMemory; // Return the available memory
    }
    
    //Method to download music
    public void downloadMusic(int memorySize) 
    {
        if (this.availableMemory >= memorySize)
        {
            this.availableMemory -= memorySize;// Decrease available memory by the size of the music
            System.out.println ("song downloaded succesfuly. Remaining memory: " +
            this.availableMemory + " units.");
        }
        else
        {
            // If not enough memory, display an error message
            System.out.println ("Error! Insufficient memory for this download.");
        }
        
    }
    
    // Method to delete music
    public void deleteMusic(int memorySize) {
    this.availableMemory += memorySize; // Increase available memory by the size of the deleted music
    System.out.println("Music deleted successfully. Available memory: " + this.availableMemory + " units.");
    }
    
    // Overridden method to display details of the MP3 player
    @Override
    public String displayGadgetDetails() {
        // Creating a string builder to store the output
        StringBuilder output = new StringBuilder();
        // Calling the display method in the gadget class to show the model, price, weight and size
        output.append(super.displayGadgetDetails());
        // Appending the available memory in megabytes
        output.append("Memory: " + availableMemory + "MB" + "\n");
        // Returning the output as a string
        return output.toString();
    }
}
