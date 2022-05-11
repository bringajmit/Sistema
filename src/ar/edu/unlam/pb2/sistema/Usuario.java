package ar.edu.unlam.pb2.sistema;

public class Usuario {

	private String nombre;
	private Integer dni;
	private String contrase�a;
	private Estado estado;

	public Usuario(String nombre, Integer dni) {
		this.nombre=nombre;
		this.dni=dni;
		estado=estado.DESCONOCIDO;
	}
	
	public Usuario(String nombre, Integer dni, String contrase�a) {
		this.nombre=nombre;
		this.dni=dni;
		this.contrase�a=contrase�a;
		estado=estado.DESCONOCIDO;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrase�a == null) ? 0 : contrase�a.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contrase�a == null) {
			if (other.contrase�a != null)
				return false;
		} else if (!contrase�a.equals(other.contrase�a))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (estado != other.estado)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/*@Override
	public int compareTo(Usuario o) {
		if(this.dni.compareTo(o.getDni())==0){
			return this.dni.compareTo(o.getDni());
		}
		return this.nombre.compareTo(o.getNombre());
	}*/
	
	

}
