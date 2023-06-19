/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

/**
 *
 * die klasse KeyByte
 * 
 * @author Lucas Matthes
 */
public class KeyByte {
    private int a, b, m, lastValue;

    /**
     * Konstruktor
     * 
     * @param a   Chiffreparameter
     * @param b   Chiffreparameter
     * @param m   Chiffreparameter
     * @param key Chiffreparameter
     */
    KeyByte(int a, int b, int m, int key) {
        this.a = a;
        this.b = b;
        this.m = m;
        this.lastValue = key;
    }

    /**
     * Gibt naechstes Schluesselbyte aus
     * 
     * @return naechstes Schluesselbyte
     */
    public Byte getNextByte() {
        lastValue = (a * lastValue + b) % m;
        return (byte) lastValue;
    }
}
