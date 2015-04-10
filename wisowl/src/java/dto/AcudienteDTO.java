package dto;

import java.io.Serializable;

public class AcudienteDTO implements Serializable {

    private int idAcudiente = 0;
    private String NombreCompleto = "";
    private String email = "";
    private String parentesco = "";
    private int IdEstudiante;

    public AcudienteDTO() {

    }

    /**
     * @return the idAcudiente
     */
    public int getIdAcudiente() {
        return idAcudiente;
    }

    /**
     * @param idAcudiente the idAcudiente to set
     */
    public void setIdAcudiente(int idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    /**
     * @return the NombreCompleto
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    /**
     * @param NombreCompleto the NombreCompleto to set
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
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
     * @return the parentesco
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    /**
     * @return the IdEstudiante
     */
    public int getIdEstudiante() {
        return IdEstudiante;
    }

    /**
     * @param IdEstudiante the IdEstudiante to set
     */
    public void setIdEstudiante(int IdEstudiante) {
        this.IdEstudiante = IdEstudiante;
    }

}
