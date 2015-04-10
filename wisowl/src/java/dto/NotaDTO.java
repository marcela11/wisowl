package dto;

import java.io.Serializable;
import java.util.Date;


public class NotaDTO implements Serializable {

    private int idNota = 0;
    private String fechaNota;
    private float nota1 = 0;
    private float nota2 = 0;
    private float nota3 = 0;
    private String idEstu ;
    private int idAsigPe=0;
    private int idAsig = 0;
    private float total = 0;
    private String observacion ;
    private AsignaturaDTO idAsigna;
private UsuarioDTO idEstudiante;

    public NotaDTO() {
    }
    
    public NotaDTO(AsignaturaDTO idAsig) {
            this.idAsigna=idAsig;
    }

    public NotaDTO(UsuarioDTO idEstu) {
        this.idEstudiante=idEstu;
    }
   

    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    /**
     * @return the fechaNota
     */
    public String getFechaNota() {
        return fechaNota;
    }

    /**
     * @param fechaNota the fechaNota to set
     */
    public void setFechaNota(String fechaNota) {
        this.fechaNota = fechaNota;
    }

    /**
     * @return the nota1
     */
    public float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the nota3
     */
    public float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    /**
     * @return the idEstu
     */
    public String getIdEstu() {
        return idEstu;
    }

    /**
     * @param idEstu the idEstu to set
     */
    public void setIdEstu(String idEstu) {
        this.idEstu = idEstu;
    }

  

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the idAsig
     */
    public int getIdAsig() {
        return idAsig;
    }

    /**
     * @param idAsig the idAsig to set
     */
    public void setIdAsig(int idAsig) {
        this.idAsig = idAsig;
    }

    /**
     * @return the idAsigna
     */
    public AsignaturaDTO getIdAsigna() {
        return idAsigna;
    }

    /**
     * @param idAsigna the idAsigna to set
     */
    public void setIdAsigna(AsignaturaDTO idAsigna) {
        this.idAsigna = idAsigna;
    }

    /**
     * @return the AsignPe
     */
    public int getIdAsigPe() {
        return idAsigPe;
    }

    /**
     * @param AsignPe the AsignPe to set
     */
    public void setAsignPe(int AsignPe) {
        this.setIdAsigPe(AsignPe);
    }

    @Override
    public String toString() {
        return "NotaDTO " + "idNota=" 
                + ", fechaNota=" + fechaNota
                + ", nota1=" + nota1
                + ", nota2=" + nota2
                + ", nota3=" + nota3
                + ", idEstu=" + idEstudiante.getPrimerApellido()
                + ", idAsigPe=" + idAsigPe
                + ", idAsig=" + idAsig
                + ", total=" + total
                + ", observacion=" + observacion;
    }

    /**
     * @param idAsigPe the idAsigPe to set
     */
    public void setIdAsigPe(int idAsigPe) {
        this.idAsigPe = idAsigPe;
    }

    /**
     * @return the idEstudiante
     */
    public UsuarioDTO getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(UsuarioDTO idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    

}
