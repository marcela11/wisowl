package dto;

import java.io.Serializable;

public class AsigPerDTO implements Serializable {

    private int idAsigPer = 0;
    private int idAsig = 0;
    private int idPer = 0;

    private PeriodoDTO idPeriodo;
    private AsignaturaDTO idAsignatura;

    public AsigPerDTO() {
    }

    public AsigPerDTO(PeriodoDTO idPer, AsignaturaDTO idAsig) {
        this.idPeriodo = idPer;
        this.idAsignatura = idAsig;
    }

    /**
     * @return the idAsigPer
     */
    public int getIdAsigPer() {
        return idAsigPer;
    }

    /**
     * @param idAsigPer the idAsigPer to set
     */
    public void setIdAsigPer(int idAsigPer) {
        this.idAsigPer = idAsigPer;
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
     * @return the idPer
     */
    public int getIdPer() {
        return idPer;
    }

    /**
     * @param idPer the idPer to set
     */
    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }

    /**
     * @return the idPeriodo
     */
    public PeriodoDTO getIdPeriodo() {
        return idPeriodo;
    }

    /**
     * @param idPeriodo the idPeriodo to set
     */
    public void setIdPeriodo(PeriodoDTO idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    /**
     * @return the idAsignatura
     */
    public AsignaturaDTO getIdAsignatura() {
        return idAsignatura;
    }

    /**
     * @param idAsignatura the idAsignatura to set
     */
    public void setIdAsignatura(AsignaturaDTO idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

}
