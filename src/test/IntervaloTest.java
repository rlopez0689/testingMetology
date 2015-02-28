package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class IntervaloTest {
	private IntervalTestData itd;
	private boolean created=true;
	
	@Before
	public void beforeTest(){
		if(created){
			itd = new IntervalTestData();
			created = false;
		}
	}

	@Test
	public void testLongitud() {
		for(int i=0;i<itd.intervaloData.size()-1;i++){
			assertEquals(itd.intervaloData.get(i).longitud(),(double)itd.longitudData.get(i),1e-15);
		}
	}

	@Test
	public void testPuntoMedio() {
		for(int i=0;i<itd.intervaloData.size()-1;i++){
			assertEquals(itd.intervaloData.get(i).puntoMedio(),(double)itd.puntoMedioData.get(i),1e-15);
		}
	}

	@Test
	public void testIncluyePunto() {
		for(int i=0;i<itd.intervaloData.size();i++){
			assertEquals(itd.intervaloData.get(i).incluyePunto(itd.incluyeParamData.get(i)),itd.incluyeData.get(i));
		}
	}

	@Test
	public void testIncluyeIntervalo() {
		for(int i=0;i<itd.intervaloData.size();i++){
			assertEquals(itd.intervaloData.get(i).incluyeIntervalo(itd.incluyeIntervaloData.get(i)),itd.incluyeIntervalo.get(i));
		}
	}

	@Test
	public void testInterseccion() {
		for(int i=0;i<itd.intervaloData.size();i++){
			assertEquals(itd.intervaloData.get(i).interseccion(itd.interseccionParamData.get(i)),itd.interseccion.get(i));
		}
	}

}
