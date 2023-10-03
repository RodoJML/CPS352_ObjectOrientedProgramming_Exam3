/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cps352_test3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author rodo
 */
public class View extends JFrame {

    private JButton rectangle, triangle, circle, red, blue, yellow;
    private JSlider shapeSize;
    private JLabel shapeContainer;
    public CustomIcon icon;
    
    View() {
        this.icon = new CustomIcon();

        // JFrame general settings ---------------------------------------------
        super.setTitle("OOP Test3");
        Container content = getContentPane();
        content.setLayout(new BorderLayout());

        // Instantiating buttons -----------------------------------------------
        rectangle = new JButton("Rectangle");
        triangle = new JButton("Triangle");
        circle = new JButton("Circle");
        red = new JButton("RED");
        blue = new JButton("BLUE");
        yellow = new JButton("YELLOW");
        
        // Setting up the JSlider ----------------------------------------------
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel(20, 0, 20, 150);
        Hashtable position = new Hashtable();
        
        for (int i = 20; i <= 150; i = i + 10) 
            position.put(i, new JLabel("" + i));
        
        shapeSize = new JSlider(dbrm);
        shapeSize.setOrientation(JSlider.VERTICAL);
        shapeSize.setMajorTickSpacing(10);
        shapeSize.setMinorTickSpacing(5);
        shapeSize.setPaintTicks(true);
        shapeSize.setLabelTable(position);
        shapeSize.setPaintLabels(true);
        
        // Arraging buttons into separate panels 
        JPanel northButtons = new JPanel(new FlowLayout());
        northButtons.add(rectangle);
        northButtons.add(triangle);
        northButtons.add(circle);

        JPanel southButtons = new JPanel(new FlowLayout());
        southButtons.add(red);
        southButtons.add(blue);
        southButtons.add(yellow);
        
        // TBD Figure goes here! 
        shapeContainer = new JLabel(this.icon);
        
        // Additional JFrame settings ------------------------------------------
        content.add(northButtons, BorderLayout.NORTH);
        content.add(southButtons, BorderLayout.SOUTH);
        content.add(shapeSize, BorderLayout.WEST);
        content.add(shapeContainer, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400, 600);
    }
    
    public JButton getRectangle() {
        return rectangle;
    }

    public JButton getTriangle() {
        return triangle;
    }

    public JButton getCircle() {
        return circle;
    }

    public JButton getRed() {
        return red;
    }

    public JButton getBlue() {
        return blue;
    }

    public JButton getYellow() {
        return yellow;
    }

    public JSlider getShapeSize() {
        return shapeSize;
    }

    public JLabel getShapeContainer() {
        return shapeContainer;
    }
}

class CustomIcon implements Icon {
    
    private int size;
    private int shape;
    private int color;
    
    CustomIcon(){
        this.shape = 1;
        this.color = 1;
        this.size = 20;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        
        Graphics2D graphic = (Graphics2D) g;
        
        switch(this.color){
            case 1:
                graphic.setColor(Color.RED);
                break;
            case 2:
                graphic.setColor(Color.BLUE);
                break;
            case 3:
                graphic.setColor(Color.YELLOW);
                break;
        }
        
        switch(this.shape){
            case 1:
                Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, size, size);
                graphic.fill(rectangle);
                break;
            case 2:
                Triangle_Shape triangleShape = new Triangle_Shape(
                        new Point2D.Double((size / 2) + x , 0 + y),
                        new Point2D.Double(size + x, size + y), 
                        new Point2D.Double(0 + x, size + y));
                graphic.fill(triangleShape);
                break;
                // Triangle here
            case 3:
                Ellipse2D.Double circle = new Ellipse2D.Double(x, y, size, size);
                graphic.fill(circle);
                break;
        }
    }

    @Override
    public int getIconWidth() {
        return this.size;
    }

    @Override
    public int getIconHeight() {
        return this.size;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


class Triangle_Shape extends Path2D.Double {
    public Triangle_Shape(Point2D... points) {
        
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        
        closePath();
    }
}