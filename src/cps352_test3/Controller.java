/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cps352_test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author rodo
 */
public class Controller {

    private Model model;
    private View view;

    Controller() {
        this.model = new Model();
        this.view = new View();
    }

    void start() {

        view.getRectangle().addActionListener((ActionEvent e) -> {
            model.setShapeFigure(1);
            view.icon.setShape(model.getShapeFigure());
            view.repaint();
        });
        
        view.getCircle().addActionListener((ActionEvent e) -> {
            model.setShapeFigure(3);
            view.icon.setShape(model.getShapeFigure());
            view.repaint();
        });
        
        view.getTriangle().addActionListener((ActionEvent e) -> {
            model.setShapeFigure(2);
            view.icon.setShape(model.getShapeFigure());
            view.repaint();
        });
        
        view.getRed().addActionListener((ActionEvent e) -> {
            model.setShapeColor(1);
            view.icon.setColor(model.getShapeColor());
            view.repaint();
        });
        
        view.getBlue().addActionListener((ActionEvent e) -> {
            model.setShapeColor(2);
            view.icon.setColor(model.getShapeColor());
            view.repaint();
        });
        
        view.getYellow().addActionListener((ActionEvent e) -> {
            model.setShapeColor(3);
            view.icon.setColor(model.getShapeColor());
            view.repaint();
        });
        
        view.getShapeSize().addChangeListener((ChangeEvent e) ->{
            model.setShapeSize(((JSlider)e.getSource()).getValue());
            view.icon.setSize(model.getShapeSize());
            view.repaint();
        });

    }
}
