import java.util.ArrayList;

/**
 * Represents a house, and keeps track of residents, presence of a dining room
 *
 */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * Constructs House with Building attributes, plus new attributes for number of residents and presence of dining room
   * 
   * @param hasDiningRoom whether or not the house has a dining room
   * 
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;

    System.out.println("You have built a house: 🏠");
  }

  /**
  * Whether or not the house has a dining room
  * 
  * @return whether or not the house has a dining room
  *
  */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Gives the number of residents in the house
   * 
   * @return number of residents in the house
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Moves a given resident into the house
   * 
   * @param name of resident to move in
   * 
   */
  public void moveIn(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Resident name cannot be empty");
    }
    this.residents.add(name);
    System.out.println(name + " has moved into " + this.name);
  }

  /**
   * Moves given resident out of the house
   * 
   * @param name of the resident to move out
   */
  public String moveOut(String name) {
    if (this.residents.remove(name)) {
      System.out.println(name + " has moved out of " + this.name);
      return name;
    } else {
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
  }

  /**
   * Whether a given person is a resident of the house
   * 
   * @param name of the person
   * @return whether or not given person is a resident of the house
   */
  public boolean isResident(String person) {
    return this.residents.contains(name);
  }

  /**
   * Override toString in Building superclass
   */
  @Override
  public String toString() {
    String diningRoom = hasDiningRoom ? "has a dining room" : "does not have a dining room";
    return super.toString() +  "\nIt " + diningRoom + " and has " + residents.size() + " residents";
  }



  /**
   * Testing things!
   * Print house details, move residents in and out of the house
   * print number of residents in the house, check if person is a resident of the house
   *
   */
  public static void main(String[] args) {
    House myHouse = new House("Jordan House", "1 Paradise Rd", 4, false);
    System.out.println(myHouse);

    myHouse.moveIn("Simran");
    myHouse.moveIn("Parvaneh");

    System.out.println("Number of residents: " + myHouse.nResidents());
    System.out.println(myHouse);

    myHouse.moveOut("Parvaneh");
    System.out.println("Is Parvaneh a resident? " + myHouse.isResident("Parvaneh"));
  }

}