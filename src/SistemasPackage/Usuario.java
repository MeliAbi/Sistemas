package SistemasPackage;

public class Usuario {
	
	Integer edad;
	String nombreDeUsuario;
	String contrasenia;
	Boolean logueado;
	Boolean bloqueado;
	Integer cantidadContraseniasIncorrectas;
	
	public Usuario() {
		this.edad=0;
		this.nombreDeUsuario="";
		this.contrasenia="";
		this.logueado=false;
		this.bloqueado=false;
		this.cantidadContraseniasIncorrectas=0;
	}


	public boolean contraseniaValida(String contra) {
		Boolean validacion = false;
		Boolean largo = false;
		Boolean num = false;
		Boolean letra = false;
		//+8 carac. && letras y num 
		if(contra.length()>8) {
			largo = true;
			for(int i=0; i<contra.length(); i++) {
				if(contra.charAt(i)>=97 && contra.charAt(i)<=122 && letra==false) {
					letra=true;
				};
				if(contra.charAt(i)>=48 && contra.charAt(i)<=57 && num==false) {
					num=true;
				}
			}
		}
		if(largo&&letra&&num) {
			validacion=true;
		}
		
		return validacion;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}


	public Boolean getLogueado() {
		return logueado;
	}


	public void setLogueado(Boolean logueado) {
		this.logueado = logueado;
	}


	public Boolean getBloqueado() {
		return bloqueado;
	}


	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	public Integer getCantidadContraseniasIncorrectas() {
		return cantidadContraseniasIncorrectas;
	}


	public void setCantidadContraseniasIncorrectas(Integer cantidadContraseniasIncorrectas) {
		this.cantidadContraseniasIncorrectas = cantidadContraseniasIncorrectas;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}

