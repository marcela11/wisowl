package dto;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable {

    private int idAsignaturas = 0;
    private String descripcion = "";
    private int idArea = 0;
    private long idDocente = 0;
    private int idCursos = 0;

    private CursoDTO idCurso;
    private AreaDTO IdArea;

    public AsignaturaDTO(CursoDTO idCursos, AreaDTO idArea) {
        this.idCurso = idCursos;
        this.IdArea = idArea;
    }

    public AsignaturaDTO() {
    }

    /**
     * @return the idAsignaturas
     */
    public int getIdAsignaturas() {
        return idAsignaturas;
    }

    /**
     * @param idAsignaturas the idAsignaturas to set
     */
    public void setIdAsignaturas(int idAsignaturas) {
        this.idAsignaturas = idAsignaturas;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idArea
     */
    public int getIdArea() {
        return idArea;
    }

    /**
     * @param idArea the idArea to set
     */
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    /**
     * @return the idDocente
     */
    public long getIdDocente() {
        return idDocente;
    }

    /**
     * @param idDocente the idDocente to set
     */
    public void setIdDocente(long idDocente) {
        this.idDocente = idDocente;
    }

    /**
     * @return the idCurso
     */
    public int getIdCursos() {
        return idCursos;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.setIdCursos(idCursos);
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
     * @param idCursos the idCursos to set
     */
    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    /**
     * @param IdArea the IdArea to set
     */
    public void setIdArea(AreaDTO IdArea) {
        this.IdArea = IdArea;
    }

}
