package ar.edu.unlam.pb2.sistema;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sistema {

	private String nombre;
	private Integer cantidadMaximaDeUsuario;
	private Set<Usuario> usuarios;
	private Integer cantidadDeUsuariosEnSistema;
	private Integer cantidadDeUsuariosEstadoDesconectado;

	public Sistema(String nombre, Integer cantidadMaximaDeUsuarios) {
		cantidadDeUsuariosEnSistema=0;
		cantidadDeUsuariosEstadoDesconectado=0;
		this.nombre=nombre;
		this.cantidadMaximaDeUsuario=cantidadMaximaDeUsuarios;
		usuarios=new HashSet<Usuario>();
	}

	public boolean ingresarUsuario(Usuario usuario) {
		for (Usuario u : usuarios) {
			if(u.getDni().equals(usuario.getDni()) || cantidadDeUsuariosEnSistema>=getCantidadMaximaDeUsuario()  ) {
				cantidadDeUsuariosEstadoDesconectado++;
				usuario.setEstado(Estado.EN_SISTEMA);
				return false;
			}
		}	
		cantidadDeUsuariosEnSistema++;
		return usuarios.add(usuario);
		
	}
	
	public Double calcularPorcentajeDeUsuariosEnSistema() {
		Double porcentaje=0.0;
		
		porcentaje=cantidadDeUsuariosEnSistema*100.0/cantidadMaximaDeUsuario;
		
		return porcentaje;		
	}

	//f. En la clase Sistema desarrolle el método loguearUsuario, el cual devolverá true si
		//se logra loguear al usuario y false en caso contrario:
			//public boolean loguearUsuario (String usuario, String contraseña) 
	
	public boolean loguearUsuario (String usuario, String contraseña) {
		boolean loguearUsuario=false;
		for (Usuario u : usuarios) {
			//if(u.getEstado()==Estado.EN_SISTEMA) {
				if(u.getNombre()==usuario &&  u.getContraseña().equals(contraseña)) {
					u.setEstado(Estado.LOGUEADO);
					loguearUsuario= true;
				//}
			}
		}
		
		
		return loguearUsuario;
		
	}
	
	
	
	public Integer getCantidadDeUsuariosDesconectados() {
		return cantidadDeUsuariosEstadoDesconectado;
	}

	public void setCantidadDeUsuariosDesconectados(Integer cantidadDeUsuariosDesconectados) {
		this.cantidadDeUsuariosEstadoDesconectado = cantidadDeUsuariosDesconectados;
	}

	public Integer getCantidadDeUsuariosEnSistema() {
		return cantidadDeUsuariosEnSistema;
	}

	public void setCantidadDeUsuariosEnSistema(Integer cantidadDeUsuariosEnSistema) {
		this.cantidadDeUsuariosEnSistema = cantidadDeUsuariosEnSistema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadMaximaDeUsuario() {
		return cantidadMaximaDeUsuario;
	}

	public void setCantidadMaximaDeUsuario(Integer cantidadMaximaDeUsuario) {
		this.cantidadMaximaDeUsuario = cantidadMaximaDeUsuario;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}
