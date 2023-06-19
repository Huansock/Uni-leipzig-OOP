package uebung4;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Klasse als Representation einer moeglichen Komposition aus Fischen
 * 
 * @author lucas
 */
public class Komposition {
  private ArrayList<Fisch> list = new ArrayList<>();
  private ArrayList<Fisch> allFisch = new ArrayList<>();

  /**
   * Konstruktor mit Liste der bereits gesetzten Fische
   * 
   * @param list , allFisch
   */
  public Komposition(ArrayList<Fisch> list, ArrayList<Fisch> allFisch) {
    this.list = list;
    this.allFisch = allFisch;
  }

  /**
   * StandartKonstruktor fuer leere Liste
   */
  public Komposition(ArrayList<Fisch> allFisch) {
    this.allFisch = allFisch;
  }

  /**
   * Fuegt zur Belegung hinzu
   * 
   * @param newFisch hinzuzufuegende Fisch
   */
  public void add(Fisch newFisch) {
    list.add(newFisch);
  }

  /**
   * Gibt eine Liste aller Fische, die hinzugefuegt werden koennten, zurueck
   * 
   * @return Liste
   */
  public ArrayList<Fisch> getPossibleAdditions() {
    ArrayList<Fisch> helpList = new ArrayList<Fisch>(allFisch);
    for (Fisch f : list) {
      helpList.remove(f);
      for (int i : f.getUnverträglichkeiten()) {
        Optional<Fisch> x = helpList.stream().filter(p -> p.getId() == i).findFirst();
        if (x.isPresent()) {
          helpList.remove(x.get());
        }
      }
    }
    return helpList;
  }

  /**
   * Gibt aufsummierte Kosten der Belegung zurueck
   * 
   * @return Kosten als int
   */
  public int getCost() {
    int sum = 0;
    for (Fisch f : list) {
      sum += f.getCost();
    }
    return sum;
  }

  /**
   * gibt size der ArrayList zurueck
   * 
   * @return
   */
  public int getSize() {
    return list.size();
  }

  /**
   * Aufzaehlung der Fischnamen
   * 
   * @return Aufzaehlung als String
   */
  @Override
  public String toString() {
    StringBuilder mBuilder = new StringBuilder();
    for (Fisch f : list) {
      mBuilder.append(f.toString());
      mBuilder.append("  ");
    }
    return mBuilder.toString();
  }

  /**
   * Erzeugt neue Komposition erweitert um einen Fisch
   * 
   * @param newFisch erweiternter Fisch
   * @return neue Komposition
   */
  public Komposition fuseWith(Fisch newFisch) {
    ArrayList<Fisch> helpList = new ArrayList<Fisch>(list);
    helpList.add(newFisch);
    return new Komposition(helpList, allFisch);
  }
}
