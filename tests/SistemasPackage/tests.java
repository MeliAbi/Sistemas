package SistemasPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class tests {
	
	@Test
	public void queSeCreeUnSistema() {
		Sistema nuevo = new Sistema();
		String nombreDelSistema = "Lol";

		nuevo.setNombreDelSistema(nombreDelSistema);
		
		assertEquals(nombreDelSistema,nuevo.getNombreDelSistema());
	}
	
	@Test
	public void seIngresoUsuarioASistema() {
		queSeCreeUnSistema();
		Usuario nuevoUsuario = new Usuario();
		Usuario otroUsuario = new Usuario();
		Sistema nuevoSistema = new Sistema();
		
		Integer edad = 15;
		String nom = "jorgeUwUlol1";
		String contra = "jorgeContra1";
		
		Integer edad2 = 15;				//no se puede ingresar un nombre de usuario que ya exista: la prueba
		String nom2 = "jorgeUwUlol";
		String contra2 = "jorgeContra1";
		
		nuevoUsuario.setEdad(edad);
		nuevoUsuario.setNombreDeUsuario(nom);
		nuevoUsuario.setContrasenia(contra);
		
		otroUsuario.setEdad(edad2);
		otroUsuario.setNombreDeUsuario(nom2);
		otroUsuario.setContrasenia(contra2);
		
		/*if(nuevoUsuario.contraseniaValida(contra)) {
			nuevoUsuario.setContrasenia(contra);
			assertTrue(nuevoSistema.registrarUsuarios(nuevoUsuario));
		};*/
		
		assertTrue(nuevoSistema.registrarUsuarios(nuevoUsuario));//valida contraseña registrarUsuarios
		assertTrue(nuevoSistema.registrarUsuarios(otroUsuario));
	}
	
	@Test
	public void validarContrasenia() {
		
		Usuario nuevoUsuario = new Usuario();
		String contra = "fideos123456790";
		
		assertTrue(nuevoUsuario.contraseniaValida(contra));
		
	}

	@Test
	public void queSeLogueeUsuario() {
		Usuario nuevoUsuario = new Usuario();
		Sistema nuevoSistema = new Sistema();
		
		Integer edad = 15;
		Integer a=0;
		Integer b=1;
		String nom = "jorgeUwUlol";
		String contra = "jorgeContra1";
		
		nuevoUsuario.setEdad(edad);
		nuevoUsuario.setNombreDeUsuario(nom);
		nuevoUsuario.setContrasenia(contra);
		nuevoSistema.registrarUsuarios(nuevoUsuario);
		
		//;
		assertEquals(a,nuevoSistema.getContadorDeLogueos());
		nuevoUsuario.setLogueado(nuevoSistema.logearUsuario(nom,contra));
		assertTrue(nuevoUsuario.isLogueado());
		assertEquals(b,nuevoSistema.getContadorDeLogueos());
		
	}
	
	@Test
	public void seBloqueoUsuario(){
		Usuario pedro = new Usuario();
		Sistema nuevoSistema = new Sistema();
		Integer a=1;
		pedro.setContrasenia("casaca12345678");
		pedro.setNombreDeUsuario("PedroPascal");
		
		nuevoSistema.registrarUsuarios(pedro);
		nuevoSistema.logearUsuario(pedro.getNombreDeUsuario(), "mandarina1");
		nuevoSistema.logearUsuario(pedro.getNombreDeUsuario(), "mandarina2");
		nuevoSistema.logearUsuario(pedro.getNombreDeUsuario(), "mandarina3");
		nuevoSistema.logearUsuario(pedro.getNombreDeUsuario(), "mandarina14");
		
		assertTrue(pedro.getBloqueado());
		assertEquals(a,nuevoSistema.getCantidadUsuariosBloqueados());
	}
	
	@Test
	public void seCalculaLaEdadPromedio() {
		Sistema nuevoSistema = new Sistema();
		Usuario facu = new Usuario();
		Usuario ishigod = new Usuario();
		
		facu.setEdad(14);
		facu.setNombreDeUsuario("FacuA");
		facu.setContrasenia("ASksjd3891432");
		
		ishigod.setEdad(16);
		ishigod.setNombreDeUsuario("FacuB");
		ishigod.setContrasenia("ASksjd3891432");
		
		nuevoSistema.registrarUsuarios(ishigod);
		nuevoSistema.registrarUsuarios(facu);
		
		Double a = 15.0;
		
		assertEquals(a,nuevoSistema.edadPromedio());
		
	}
	
}
