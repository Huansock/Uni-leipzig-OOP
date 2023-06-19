/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

/**
 *
 * Die Klasse main, die das Programm ausfuehrt.
 * 
 * @author Lucas Matthes
 */
public class Execute {

    public static void main(String[] args) {
        // FileToByte ftb = new
        // FileToByte("/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/Gedicht.txt");
        // System.out.println(ftb.getNextByte());
        // System.out.println(ftb.getNextByte());
        // KeyByte kb = new KeyByte(421, 54773, 259200, (byte) 3);
        // System.out.println(kb.getNextByte() & 0x20);
        // System.out.println(kb.getNextByte());
        Runchiffre mainRun = new Runchiffre();
        mainRun.run();
    }

}
