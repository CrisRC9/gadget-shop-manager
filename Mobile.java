
/**
 * This class represents a Mobile object, which is a type of Gadget.
 * It includes attributes and methods specific to a Mobile device.
 */
public class Mobile extends Gadget
{
    private int remainingCredit; // Number of minutes of calling credit remaining
    
    // Constructor 
    public Mobile (String model, double price, int weight, String size, int remainingCredit)
    {
       super(model, price, weight, size); //Calling the superclass constructor
       this.remainingCredit = remainingCredit; // Initializing the Mobile attribute
    }

    // Accesor method for remainingCredit
    public int getRemainingCredit()
    {
        return remainingCredit;
    }
    
    // Accesor method to add calling credit
    public void addCredit(int creditToAdd)
    {
    // Check if the added credit is grater than zero
     if (creditToAdd > 0)
     {
         //If positive, add the amout to the remaining credit
         this.remainingCredit += creditToAdd;
         System.out.println (creditToAdd + " credit minutes added succesfully.");
         
        }
        else
        {
            System.out.println("Please enter a positive amount of credit");
        }
    }
    
    //Method for making a phone call
    public void makeACall (String phoneNumber, int callDuration)
    {
        if (this.remainingCredit >= callDuration)
        {
            // If there is sufficient credit, deduct the call duration from remaining credit
            this.remainingCredit -= callDuration;
            this.remainingCredit -= callDuration;
            System.out.println("Calling " + phoneNumber + " for " 
            + callDuration + " minutes.");
        }
        else
        {
            System.out.println ("Insufficiente calling credit");
        }
    }
    
     @Override
    // A display method to output the attribute values
    public String displayGadgetDetails() {
        // Creating a string builder to store the output
        StringBuilder output = new StringBuilder();
        // Calling the display method in the gadget class to show the model, price, weight and size
        output.append(super.displayGadgetDetails());
        // Appending the number of minutes of calling credit remaining
        output.append("Credit: " + remainingCredit + " minutes" + "\n");
        return output.toString();
    }
}
