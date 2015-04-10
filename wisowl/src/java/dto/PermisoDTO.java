package dto;

import java.io.Serializable;

public class PermisoDTO implements Serializable {

    private int idPermiso = 0;
    private String descripcion = "";
    private int dPadre =0;

    public PermisoDTO() {
    }

    @Override
    public String toString() {
        return "PermisoDTO{" + "idPermiso=" + idPermiso + ", descripcion=" + descripcion + '}';
    }
    

    /**
     * @return the idPermiso
     */
    public int getIdPermiso() {
        return idPermiso;
    }

    /**
     * @param idPermiso the idPermiso to set
     */
    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
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
     * @return the dPadre
     */
    public int getdPadre() {
        return dPadre;
    }

    /**
     * @param dPadre the dPadre to set
     */
    public void setdPadre(int dPadre) {
        this.dPadre = dPadre;
    }

}
