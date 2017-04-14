package com.twitter.poruka;

import com.twitter.poruke.TwitterPoruka;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tw;
	
	@Before
	public void setUp() throws Exception {
		tw=new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tw=null;
	}


	@Test
	public void testSetKorisnik() {
		tw.setKorisnik("Kristina");
		
		assertEquals("Kristina",tw.getKorisnik());
	}

	@Test (expected=java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		tw.setKorisnik(null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan(){
		tw.setKorisnik("");
	}
	

	@Test
	public void testSetPoruka() {
		tw.setPoruka("Twitter poruka");
		
		assertEquals("Twitter poruka", tw.getPoruka());
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		tw.setPoruka(null);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaPrazna(){
		tw.setPoruka("");
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testSetPorukaKarakteri(){
		tw.setPoruka("Although the Higgs field is believed to permeate the entire Universe, proving its existence was far from easy. In principle, it can be proved to exist by detecting its excitations, which manifest as Higgs particles (the 'Higgs boson'), but these are extremely difficult to produce and to detect. The importance of this fundamental question led to a 40 year search, and the construction of one of the world's most expensive and complex experimental facilities to date, CERN's Large Hadron Collider,[10] in an attempt to create Higgs bosons and other particles for observation and study. On 4 July 2012, the discovery of a new particle with a mass between 125 and 127 GeV/c2 was announced; physicists suspected that it was the Higgs boson.[11][12][13] Since then, the particle has been shown to behave, interact, and decay in many of the ways predicted for Higgs particles by the Standard Model, as well as having even parity and zero spin,[1] two fundamental attributes of a Higgs boson. This also means it is the first elementary scalar particle discovered in nature.[14] More studies are needed to verify with higher precision that the discovered particle has properties matching those predicted for the Higgs boson by the Standard Model, or whether, as predicted by some theories, multiple Higgs bosons exist.[3]");
	}

	@Test
	public void testToString() {
		
		String korisnik="Kristina";
		String poruka="Twitter poruka";
		
		
		tw.setKorisnik(korisnik);
		tw.setPoruka(poruka);
		
		assertEquals("KORISNIK:" + korisnik + " PORUKA:" + poruka,tw.toString());
	}

}
