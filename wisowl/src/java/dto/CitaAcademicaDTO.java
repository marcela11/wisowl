
package dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class CitaAcademicaDTO implements Serializable{
    
    private int idcitaAcademica=0;
    private int idcitaEstado=0;
    private String motivo="";
    private Date fecha;
    private int idEstudiante=0;
    private int idDocente=0;
    private Time hora; 
    
    private UsuarioDTO idUsuario;
    private EstadoCitaDTO idcitaestado;
    
    public CitaAcademicaDTO(UsuarioDTO idEstudiante,UsuarioDTO idDocente,EstadoCitaDTO idcitaEstado){
    this.idUsuario=idEstudiante;
    this.idUsuario=idDocente;
    this.idcitaestado=idcitaEstado;
    
    }

    /**
     * @return the idcitaAcademica
     */
    public int getIdcitaAcademica() {
        return idcitaAcademica;
    }

    /**
     * @param idcitaAcademica the idcitaAcademica to set
     */
    public void setIdcitaAcademica(int idcitaAcademica) {
        this.idcitaAcademica = idcitaAcademica;
    }

    /**
     * @return the idcitaEstado
     */
    public int getIdcitaEstado() {
        return idcitaEstado;
    }

    /**
     * @param idcitaEstado the idcitaEstado to set
     */
    public void setIdcitaEstado(int idcitaEstado) {
        this.idcitaEstado = idcitaEstado;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the idDocente
     */
    public int getIdDocente() {
        return idDocente;
    }

    /**
     * @param idDocente the idDocente to set
     */
    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    /**
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the idUsuario
     */
    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idcitaestado
     */
    public EstadoCitaDTO getIdcitaestado() {
        return idcitaestado;
    }

    /**
     * @param idcitaestado the idcitaestado to set
     */
    public void setIdcitaestado(EstadoCitaDTO idcitaestado) {
        this.idcitaestado = idcitaestado;
    }
    
    
    
}
