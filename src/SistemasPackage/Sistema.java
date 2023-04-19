package SistemasPackage;

public class Sistema {

	final int CANTIDAD_MAXIMA_DE_USUARIOS=3;
	String nombreDelSistema;
	Usuario usuariosRegistrados[];
	Integer contadorDeLogueos;
	Integer contadorDeRegistros;
	Integer cantidadUsuariosBloqueados;
	
	public Sistema() {
		this.nombreDelSistema = "";
		this.usuariosRegistrados= new Usuario[CANTIDAD_MAXIMA_DE_USUARIOS];
		this.contadorDeLogueos=0;
		this.cantidadUsuariosBloqueados=0;
		this.contadorDeRegistros=0;
	}

	public Integer getContadorDeRegistros() {
		return contadorDeRegistros;
	}

	public void setContadorDeRegistros(Integer contadorDeRegistros) {
		this.contadorDeRegistros = contadorDeRegistros;
	}

	public boolean registrarUsuarios(Usuario nuevoUsuario) {
		boolean a=false;
		
		if(nuevoUsuario.contraseniaValida(nuevoUsuario.getContrasenia()) && nuevoUsuario.getNombreDeUsuario()!= "") {
			
			for(int i=0; i<CANTIDAD_MAXIMA_DE_USUARIOS;i++)
			{
				if(usuariosRegistrados[i]!=null && usuariosRegistrados[i].getNombreDeUsuario().equals(nuevoUsuario.getNombreDeUsuario())) {
					return a; //no se puede ingresar un nombre de usuario que ya exista: la prueba
				}
				if(usuariosRegistrados[i]==null && a==false) {
					usuariosRegistrados[i]= nuevoUsuario;
					contadorDeRegistros++;
					a= true;
				}
			}
		};
			
		return a;
	}
	
	public String getNombreDelSistema() {
		return nombreDelSistema;
	}

	public void setNombreDelSistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
	}

	public int getCantidadMaximaDeUsuarios() {
		return CANTIDAD_MAXIMA_DE_USUARIOS;
	}

	public boolean logearUsuario(String nom, String contra) {
		boolean seLogueo=false;
		
		//SE PUEDE HACER CON WHILE ;);)
		
		for(int i=0; i<CANTIDAD_MAXIMA_DE_USUARIOS;i++) {
			if(seLogueo== false && usuariosRegistrados[i].getNombreDeUsuario().equals(nom)) {
				if(usuariosRegistrados[i].getContrasenia().equals(contra)) {
					seLogueo=true;
					contadorDeLogueos++;
					usuariosRegistrados[i].setCantidadContraseniasIncorrectas(0);
				}else if(usuariosRegistrados[i].getCantidadContraseniasIncorrectas()<3){
					Integer cci=usuariosRegistrados[i].getCantidadContraseniasIncorrectas();
					cci++;
					usuariosRegistrados[i].setCantidadContraseniasIncorrectas(cci);
					return seLogueo;
				}else {
					usuariosRegistrados[i].setBloqueado(true);
					cantidadUsuariosBloqueados++;
					return seLogueo;
				}
			}
		}
		return seLogueo;
	}

	public Double promedioUsuariosLogueados() {
		Double promedio = 0.00;
		promedio = (double)((contadorDeLogueos*100)/contadorDeRegistros);
		
		return promedio;
	}
	
	public Double edadPromedio() {
		Double promedio=0.00;
		Integer edadTotal= 0;
		
		for(Integer i=0; i<contadorDeRegistros; i++ ) {
			
			if(usuariosRegistrados[i]!=null) {
				edadTotal+=usuariosRegistrados[i].getEdad();
			}
		}
		
		if(contadorDeRegistros!=0) {
			Double meCanse = (double) (edadTotal/contadorDeRegistros);
			promedio= meCanse;
		}
		
		return promedio;
	}
	
	public Integer getContadorDeLogueos() {
		return contadorDeLogueos;
	}

	public void setContadorDeLogueos(Integer contadorDeLogueos) {
		this.contadorDeLogueos = contadorDeLogueos;
	}

	public Usuario[] getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(Usuario[] usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}

	public Integer getCantidadUsuariosBloqueados() {
		return cantidadUsuariosBloqueados;
	}

	public void setCantidadUsuariosBloqueados(Integer cantidadUsuariosBloqueados) {
		this.cantidadUsuariosBloqueados = cantidadUsuariosBloqueados;
	}


	
	
}
