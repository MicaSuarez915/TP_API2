package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="unidades_tabla")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="id", nullable=false)
    private int id;
    private int piso;
    private int numeroUnidad;
    private boolean habitada;
    private boolean alquilada;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @ManyToOne
    @JoinColumn(name = "dueño_id")
    private Duenio duenio;
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Inquilino> inquilinos = new ArrayList<Inquilino>();
    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<Reclamo>reclamos = new ArrayList<Reclamo>();


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

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public void getInquilinos(){
        for(Inquilino i: inquilinos) {
            i.toString();
        }
    }

    public void addInquilinos(Inquilino i) {
        this.inquilinos.add(i);
    }

    public void getReclamos() {
        for(Reclamo r: reclamos) {
            r.toString();
        }
    }

    public void agregarReclamo(Reclamo reclamo1) {
        this.reclamos.add(reclamo1);
    }


}
