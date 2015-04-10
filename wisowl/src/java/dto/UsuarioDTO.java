package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private String idUsuario;
    private String primerNombre = "";
    private String segundoNombre = "";
    private String primerApellido = "";
    private String segundoApellido = "";
    private String email = "";
    private String direccion = "";
    private String contraseña = "";
    private int eps = 0;
    private boolean estado = true;
    private int idRol = 0;
    private int idcursos;
    private int idTelefono;
    private int idAcudientes;
    private AcudienteDTO idAcudiente;

    public UsuarioDTO(AcudienteDTO idAcudientes) {
        this.idAcudiente = idAcudientes;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(String id, String nom) {
        this.idUsuario = id;
        this.primerNombre = nom;
    }
    private TelefonoDTO idTelefonos;
    private EpsDTO idEPS;
    private RolDTO idrol;
    private CursoDTO idCurso;

    public UsuarioDTO(EpsDTO eps, RolDTO idRol, CursoDTO idcursos) {
        this.idEPS = eps;
        this.idrol = idRol;
        this.idCurso = idcursos;
    }

    public UsuarioDTO(EpsDTO eps, TelefonoDTO idTelefono) {
        this.idEPS = eps;
        this.idTelefonos = idTelefono;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idUsuario=" + idUsuario + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", email=" + email + ", direccion=" + direccion + ", contrase\u00f1a=" + contraseña + ", eps=" + eps + ", estado=" + estado + ", idRol=" + idRol + ", idcursos=" + idcursos + ", idEPS=" + idEPS + ", idrol=" + idrol + ", idCurso=" + idCurso + '}';
    }

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the primerNombre
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @param primerNombre the primerNombre to set
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @return the segundoNombre
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * @param segundoNombre the segundoNombre to set
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the eps
     */
    public int getEps() {
        return eps;
    }

    /**
     * @param eps the eps to set
     */
    public void setEps(int eps) {
        this.eps = eps;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the idEPS
     */
    public EpsDTO getIdEPS() {
        return idEPS;
    }

    /**
     * @param idEPS the idEPS to set
     */
    public void setIdEPS(EpsDTO idEPS) {
        this.idEPS = idEPS;
    }

    /**
     * @return the idrol
     */
    public RolDTO getIdrol() {
        return idrol;
    }

    /**
     * @param idrol the idrol to set
     */
    public void setIdrol(RolDTO idrol) {
        this.idrol = idrol;
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the idcursos
     */
    public int getIdcursos() {
        return idcursos;
    }

    /**
     * @param idcursos the idcursos to set
     */
    public void setIdcursos(int idcursos) {
        this.idcursos = idcursos;
    }

    /**
     * @return the idCurso
     */
    public CursoDTO getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(CursoDTO idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the idTelefono
     */
    public int getIdTelefono() {
        return idTelefono;
    }

    /**
     * @param idTelefono the idTelefono to set
     */
    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    /**
     * @return the idTelefonos
     */
    public TelefonoDTO getIdTelefonos() {
        return idTelefonos;
    }

    /**
     * @param idTelefonos the idTelefonos to set
     */
    public void setIdTelefonos(TelefonoDTO idTelefonos) {
        this.idTelefonos = idTelefonos;
    }

    /**
     * @return the idAcudientes
     */
    public int getIdAcudientes() {
        return idAcudientes;
    }

    /**
     * @param idAcudientes the idAcudientes to set
     */
    public void setIdAcudientes(int idAcudientes) {
        this.idAcudientes = idAcudientes;
    }

    /**
     * @return the idAcudiente
     */
    public AcudienteDTO getIdAcudiente() {
        return idAcudiente;
    }

    /**
     * @param idAcudiente the idAcudiente to set
     */
    public void setIdAcudiente(AcudienteDTO idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

}
