package com.example.myapplication.DB.entidades;

public class articulos2 {
    private int codigo;
    private String descripcion;
    private String marca;
    private String color;
    private Float precio;

    public articulos2(int codigo, String descripcion, String marca, String color, Float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
