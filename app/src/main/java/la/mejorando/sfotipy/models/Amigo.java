package la.mejorando.sfotipy.models;

/**
 * Created by thespianartist on 24/09/14.
 */
public class Amigo {

    private String nombre_amigo;
    private String twitter;
    private String ultimaCancion;


    public String getNombre() {
        return nombre_amigo;
    }

    public void setNombre(String nombre) {
        this.nombre_amigo = nombre;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getUltimaCancion() {
        return ultimaCancion;
    }

    public void setUltimaCancion(String ultimaCancion) {
        this.ultimaCancion = ultimaCancion;
    }
}
