package Pojos;

import java.util.Arrays;
import java.util.Objects;

public class Evaluacion {

    private int id;
    private String[] areas = {"Calendario","Ficha Mascota","Vacunas","Salud","Localizacion","Otros"};


    public Evaluacion()
    {}

    public Evaluacion(int id, String[] areas) {
        this.id = id;
        this.areas = areas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getAreas() {
        return areas;
    }

    public void setAreas(String[] areas) {
        this.areas = areas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evaluacion)) return false;
        Evaluacion that = (Evaluacion) o;
        return getId() == that.getId() && Arrays.equals(getAreas(), that.getAreas());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId());
        result = 31 * result + Arrays.hashCode(getAreas());
        return result;
    }


    @Override
    public String toString() {
        return "Evaluacion{" +
                "id=" + id +
                ", areas=" + Arrays.toString(areas) +
                '}';
    }
}
