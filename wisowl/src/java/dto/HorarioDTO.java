package dto;



public class HorarioDTO {

    private String idUsuario = "";
    private String fecha = "";
    private String hora;
    
 

    @Override
    public String toString() {
        return "HorarioDTO{" + "idUsuario=" + idUsuario + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

    public HorarioDTO() {
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

   }
