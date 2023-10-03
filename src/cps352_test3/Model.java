/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cps352_test3;

/**
 *
 * @author rodo
 */
public class Model {
    
    private int shapeSize;
    private int shapeFigure; // 1 Rectangle, 2 Triangle, 3 Circle
    private int shapeColor; // 1 Red,       2 Blue,     3 Yellow
    
    Model(){
        this.shapeSize = 20;
        this.shapeFigure = 1;
        this.shapeColor = 1;
    }

    public int getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(int shapeSize) {
        this.shapeSize = shapeSize;
    }

    public int getShapeFigure() {
        return shapeFigure;
    }

    public void setShapeFigure(int shapeFigure) {
        this.shapeFigure = shapeFigure;
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int shapeColor) {
        this.shapeColor = shapeColor;
    }
}
