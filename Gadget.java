
/**This class represents a Gadget object with its
 * attributes such as model, price, weight and size. 
 */

public class Gadget
{
    // Attributes 
    private String model;
    private double price;
    private int weight;
    private String size;
    
    // Constructor 
    public Gadget(String model, double price, int weight, String size){
        // Using "this" keyword to differentiate between instance variables and constructor parameters
        this.model = model; // Assigns the value of the model parameter to the model attribute
        this.price = price;
        this.weight = weight;
        this.size = size;
        
    }

    // Accesor methods
    public String getModel()
    {
        return model;// Returns the model of the dadget
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getWeight()
    {
        return weight;
    }

    public String getSize()
    {
        return size;
    }
    /* 
     * Method to display the details of the gadget,
     * including model,price, weight and size 
     */
    
     public String displayGadgetDetails() {
        // Creating a string builder to store the output
        StringBuilder output = new StringBuilder();
        // Appending the attribute values to the output
        output.append("Model: " + model + "\n");
        output.append("Price: £" + price + "\n");
        output.append("Weight: " + weight + "g" + "\n");
        output.append("Size: " + size + "\n");
        // Returning the output as a string
        return output.toString();
    }
    
}
