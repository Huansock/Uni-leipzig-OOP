package uebung2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Kasse
 * Die Klasse von Kasse
 * 
 * <p>
 * Beispiel:
 * <p>
 * <code>
 * Kasse kasse = new Kasse(kasseSchlange, false);
 * </code>
 */
public class Kasse {
  Queue<AutoFahrer> schlange = new LinkedList<>();
  public boolean besetzt = false;

  /**
   * Kasse Konstruktor mit Parameter schlange und besetzt
   * 
   * @param schlange schlange ist ein Queue von AutoFahrer vor der Kasse
   * @param besetzt  besetzt ist ein Attribut, ob die Kasse besetzt ist.
   */
  public Kasse(Queue<AutoFahrer> schlange, boolean besetzt) {
    this.schlange = schlange;
    this.besetzt = besetzt;
  }

  /**
   * die methode addInSchlange fuegt ein AutoFahrer in die Schlange hinzu.
   * 
   * @return void
   */
  public void addInSchlange(AutoFahrer autoFahrer) {
    schlange.add(autoFahrer);
  }

  /**
   * die methode popSchlange entfernt ein AutoFahrer von der Schlange.
   */
  public void popSchlange() {
    schlange.poll();
  }

  /**
   * die methode getSchlangeSize gibt die Groesse der Schlange zurueck.
   * 
   * @return int Groesse der Schlange
   */
  public int getSchlangeSize() {
    return schlange.size();
  }
}
