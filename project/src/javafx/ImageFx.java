package javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Line;
import javafx.scene.shape.*;
import javafx.scene.shape.Arc;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import java.lang.Math;
import java.awt.Frame;  




public class ImageFx{
    private Group root;
    private Color color;
    private LinearGradient lg;
    private TextArea text = new TextArea("LOG:");
    private double tgX = 0, tgY = 0, penUP = 0, tgDegr = 0, tgDegr0 = 0;
    
    public ImageFx(Group root, TextArea text){
        this.root= root;
        this.text= text;
    }

    public void drawLine(double x1, double y1, double x2, double y2){
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        root.getChildren().add(line);
    }

    public void drawRect(double x1, double y1, double x2, double y2){
        Rectangle rect = new Rectangle();
        rect.setX(x1);
        rect.setY(y1);
        rect.setWidth(x2);
        rect.setHeight(y2);
        root.getChildren().add(rect);
    }

    public void fillRect(double x1, double y1, double x2, double y2){
        Rectangle rect = new Rectangle();
        rect.setX(x1);
        rect.setY(y1);
        rect.setWidth(x2);
        rect.setHeight(y2);
        rect.setFill(color);
        root.getChildren().add(rect);
    }

    public void gradRect(double x1, double y1, double x2, double y2){
        Rectangle rect = new Rectangle();
        rect.setX(x1);
        rect.setY(y1);
        rect.setWidth(x2);
        rect.setHeight(y2);
        rect.setFill(lg);
        root.getChildren().add(rect);
    }

    public void drawOval(double x1, double y1, double width, double height){
        Ellipse ellipse = new Ellipse(); 
        ellipse.setCenterX(x1);
        ellipse.setCenterY(y1);
        ellipse.setRadiusX(width/2);
        ellipse.setRadiusY(height/2);
        root.getChildren().add(ellipse);
    }

    public void drawArc(double x1, double y1, double width, double height, double startAngle, double arcAngle){
        Arc arc = new Arc();
        arc.setCenterX(x1);
        arc.setCenterY(y1);
        arc.setRadiusX(width);
        arc.setRadiusY(height);
        arc.setStartAngle(startAngle);
        arc.setLength(arcAngle);
        arc.setType(ArcType.ROUND);
        root.getChildren().add(arc);
    }
    
    public void drawString(int x, int y, String s)
    {
        Text text3 = new Text(x, y, s);
        Font sanSerif = Font.font("SanSerif", 10);
        text3.setFont(sanSerif);
        text3.setFill(Color.BLACK);
        root.getChildren().add(text3);        
    }
    
    public void setColor(Color col)
    {
        color = col;
    }
    
    public void setGrad(Color col1, Color col2)
    {
        Stop[] stops = new Stop[] { new Stop(0, col1), new Stop(1, col2)};
        lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    }
    
    public void drawImage(double width, double height, String imgUrl)
    {
        Image image = new Image(imgUrl, width, height, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitWidth(width);
        iv.setFitHeight(height);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        HBox box = new HBox();
        box.getChildren().add(iv);
        root.getChildren().add(box);
    }
    
    public void logError(String s){
        text.appendText(s);    
    }
    
    public void penMoveTo (double x, double y){
        tgX = x;
        tgY = y;
    }

    public void penDown (){
        penUP = 0;
    }

    public void penUp (){
        penUP = 1;
    }

    public void foward (double l){
        double tgX1 = 0, tgY1 = 0;
        tgX1 = tgX + l * java.lang.Math.cos(tgDegr0);
        tgY1 = tgY + l * java.lang.Math.sin(tgDegr0);
        if(penUP == 0) {  this.drawLine(tgX, tgY, tgX1, tgY1); }
        tgX = tgX1;
        tgY = tgY1;
    }

    public void penright (double grad)
    {
        tgDegr = grad*Math.PI/180;
        tgDegr0 = tgDegr0 + tgDegr;
    }

    public void penleft (double grad)
    {
        tgDegr = -grad*Math.PI/180;
        tgDegr0 = tgDegr0 + tgDegr;
    }
 
    public void drawCubicCurve(double StartX, double StartY, double ControlX1, double ControlY1, double ControlX2, double ControlY2, double EndX, double EndY){
        CubicCurve cubic = new CubicCurve();
        cubic.setStartX(StartX);
        cubic.setStartY(StartY);
        cubic.setControlX1(ControlX1);
        cubic.setControlY1(ControlY1);
        cubic.setControlX2(ControlX2);
        cubic.setControlY2(ControlY2);
        cubic.setEndX(EndX);
        cubic.setEndY(EndY);
        root.getChildren().add(cubic);
    }
    

}