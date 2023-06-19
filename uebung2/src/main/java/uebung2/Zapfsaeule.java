package uebung2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Zapfsaeule
 * Die Klasse von Zapfsaeule
 * 
 * <p>
 * Beispiel:
 * <p>
 * <code>
 * Zapfsaeule zapfsaeule = new Zapfsaeule(schlange, false, false);
 * </code>
 */
public class Zapfsaeule {
  Queue<AutoFahrer> schlange = new LinkedList<>();
  boolean besetzt = false;
  boolean geraeumt = false;

  /**
   * Zapfsaeule Konstruktor mit Parameter schlange, besetzt und geraeumt
   * 
   * @param schlange schlange ist ein Queue von AutoFahrer vor der Zapfsaeule
   * @param besetzt  besetzt ist ein Attribut, ob die Zapfsaeule besetzt ist.
   * @param geraeumt geraeumt ist ein Attribut, ob die Zapfsaeule geraeumt ist.
   */
  public Zapfsaeule(Queue<AutoFahrer> schlange, boolean besetzt, boolean geraeumt) {
    this.schlange = schlange;
    this.besetzt = besetzt;
    this.geraeumt = geraeumt;
  }

  /**
   * die Methode addInSchlange fuegt ein AutoFahrer in die Schlange hinzu.
   * 
   * @return void
   */
  public void addInSchlange(AutoFahrer autoFahrer) {
    schlange.add(autoFahrer);
  }

  /**
   * die Methode popSchlange entfernt ein AutoFahrer von der Schlange.
   */
  public void popSchlange() {
    schlange.poll();
  }

  /**
   * die Methode getSchlangeSize gibt die Groesse der Schlange zurueck.
   * 
   * @return int Groesse der Schlange
   */
  public int getSchlangeSize() {
    return schlange.size();
  }

}
