package uebung4;

/**
 * Fisch Klasse fuer eine Fisch
 * 
 * @author wooseok yang
 */
public class Fisch {

  private int id;
  private int cost;
  private String name;
  private int unverträglichkeiten[];

  /**
   * Fisch
   * 
   * @param id                  id fuer den Fisch
   * @param cost                kosten fuer den Fisch
   * @param name                name des Fisches
   * @param unverträglichkeiten unverträglichkeiten des Fisches
   */
  public Fisch(int id, int cost, String name, int[] unverträglichkeiten) {
    this.id = id;
    this.cost = cost;
    this.name = name;
    this.unverträglichkeiten = unverträglichkeiten;
  }

  /**
   * toString gibt den Namen des Fisches zurueck
   * 
   * @return name
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * getCost gibt die Kosten des Fisches zurueck
   * 
   * @return unverträglichkeiten
   */
  public int[] getUnverträglichkeiten() {
    return unverträglichkeiten;
  }

  /**
   * getId gibt die Id des Fisches zurueck
   * 
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * getCost gibt die Kosten des Fisches zurueck
   * 
   * @return cost
   */
  public int getCost() {
    return cost;
  }
}
