package model;

import javax.persistence.*;

@Entity
@Table(name="unidades_tabla")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="id", nullable=false)
    private int piso;
    private int numeroUnidad;
    private boolean habitada;
    private boolean alquilada;


    public Unidad(int piso, int numeroUnidad, boolean habitada, boolean alquilada) {
        super();
        this.piso = piso;
        this.numeroUnidad = numeroUnidad;
        this.habitada = habitada;
        this.alquilada = alquilada;
    }

    @Override
    public String toString() {
        return "Unidad [piso=" + piso + ", numeroUnidad=" + numeroUnidad + "]";
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(int numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }


    public boolean isHabitada() { return habitada; }

    public void setHabitada(boolean habitada) { this.habitada = habitada; }

    public boolean isAlquilada() { return alquilada; }

    public void setAlquilada(boolean alquilada) { this.alquilada = alquilada; }
}
