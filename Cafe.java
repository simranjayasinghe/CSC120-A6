
/**
 * Represents a cafe, keeps track of inventory
 * 
 */
public class Cafe extends Building {

    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs Cafe with Building attributes, as well as attributes for number of coffee ounces, sugar packest, creams, and cups in its inventory
     * 
     * @param name of cafe
     * @param address of cafe
     * @param nFloors number of floors of cafe
     * @param nCoffeeOunces number of coffee ounces remaining in inventory
     * @param nSugarPackets number of sugar packets remaining in inventory
     * @param nCreams number of creams remaining in inventory
     * @param nCups number of cups remaining in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Sells coffee cups, calls restock if inventory is not sufficient
     * 
     * @param size of coffee
     * @param sugarPackets number of sugars needed for coffee
     * @param creams number of creams needed for coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(100, 100, 100, 100);
            throw new RuntimeException("Restocking inventory...");
        }
        
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups--;
        
        System.out.println("Coffee with " + size + " ounces, " + nSugarPackets + " sugars, and " + nCreams + " creams - sold!");

    }

    /**
     * Restocks inventory of every item
     * 
     * @param coffeeOunces current number of coffee ounces
     * @param sugarPackets current number of sugar packets
     * @param creams current number of creams
     * @param cups current number of cups
     */
    private void restock(int coffeeOunces, int sugarPackets, int creams, int cups) {
        nCoffeeOunces += coffeeOunces;
        nSugarPackets += sugarPackets;
        nCreams += creams;
        nCups += cups;
        System.out.println("Restocked: " + coffeeOunces + " coffee ounces, " + sugarPackets + " sugar packets, " + creams + " creams, and " + cups + " cups.");
    }

    /**
     * Override toString in Building superclass
     */
    @Override
    public String toString() {
        return super.toString() + "\nIt currently has " + nCoffeeOunces + " ounces of coffee, " + nSugarPackets + " sugar packets, " + nCreams + " creams, and " + nCups + " cups.";
    }

    /**
   * Testing things!
   * Print cafe details, sell coffees, print cafe details again (inventory should change)
   */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "7 Neilson Drive, Northampton MA 01063", 1, 500, 200, 100, 50);
        System.out.println(myCafe);

        myCafe.sellCoffee(16, 2, 1);
        myCafe.sellCoffee(32, 4, 2);
        
        System.out.println(myCafe);
    }
    
}
