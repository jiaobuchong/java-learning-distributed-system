package com.jiaobuchong.springboot.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.tennis")
public class TennisProperties {
    private String color;

    private double price;

    private int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Tennis{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
