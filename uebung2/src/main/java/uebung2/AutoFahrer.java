package uebung2;

/**
 * AutoFahrer
 * Die Klasse von AutoFahrer
 * 
 * <p>
 * Beispiel:
 * <p>
 * <code>
 * AutoFahrer autoFahrer = new AutoFahrer(0, 0, 0, 0, false, false);
 * </code>
 * <p>
 */
public class AutoFahrer {
  public int ankommenZeit = 0;
  private int tankenZeit = 0;
  private int zahlenZeit = 0;
  private int wegZeit = 0;

  /**
   * Konstruktor von AutoFahrer mit 6 Parameter und 3 Attribute (getankt, gezahlt,
   * istWeg)
   * 
   * @param ankommenZeit ankommenZeit ist die Zeit, wie anlange muss man den
   *                     AutoFahrer erwarten.
   * @param tankenZeit   tankenZeit ist die Zeit, wie lange der AutoFahrer tankt.
   * @param zahlenZeit   zahlenZeit ist die Zeit, wie lange der AutoFahrer zahlt.
   * @param wegZeit      wegZeit ist die Zeit, wie lange der AutoFahrer weggeht.
   * @param getankt      getankt ist ein Attribut, ob der AutoFahrer getankt hat.
   * @param gezahlt      gezahlt ist ein Attribut, ob der AutoFahrer gezahlt hat.
   */
  public AutoFahrer(int ankommenZeit, int tankenZeit, int zahlenZeit, int wegZeit, boolean getankt, boolean gezahlt) {
    this.ankommenZeit = ankommenZeit;
    this.tankenZeit = tankenZeit;
    this.zahlenZeit = zahlenZeit;
    this.wegZeit = wegZeit;
  }

  /**
   * die methode getAnkommenZeit gibt die ankommenZeit zurueck.
   * 
   * @return ankommenZeit
   */
  public int getAnkommenZeit() {
    return ankommenZeit;
  }

  /**
   * die methode getTankenZeit gibt die tankenZeit zurueck.
   * 
   * @return tankenZeit
   */
  public int getTankenZeit() {
    return tankenZeit;
  }

  /**
   * die methode getZahlenZeit gibt die zahlenZeit zurueck.
   * 
   * @return zahlenZeit
   */
  public int getZahlenZeit() {
    return zahlenZeit;
  }

  /**
   * die methode getWegZeit gibt die wegZeit zurueck.
   * 
   * @return wegZeit
   */
  public int getWegZeit() {
    return wegZeit;
  }

  /**
   * die methode fuer das Verb tanken. es verringert die tankenZeit um 1.
   * 
   * @return void
   */
  public void tankt() {
    tankenZeit--;
  }

  /**
   * die methode fuer das Verb zahlen. es verringert die zahlenZeit um 1.
   * 
   * @return void
   */
  public void bezahlt() {
    zahlenZeit--;
  }

  /**
   * die methode fuer das Verb weggehen. es verringert die wegZeit um 1.
   * 
   * @return void
   */
  public void verlaesst() {
    wegZeit--;
  }

  /**
   * die methode fuer das Verb getankt. es aendert das Attribut getankt auf true ,
   * wenn ein Auto getankt ist.
   * 
   * @return boolean
   */
  public boolean istGetankt() {
    if (tankenZeit <= 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * die methode fuer das Verb gezahlt. es aendert das Attribut gezahlt auf true ,
   * wenn ein Auto gezahlt ist.
   * 
   * @return boolean
   */
  public boolean istBezahlt() {
    if (zahlenZeit <= 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * die methode fuer das Verb istWeg. es aendert das Attribut istWeg auf true ,
   * wenn ein Auto weggeht.
   * 
   * @return boolean
   */
  public boolean istWeg() {
    if (wegZeit <= 0) {
      return true;
    } else {
      return false;
    }
  }

}
