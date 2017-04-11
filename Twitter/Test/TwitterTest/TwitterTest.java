package TwitterTest;
import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterTest {
	private Twitter twt;
	
	@Before
	public void setUp() throws Exception {
		twt=new Twitter();
		
	}

	@After
	public void tearDown() throws Exception {
		twt=null;
	}

	/*@Test
	public void testVratiSvePoruke() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testUnesi() {
		
		twt.unesi("Kristina", "Ovo je tvit.");
		
		assertEquals("Ovo je tvit.",twt.vratiSvePoruke().getLast().getPoruka());
		assertEquals("Kristina",twt.vratiSvePoruke().getLast().getKorisnik());
	}
	
	@Test
	public void testUnesiProveraVelicine() {
	
		int size=twt.vratiSvePoruke().size();
		
		twt.unesi("Kristina", "Ovo je tvit.");
		
		assertEquals(size+1,twt.vratiSvePoruke().size());
	
	}

	@Test
	public void testVratiPoruke() {
		
		twt.unesi("Kristina", "Poruka ima trazenu #rec.");
		twt.unesi("Nenad", "Poruka nema tag.");
		twt.unesi("Petar", "Tviiit!");
		twt.unesi("Milan", "Ovaj tvit ima #rec.");
		twt.unesi("Jovan", "Ovaj tvit ima #rec.");
		twt.unesi("Milan", "Ovaj tvit ima #rec.");
		twt.unesi("Milan", "Ovaj tvit ima #rec.");
		
		
		TwitterPoruka[] tagovanePoruke=twt.vratiPoruke(5,"#rec");
		
		assertEquals(5,twt.vratiPoruke(5,"#rec").length);
		assertEquals("Kristina",tagovanePoruke[0].getKorisnik());
		assertEquals("Milan",tagovanePoruke[4].getKorisnik());
		assertEquals("Jovan",tagovanePoruke[2].getKorisnik());
		
		
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNull(){
		twt.unesi("Kristina", "Poruka ima trazenu #rec.");
		twt.unesi("Nenad", "Poruka nema tag.");
		
		TwitterPoruka[] tagovanePoruke=twt.vratiPoruke(5,null);
		assertEquals("Kristina",tagovanePoruke[0].getKorisnik());
		
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukePrazan(){
		twt.unesi("Kristina", "Poruka ima trazenu #rec.");
		twt.unesi("Nenad", "Poruka nema tag.");
		
		TwitterPoruka[] tagovanePoruke=twt.vratiPoruke(5,"");
		assertEquals("Kristina",tagovanePoruke[0].getKorisnik());
		
		
	}
	
	@Test
	public void testVratiPorukeDuzinaNizaNaDefault(){
		
		assertEquals(100,twt.vratiPoruke(-15,"#rec").length);
	}
	
	@Test (expected=java.lang.RuntimeException.class)
	
	public void testVratiPorukePrekoracenje(){
		twt.unesi("Kristina", "Poruka ima trazenu #rec.");
		twt.unesi("Nenad", "Poruka nema tag.");
		twt.unesi("Petar", "Tviiit!");
		twt.unesi("Milan", "Ovaj tvit ima #rec.");
		twt.unesi("Jovan", "Ovaj tvit ima #rec.");
		twt.unesi("Milan", "Ovaj tvit ima #rec.");
		twt.unesi("Milan", "Ovaj tvit ima #rec.");
		
		TwitterPoruka[] tagovanePoruke=twt.vratiPoruke(3,"#rec");
		assertEquals("Jovan",tagovanePoruke[2].getKorisnik());
		//ovde treba da baci indexOutOfBounds izuzetak
		assertEquals("Milan", tagovanePoruke[3].getKorisnik());
		
	}
		
}
