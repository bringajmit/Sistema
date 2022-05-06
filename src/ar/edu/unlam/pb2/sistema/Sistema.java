package ar.edu.unlam.pb2.sistema;

import java.util.Set;
import java.util.TreeSet;

public class Sistema {

	private String nombre;
	private Integer cantidadMaximaDeUsuario;
	private Set<Usuario> usuarios;
	private Integer cantidadDeUsuariosLogueados;
	private Integer cantidadDeUsuariosBloqueados;

	public Sistema(String nombre, Integer cantidadMaximaDeUsuarios) {
		cantidadDeUsuariosLogueados=0;
		cantidadDeUsuariosBloqueados=0;
		this.nombre=nombre;
		this.cantidadMaximaDeUsuario=cantidadMaximaDeUsuarios;
		usuarios=new TreeSet<Usuario>();
	}

	public boolean ingresarUsuario(Usuario usuario) {
		for (Usuario u : usuarios) {
			if(u.getDni().equals(usuario.getDni()) || cantidadDeUsuariosLogueados>=getCantidadMaximaDeUsuario()  ) {
				cantidadDeUsuariosBloqueados++;
				return false;
			}
		}	
		cantidadDeUsuariosLogueados++;
		return usuarios.add(usuario);
		
	}
	
	public Double calcularPorcentajeDeLogueados() {
		Double porcentaje=0.0;
		
		porcentaje=cantidadDeUsuariosLogueados*100.0/cantidadMaximaDeUsuario;
		
		return porcentaje;		
	}

	public Integer getCantidadDeUsuariosBloqueados() {
		return cantidadDeUsuariosBloqueados;
	}

	public void setCantidadDeUsuariosBloqueados(Integer cantidadDeUsuariosBloqueados) {
		this.cantidadDeUsuariosBloqueados = cantidadDeUsuariosBloqueados;
	}

	public Integer getCantidadDeUsuariosLogueados() {
		return cantidadDeUsuariosLogueados;
	}

	public void setCantidadDeUsuariosLogueados(Integer cantidadDeUsuariosLogueados) {
		this.cantidadDeUsuariosLogueados = cantidadDeUsuariosLogueados;
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
