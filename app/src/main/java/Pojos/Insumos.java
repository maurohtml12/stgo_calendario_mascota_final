package Pojos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {

    private int id;
    private String[] marcas = {"Revolution","Bravecto","Advantix","negard","Nexgard","mebermic"};
    private int[] gramos = {5, 7, 3, 3, 7, 5};
    //private int[] extras = {2, 3, 1, 1, 3, 2};

    public Insumos()
    {}

    public Insumos(int id, String[] marcas, int[] gramos, int[] extras) {
        this.id = id;
        this.marcas = marcas;
        this.gramos = gramos;
        //this.extras = extras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getMarcas() {
        return marcas;
    }

    public void setMarcas(String[] marcas) {
        this.marcas = marcas;
    }

    public int[] getGramos() {
        return gramos;
    }

    public void setGramos(int[] gramos) {
        this.gramos = gramos;
    }

    //public int[] getExtras() {
       // return extras;
    //}

    //public void setExtras(int[] extras) {
       // this.extras = extras;
   // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insumos)) return false;
        Insumos insumos = (Insumos) o;
        return getId() == insumos.getId() && Arrays.equals(getMarcas(), insumos.getMarcas()) && Arrays.equals(getGramos(), insumos.getGramos());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId());
        result = 31 * result + Arrays.hashCode(getMarcas());
        result = 31 * result + Arrays.hashCode(getGramos());
       // result = 31 * result + Arrays.hashCode(getExtras());
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", marcas=" + Arrays.toString(marcas) +
                ", gramos=" + Arrays.toString(gramos) +
         //       ", extras=" + Arrays.toString(extras) +
                '}';
    }

    public int anadiradicional(int valor, int adicional){
        return valor + adicional;
    }
}
