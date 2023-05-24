package sk.stuba.fei.uim.oop.application;

import com.sun.tools.javac.Main;
import sk.stuba.fei.uim.oop.shapes.Circle;
import sk.stuba.fei.uim.oop.shapes.Hourglass;
import sk.stuba.fei.uim.oop.shapes.Path;
import sk.stuba.fei.uim.oop.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class MainLogic implements MouseMotionListener, MouseListener {

    private JPanel mainPanel;
    private JPanel sideMenu;
    private JPanel sidePanel;
    private JSlider spacing;
    private JSlider radius;
    private JSlider length;
    private int skipper = 1;
    private JComboBox shape;
    private Path currentPath;
    private Circle currentCircle;
    private Square currentSquare;
    private Hourglass currentHourglass;
    private ArrayList<Path> listOfPaths = new ArrayList<>();
    private ArrayList<Circle> listOfCircles = new ArrayList<>();
    private ArrayList<Square> listOfSquares = new ArrayList<>();
    private ArrayList<Hourglass> listOfHourglasses = new ArrayList<>();
    private String currentShape = "Circle";
    private int r = 255;
    private Color color = new Color(r,0,0);

    public MainLogic(){
        JFrame frame = new JFrame("Zadanie");
        frame.setSize(800, 800);
        frame.setResizable(false);


        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Path path:listOfPaths) {
                    path.draw(g);
                }
                for (Circle circle:listOfCircles) {
                    circle.draw(g, radius.getValue());
                }
                for (Square square:listOfSquares) {
                    square.draw(g, radius.getValue());
                }
                for (Hourglass hourglass:listOfHourglasses) {
                    hourglass.draw(g, radius.getValue());
                }
            }
        };
        mainPanel.setBackground(Color.GRAY);
        mainPanel.addMouseListener(this);
        mainPanel.addMouseMotionListener(this);

        sideMenu = new JPanel(new GridLayout(1,3));

        String shapes[] = {"Circle", "Square", "Hourglass"};
        shape = new JComboBox<>(shapes);

        sidePanel = new JPanel(new BorderLayout());
        length = new JSlider(JSlider.VERTICAL,20, 200, 50);
        length.setMinorTickSpacing(10);
        length.setMajorTickSpacing(10);
        length.setPaintTicks(true);
        length.setSnapToTicks(true);
        length.setPaintLabels(true);


        spacing = new JSlider(JSlider.VERTICAL,1, 20, 5);
        spacing.setMinorTickSpacing(1);
        spacing.setMajorTickSpacing(1);
        spacing.setPaintTicks(true);
        spacing.setSnapToTicks(true);
        spacing.setPaintLabels(true);


        radius = new JSlider(JSlider.VERTICAL,1, 20, 5);
        radius.setMinorTickSpacing(1);
        radius.setMajorTickSpacing(1);
        radius.setPaintTicks(true);
        radius.setSnapToTicks(true);
        radius.setPaintLabels(true);

        sidePanel.add(length, BorderLayout.WEST);
        sidePanel.add(spacing, BorderLayout.CENTER);
        sidePanel.add(radius, BorderLayout.EAST);

        JLabel lengthText = new JLabel("Length");
        JLabel spacingText = new JLabel("Spacing");
        JLabel radiusText = new JLabel("Radius");

        sideMenu.add(lengthText);
        sideMenu.add(spacingText);
        sideMenu.add(radiusText);

        frame.add(sidePanel, BorderLayout.WEST);
        sidePanel.add(sideMenu,BorderLayout.NORTH);
        sidePanel.add(shape,BorderLayout.SOUTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        skipper = 1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentPath = new Path(e.getX(), e.getY(), Color.black);
        if(listOfPaths.size() > length.getValue()){
            listOfPaths.remove(0);
        }else{
            listOfPaths.add(currentPath);
        }
        if(shape.getItemAt(shape.getSelectedIndex())=="Circle"){
            if(skipper == spacing.getValue()){
                currentCircle = new Circle(e.getX(), e.getY(), color);
                if(listOfCircles.size() > length.getValue()){
                    listOfCircles.remove(0);
                }else{
                    listOfCircles.add(currentCircle);
                }
                skipper = 1;
            }else{
                skipper++;
            }
        } else if(shape.getItemAt(shape.getSelectedIndex())=="Square"){
            if(skipper == spacing.getValue()){
                currentSquare = new Square(e.getX(), e.getY(), color);
                if(listOfSquares.size() > length.getValue()){
                    listOfSquares.remove(0);
                }else{
                    listOfSquares.add(currentSquare);
                }
                skipper = 1;
            }else{
                skipper++;
            }
        } else if(shape.getItemAt(shape.getSelectedIndex())=="Hourglass"){
            if(skipper == spacing.getValue()){
                currentHourglass = new Hourglass(e.getX(), e.getY(), color);
                if(listOfHourglasses.size() > length.getValue()){
                    listOfHourglasses.remove(0);
                }else{
                    listOfHourglasses.add(currentHourglass);
                }
                skipper = 1;
            }else{
                skipper++;
            }
        }
        r--;
        color = new Color(r,0,0);
        if(r<= 0){
            r = 255;

        }
        mainPanel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
