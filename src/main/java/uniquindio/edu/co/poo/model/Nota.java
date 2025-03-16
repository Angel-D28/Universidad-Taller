package uniquindio.edu.co.poo.model;

public class Nota {
    public String nombreNota;
    float valor;

    public Nota(String nombreNota, float valor) {
        this.nombreNota = nombreNota;
        this.valor = valor;
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombreNota) {
        this.nombreNota = nombreNota;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
