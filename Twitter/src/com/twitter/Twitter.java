package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

	/**
	 * @author Kristina Todorovic
	 * @version 1.0
	 */

public class Twitter {
	
	/**
	 * Poruke u vidu liste.
	 */

	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda vraca sve poruke kao listu.
	 * @return lista poruka
	 */

	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	
	/**
	 * Metoda unosi novu poruku u listu.
	 * @param korisnik kao string
	 * @param poruka kao string
	 */

	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda vraca niz poruka koje sadrze tag.
	 * @param maxBroj ceo broj koji predstavlja kapacitet niza
	 * @param tag string koji proveravamo da li se sadrzi u porukama
	 * @throws java.lang.RuntimeException ako je unet tag:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 * @return niz poruka koje sadrze trazeni tag
	 * 
	 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}

