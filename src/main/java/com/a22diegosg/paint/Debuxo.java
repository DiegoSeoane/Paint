/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.a22diegosg.paint;

import java.awt.Color;
import java.awt.Shape;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author A22DiegoSG
 */
public class Debuxo implements Serializable {

    public static final String DEFAULT_NAME = "Dibujo.png";
    public static final char LINE_COMMENT = '#';

    private ArrayList<Shape> figuras;
    private String nome;
    private int idDebuxo;

    public Debuxo(String nome, int idDebuxo) {
        this.nome = nome;
        this.idDebuxo = idDebuxo;
    }

    public Debuxo(String nome) {
        figuras = new ArrayList<>();
        this.nome = nome;
    }

    public Debuxo() {
        this(DEFAULT_NAME);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdDebuxo() {
        return idDebuxo;
    }

    public void setIdDebuxo(int idDebuxo) {
        this.idDebuxo = idDebuxo;
    }

    public void clear() {
        if (figuras != null) {
            figuras.clear();
        }
    }

    public ArrayList<Shape> getShapes() {
        return figuras;
    }

    public ArrayList<Color> getColors() {
        ArrayList<Color> cores = new ArrayList<>();
        for (Shape r : figuras) {
            if (r instanceof Ruta ruta) {
                cores.add(ruta.getCor());
            }
        }
        return cores;
    }

    public ArrayList<Integer> getGrosores() {
        ArrayList<Integer> grosores = new ArrayList<>();
        for (Shape r : figuras) {
            if (r instanceof Ruta ruta) {
                grosores.add(ruta.getGrosor());
            }
        }
        return grosores;
    }

    public Shape getShape(int i) {
        if (figuras != null && i >= 0 && i < figuras.size()) {
            return figuras.get(i);
        }
        return null;
    }
    public void addShape (Shape ruta){
        if (figuras != null) {
            figuras.add(ruta);
        }   
    }
    
    public void saveObjectToFile(File f){
        try (ObjectOutputStream oos = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(f)))){
            oos.writeObject(this);
        } catch (IOException ex) {
            System.out.println("Erro de E/S " + ex.getMessage());
        }
    }
    public void loadObjectToFile(File f){
        try (ObjectInputStream oos = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(f)))){
            Debuxo debuxo = (Debuxo) oos.readObject();
            if (debuxo != null) {
                this.nome = debuxo.getNome();
                this.idDebuxo = debuxo.getIdDebuxo();
                figuras.clear();
                figuras.addAll(debuxo.getShapes());
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ó cargar o debuxo: " + ex.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
}
