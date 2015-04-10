
package dto;

import java.io.Serializable;

public class EstadoCitaDTO implements Serializable{
     private int idestadoCitas=0;
     private String Descripcion="";

    /**
     * @return the idestadoCitas
     */
    public int getIdestadoCitas() {
        return idestadoCitas;
    }

    /**
     * @param idestadoCitas the idestadoCitas to set
     */
    public void setIdestadoCitas(int idestadoCitas) {
        this.idestadoCitas = idestadoCitas;
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
}
