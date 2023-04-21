/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.a22diegosg.paint;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author A22DiegoSG
 */
public class Ruta extends Path2D.Float implements Serializable {

    public static final Color DEFAULT_COR = new Color(0, 0, 0);
    public static final int DEFAULT_GROSOR = 2;

    private Color cor;
    private int grosor;

    public Ruta(Point puntoInicial, Color cor, int anchura) {
        this.cor = cor;
        this.grosor = anchura;
        moveTo(puntoInicial.x, puntoInicial.y);
    }

    public Ruta(Color cor, int achura) {
        this.cor = cor;
    }

    public Ruta(int anchura) {
        this(DEFAULT_COR, anchura);
    }

    public Ruta(ArrayList<Point> puntos, Color cor, int grosor) {
        this.cor = cor;
        this.grosor = grosor;
        if (!puntos.isEmpty()) {
            moveTo(puntos.get(0).x, puntos.get(0).y);
            for (int i = 1; i < puntos.size(); i++) {
                lineTo(puntos.get(i).x, puntos.get(i).y);
            }
        }
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getGrosor() {
        return grosor;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    public void addPunto(int x, int y) {
        Point2D actual = getCurrentPoint();
        if (actual == null) {
            moveTo(x, y);
        } else {
            lineTo(x, y);
        }
    }

    public void addPunto(Point p) {
    }

    public ArrayList<Point> getPuntos() {
        ArrayList<Point> puntos = new ArrayList<>();
        float[] coords = new float[6];
        PathIterator pathIterator = getPathIterator(new AffineTransform());
        while (!pathIterator.isDone()) {
            switch (pathIterator.currentSegment(coords)) {
                case PathIterator.SEG_MOVETO:
                    puntos.add(new Point((int) coords[0], (int) coords[1]));
                case PathIterator.SEG_LINETO:
                    puntos.add(new Point((int) coords[0], (int) coords[1]));
                case PathIterator.SEG_QUADTO:
                    puntos.add(new Point((int) coords[0], (int) coords[1]));
                case PathIterator.SEG_CUBICTO:
                    puntos.add(new Point((int) coords[0], (int) coords[1]));
                case PathIterator.SEG_CLOSE:
                    System.out.println("cerrar\n");;
            }
            pathIterator.next();
        }
        return puntos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getPuntos()).toString();
    }        
}
