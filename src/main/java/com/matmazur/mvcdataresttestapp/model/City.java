package com.matmazur.mvcdataresttestapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_city")
    private Long id;
    private String name;
    private Long population;

    public City(String name, Long population) {
        this.name = name;
        this.population = population;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(population, city.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population);
    }


    public static class Builder {

        private String name;
        private Long population;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPopulation(Long population) {
            this.population = population;
            return this;
        }

        public City build() {
            return new City(name, population);
        }
    }
}
