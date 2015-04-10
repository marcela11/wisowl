package dto;

public class RolDTO {

    private int idrol = 0;
    private String Descripcion = "";
    private int idPermiso = 0;
    PermisoDTO idPer;

    @Override
    public String toString() {
        return "RolDTO{" + "idrol=" + idrol + ", Descripcion=" + Descripcion + ", idPermiso=" + idPermiso + ", idPer=" + idPer + '}';
    }

    public RolDTO() {
    }

    public RolDTO(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    /**
     * @return the idrol
     */
    public int getIdrol() {
        return idrol;
    }

    /**
     * @param idrol the idrol to set
     */
    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
}
