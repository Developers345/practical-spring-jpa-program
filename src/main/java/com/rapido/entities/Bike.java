package com.rapido.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bike")
@NamedQuery(
        name = "getBikes",
        query = "from Bike"
)
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bike_no")
    protected int bikeNo;
    @Column(name = "bike_name")
    protected String bikeName;
    @Column(name = "bike_color")
    protected String bikeColor;
    @Column(name = "bike_model")
    protected String bikeModel;

    public Bike() {
    }

    public int getBikeNo() {
        return bikeNo;
    }

    public void setBikeNo(int bikeNo) {
        this.bikeNo = bikeNo;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBikeColor() {
        return bikeColor;
    }

    public void setBikeColor(String bikeColor) {
        this.bikeColor = bikeColor;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeNo=" + bikeNo +
                ", bikeName='" + bikeName + '\'' +
                ", bikeColor='" + bikeColor + '\'' +
                ", bikeModel='" + bikeModel + '\'' +
                '}';
    }
}
