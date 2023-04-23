/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.a22diegosg.paint;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class PaintController {

    private final Debuxo modelo;
    private Lienzo vista;

    public PaintController(Debuxo modelo) {
        this.modelo = modelo;
        vista = new Lienzo(this);
    }
    public void setNome(String nome){
        if (modelo != null) {
            modelo.setNome(nome);
        }
    }
    public String getNome(){
        if (modelo != null) {
            modelo.getNome();
        }
        return "";
    }
    public void addShape (Shape shape){
        modelo.addShape(shape);
    }
    public void addShape(ArrayList<Point> puntos, Color cor, int grosor){
        modelo.addShape(puntos, cor, grosor);
    }
    public ArrayList<Shape> getShape(){
        return modelo.getShapes();
    }
    public ArrayList<Integer> getGrosores(){
        return modelo.getGrosores();
    }
    public ArrayList<Color> getCores(){
        return modelo.getColors();
    }
    public void saveDebuxe(File f){
        if (modelo != null) {
            modelo.saveObjectToFile(f);
        }
    }
    public Lienzo getVista(){
        return vista;
    }
    public void clear(){
        if (modelo != null) {
            modelo.clear();
        }
    }
    public void loadDebuxoFromFile(File f){
        modelo.loadDebuxoFromFile(f);
    }
    public void saveDebucoToFile(File f){
        if (modelo != null) {
            modelo.saveObjectToFile(f);
        }
    }
}
