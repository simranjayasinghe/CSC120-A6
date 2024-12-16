import java.util.Hashtable;

/**
 * Represents a library, keeps track of titles and collections
 * 
 */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  /**
   * Constructs Library with Building attributes, and initializes new Hashtable to store info about collection of books
   * 
   */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();

      System.out.println("You have built a library: 📖");
    }
  
  /**
   * Adds title to library's collection
   */
    public void addTitle(String title) {
      if (title == null || title.isEmpty()) {
        throw new IllegalArgumentException("Book title cannot be found");
      }
      collection.put(title, true);
      System.out.println(title + " has been added to the collection");
    }

  /**
   * Removes title from library's collection
   * 
   * @param title of book
   */
    public void removeTitle(String title) {
      if (collection.containsKey(title)) {
        collection.remove(title);
        System.out.println(title + " has been removed from the collection");
      } else {
        throw new RuntimeException(title + " is not in the collection");
      }
    }

  /**
   * Marks book as checked out from library
   *
   * @param title of book
   */
    public void checkOut(String title) {
      if (collection.containsKey(title)) {
        if (collection.get(title)) {
          collection.put(title, false);
          System.out.println(title + "has been checked out");
        } else {
          throw new RuntimeException(title + "is currently checked out");
        }
      } else {
        throw new RuntimeException(title + "is not in the collection");
        }
      } 


  /**
   * Marks book as returned to library
   *
   * @param title of book
   */
    public void returnBook(String title) {
      if (collection.containsKey(title)) {
        if (!collection.get(title)) {
          collection.put(title, true);
          System.out.println(title + "has been returned");
        } else {
          throw new RuntimeException(title + "was not checked out");
        }
      } else {
        throw new RuntimeException(title + "is not in the collection");
        }
    }


  /**
   * Checks if book is in library's collection
   * 
   * @param title of book
   * @return whether book is in collection or not
   */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

  /**
   * Checks if book is available
   *
   * @param title of book
   * @return whether book is available or not
   * 
   */
    public boolean isAvailable(String title) {
      if (collection.containsKey(title)) {
        return collection.get(title);
      } else{
        throw new RuntimeException(title + " is not in the collection");
      }
    }

  /**
   * Override toString in Building superclass
   */
    @Override
    public String toString() {
      return super.toString() + ". It contains a collection of books";
    }

  /**
   * Print all titles in collection with checkout status
   * 
   */
    public void printCollection() {
      System.out.println("Library Collection:");
      for (String title : collection.keySet()) {
          String status = collection.get(title) ? "Available" : "Checked out";
          System.out.println("- " + title + " (" + status + ")");
      }
  }


  /**
   * Testing things!
   * Print library details, add and remove titles, checkout and return books, checking availability throughout
   * print library collection
   * 
   */
  public static void main(String[] args) {
      Library myLibrary = new Library("Neilson Library", "7 Neilson Drive, Northampton MA 01063", 4);
      System.out.println(myLibrary);

      myLibrary.addTitle("Think Java: How to Think Like a Computer Scientist, 2nd edition");
      System.out.println("Is 'Think Java: How to Think Like a Computer Scientist, 2nd edition' available?" + myLibrary.isAvailable("Think Java: How to Think Like a Computer Scientist, 2nd edition"));

      myLibrary.checkOut("Think Java: How to Think Like a Computer Scientist, 2nd edition");
      System.out.println("Is 'Think Java: How to Think Like a Computer Scientist, 2nd edition' available?" + myLibrary.isAvailable("Think Java: How to Think Like a Computer Scientist, 2nd edition"));
      
      myLibrary.returnBook("Think Java: How to Think Like a Computer Scientist, 2nd edition");
      System.out.println("Is 'Think Java: How to Think Like a Computer Scientist, 2nd edition' available?" + myLibrary.isAvailable("Think Java: How to Think Like a Computer Scientist, 2nd edition"));

      myLibrary.printCollection();
    }
  
  }