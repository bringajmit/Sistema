package ar.edu.unlam.pb2.sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class testSistema {

	/*Sistema
a. Desarrolle un constructor de la clase Sistema que cumpla con la siguiente firma:
public Sistema(String nombreDelSistema, int cantidadMaximaDeUsuarios) 

	 * b. Desarrolle un método en la clase Sistema que le permita incorporar un usuario a
su lista de usuarios. Dicho método devolverá true si el usuario se puede ingresar
en el sistema o false en caso contrario (no se puede ingresar un nombre de
usuario que ya exista).
public boolean ingresarUsuario (Usuario nuevoUsuario)*/
	
	@Test
	public void testQueSePuedaIngresarUnNuevoUsuario() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186);
		sistema.ingresarUsuario(juan);
		
		assertTrue(sistema.getUsuarios().contains(juan));
	}
	
	@Test
	public void testQueNoSePuedaIngresarUnNuevoUsuarioRepetido() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186);
		sistema.ingresarUsuario(juan);
		
		assertTrue(sistema.getUsuarios().contains(juan));
		assertFalse(sistema.ingresarUsuario(juan));
	}

	//c. Desarrolle el método calcularLaCantidadDeUsuariosEnSistema. 

	@Test
	public void testQueIndiqueCantidadDeUsuariosEnSistema() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186);
		Usuario u=new Usuario("Usuario", 1186);
		Usuario u2=new Usuario("Usuario2", 81186);
		Usuario u3=new Usuario("Usuario3", 1286);
		Usuario u4=new Usuario("Usuario4", 82186);
		Usuario u5=new Usuario("Usuario5", 83186);
		sistema.ingresarUsuario(juan);
		sistema.ingresarUsuario(u);
		sistema.ingresarUsuario(u2);
		sistema.ingresarUsuario(u3);
		sistema.ingresarUsuario(u4);
		sistema.ingresarUsuario(u5);
		
		Integer obtenido=sistema.getCantidadDeUsuariosEnSistema();
		Integer deseado=5;
		
		assertEquals(obtenido,deseado);
	}
	
	//d. Desarrolle el método calcularLaCantidadDeUsuariosBloqueados. 

	@Test
	public void testQueIndiqueCantidadDeUsuariosDesconectados() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186);
		Usuario u=new Usuario("Usuario", 1186);
		Usuario u2=new Usuario("Usuario2", 81186);
		Usuario u3=new Usuario("Usuario", 1186);
		Usuario u4=new Usuario("Usuario2", 81186);
		sistema.ingresarUsuario(juan);
		sistema.ingresarUsuario(u);
		sistema.ingresarUsuario(u2);
		sistema.ingresarUsuario(u3);
		sistema.ingresarUsuario(u4);
		
		Integer obtenido=sistema.getCantidadDeUsuariosDesconectados();
		Integer deseado=2;
		
		
		assertEquals(obtenido,deseado);
		
	}
	
	//e. Desarrolle el método calcularElPorcentajeDeUsuariosLogueados. 
	
	@Test
	public void testQueIndiqueElPorcentajeDeUsuariosEnSistema() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186);
		Usuario u=new Usuario("Usuario", 1186);
		Usuario u2=new Usuario("Usuario2", 81186);
		sistema.ingresarUsuario(juan);
		sistema.ingresarUsuario(u);
		sistema.ingresarUsuario(u2);
		
		
		double obtenido=sistema.calcularPorcentajeDeUsuariosEnSistema();
		double esperado=60.0;
		
		assertEquals(obtenido,esperado,0.01);
		
		
	}
	
	@Test
	public void testQueSePuedaLoguearUnNuevoUsuario() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186, "sacapuntas");
		sistema.ingresarUsuario(juan);
		
		assertTrue(sistema.loguearUsuario(juan.getNombre(), juan.getContraseña()));
	}
	
	
	@Test
	public void testQueNoSePuedaLoguearUnNuevoUsuarioConContraseñaIncorrecta() {
		
		Sistema sistema=new Sistema("Juanistation", 5);
		Usuario juan=new Usuario("Juan", 31981186, "sacapuntas");
		sistema.ingresarUsuario(juan);
		
		assertFalse(sistema.loguearUsuario(juan.getNombre(), "chirimbolo"));
	}
	
	
	
}
