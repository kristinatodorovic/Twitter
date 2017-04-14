package com.twitter.poruke;
	/**
	 * Ova klasa predstavlja Twitter poruku.
	 * 
	 * @author Kristina Todorovic
	 * @version 1.0
	 */
public class TwitterPoruka {


	/**
	 * Ime korisnika kao string.
	 */
	private String korisnik;

	/**
	 * Poruka kao string.
	 */
	private String poruka;

	/**
	 * Metoda vraca ime korisnika.
	 * 
	 * @return ime korisnika kao string
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja novu vrednost za ime korisnika.
	 * 
	 * @param korisnik
	 *            ime korisnika kao string
	 * @throws java.lang.RuntimeException
	 *             ako je uneto ime:
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan string</li>
	 *             </ul>
	 */

	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca poruku.
	 * 
	 * @return poruka kao string
	 */

	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja novu vrednost za poruku.
	 * 
	 * @param poruka
	 *            kao string
	 * @throws java.lang.RuntimeException
	 *             ako je uneta poruka:
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan string</li>
	 *             <li>duza od 140 karaktera</li>
	 *             </ul>
	 */

	public void setPoruka(String poruka) {
		if (poruka == null || poruka == "" || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Redefinisana metoda toString() koja vraca ime korisnika i poruku.
	 * 
	 * @return korisnik i poruka u vidu stringa
	 */

	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
