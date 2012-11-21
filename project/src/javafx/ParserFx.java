/*
 * Aizhan Demeugaliyeva
 */
package javafx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ParserFx {

    private BufferedReader reader;
    private ImageFx image;
    private double windowWidth = 1000;
    private double windowHeight = 800;

    private int action = 1;

    public ParserFx(Reader reader, ImageFx image) {
        this.reader = new BufferedReader(reader);
        this.image= image;
  
    }

    public double getWindowWidth(){
        return (windowWidth);
    }

    public double getWindowHeight(){
        return (windowHeight);
    }

    public void parse() {

        try {
            String line = reader.readLine();
            if (line != null) {
                parseLine(line);
            }
            else {
                action = 0;
                image.logError("\nDrawing completed");
            }
/*            while (line != null) 
            {
                //this.image.logError("Step");
                parseLine(line);
                line = reader.readLine(); action = 1;
                else {break;}
            }*/
        } 
        catch (IOException e) {
            image.logError("\nParse failed." + e.getMessage());
            return;
        } 
        catch (ParseExceptionFx e) {
            image.logError("\nThere is an error: " + e.getLocalizedMessage());
        }
        //image.logError("\nDrawing completed");
    }

    private void parseLine(String line) throws ParseExceptionFx {
        if (action == 0) return;
        if (line.length() < 2) {
            return;
        }
        String command = line.substring(0, 2);
        if (command.equals("WS")) {
            setWindowSize(line.substring(2, line.length()));
            return;
        }
        if (command.equals("DL")) {
            drawLine(line.substring(2, line.length()));
            return;
        }
        if (command.equals("DR")) {
            drawRect(line.substring(2, line.length()));
            return;
        }
        if (command.equals("FR")) {
            fillRect(line.substring(2, line.length()));
            return;
        }
        if (command.equals("GR")) {
            gradRect(line.substring(2, line.length()));
            return;
        }
        if (command.equals("SC")) {
            setColour(line.substring(3, line.length()));
            return;
        }
        if (command.equals("DS")) {
            drawString(line.substring(3, line.length()));
            return;
        }
        if (command.equals("DA")) {
            drawArc(line.substring(2, line.length()));
            return;
        }
        if (command.equals("SG")) {
             setGrad(line.substring(2, line.length()));
            return;
        }
        if (command.equals("DO")) {
            drawOval(line.substring(2, line.length()));
            return;
        }
        if (command.equals("DI")) {
           showImage(line.substring(2, line.length()));
            return;
        }
        if (command.equals("PM")) {
           penMoveTo(line.substring(2, line.length()));
            return;
        }
        if (command.equals("PD")) {
           penDown(line.substring(2, line.length()));
            return;
        }
        if (command.equals("PU")) {
           penUp(line.substring(2, line.length()));
            return;
        }
        if (command.equals("PR")) {
           penRight(line.substring(2, line.length()));
            return;
        }
        if (command.equals("PL")) {
           penLeft(line.substring(2, line.length()));
            return;
        }
        if (command.equals("PF")) {
           penFoward(line.substring(2, line.length()));
            return;
        }
        if (command.equals("DC")) {
           drawCubicCurve(line.substring(2, line.length()));
            return;
        }

        throw new ParseExceptionFx("\nUnknown drawing command");
    }
    
    
    public void setWindowSize(String args ) throws ParseExceptionFx{
        int width = 0;
        int height = 0;
        StringTokenizer tokenizer = new StringTokenizer(args);
        windowWidth = getInteger(tokenizer);
        windowHeight = getInteger(tokenizer);
   }

    private void showImage(String args ) throws ParseExceptionFx {
        int width = 0;
        int height = 0;
        String s = "";
        StringTokenizer tokenizer = new StringTokenizer(args);
        width = getInteger(tokenizer);
        height = getInteger(tokenizer);
        int position = args.indexOf("@");
        if (position == -1) {
            throw new ParseExceptionFx("\nDrawString string is missing");
        }
        s = args.substring(position + 1, args.length());
        
        //System.out.println("I am showing image from " + width + " " + height + " " + s);
        image.drawImage(width, height, s);
    
    }
    private void drawLine(String args) throws ParseExceptionFx {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x1 = getInteger(tokenizer);
        y1 = getInteger(tokenizer);
        x2 = getInteger(tokenizer);
        y2 = getInteger(tokenizer);
        image.logError("\nI am drawing a line");
        image.drawLine(x1,y1, x2, y2);
   }

    private void drawRect(String args) throws ParseExceptionFx {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x1 = getInteger(tokenizer);
        y1 = getInteger(tokenizer);
        x2 = getInteger(tokenizer);
        y2 = getInteger(tokenizer);
        image.logError("\nDrawing a rectangle");
        image.drawRect(x1,y1, x2, y2);
    }

    private void fillRect(String args) throws ParseExceptionFx {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x1 = getInteger(tokenizer);
        y1 = getInteger(tokenizer);
        x2 = getInteger(tokenizer);
        y2 = getInteger(tokenizer);
        image.logError("\nI am drawing a filled rectangle");
        image.fillRect(x1, y1, x2, y2);
    }

    private void gradRect(String args) throws ParseExceptionFx {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x1 = getInteger(tokenizer);
        y1 = getInteger(tokenizer);
        x2 = getInteger(tokenizer);
        y2 = getInteger(tokenizer);
        image.logError("\nI am drawing a Gradiented rectangle");
        image.gradRect(x1, y1, x2, y2);
    }

    private void drawArc(String args) throws ParseExceptionFx {
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int startAngle = 0;
        int arcAngle = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x = getInteger(tokenizer);
        y = getInteger(tokenizer);
        width = getInteger(tokenizer);
        height = getInteger(tokenizer);
        startAngle = getInteger(tokenizer);
        arcAngle = getInteger(tokenizer);
        image.logError("\nI a drawing an arc (x, y, width, height, startAngle, arcAngle)");
        image.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    private void drawOval(String args) throws ParseExceptionFx {
        int x1 = 0;
        int y1 = 0;
        int width = 0;
        int height = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x1 = getInteger(tokenizer);
        y1 = getInteger(tokenizer);
        width = getInteger(tokenizer);
        height = getInteger(tokenizer);
        image.logError("\nI am drawing an Oval ");
        image.drawOval(x1, y1, width, height);

    }
    
    private void setGrad(String args )throws ParseExceptionFx{
       StringTokenizer tokenizer = new StringTokenizer(args);
       Color color1 = getColour(tokenizer.nextToken());
       Color color2 = getColour(tokenizer.nextToken());
       image.logError("\nSet colour from "+ color1 + " to" + color2 );
       image.setGrad(color1, color2);       
    }
    
    private void drawString(String args) throws ParseExceptionFx {
        int x = 0;
        int y = 0;
        String s = "";
        StringTokenizer tokenizer = new StringTokenizer(args);
        x = getInteger(tokenizer);
        y = getInteger(tokenizer);
        int position = args.indexOf("@");
        if (position == -1) {
            throw new ParseExceptionFx("\nDrawString string is missing");
        }
        s = args.substring(position + 1, args.length());
        image.logError("\nI am writing "+ s +" at position "+x +" " +y );
        image.drawString(x, y, s);
    }
    
    private void setColour(String colourName) throws ParseExceptionFx {
        //System.out.println("The colour was set to " + getColour(colourName).toString());
        image.setColor(getColour(colourName));
    }

       private Color getColour(String colourName) throws ParseExceptionFx {
        if (colourName.equals("black")) {
            return Color.BLACK;
        }
        if (colourName.equals("blue")) {
         
            return Color.BLUE;
            
        }
        if (colourName.equals("cyan")) {
           return Color.CYAN;
        }
        if (colourName.equals("darkgray")) {
           return Color.DARKGRAY;// doesn't have darkgray
        }
        if (colourName.equals("gray")) {
            return Color.GRAY;
        }
        if (colourName.equals("green")) {
          return Color.GREEN;
        }
        if (colourName.equals("lightgray")) {
            return Color.LIGHTGRAY;
        }
        if (colourName.equals("magenta")) {
            return Color.MAGENTA;
        }
        if (colourName.equals("orange")) {
            return Color.ORANGE;
        }
        if (colourName.equals("pink")) {
           return Color.PINK;
        }
        if (colourName.equals("red")) {
           return Color.RED;
        }
        if (colourName.equals("white")) {
            return Color.WHITE;
        }
        if (colourName.equals("yellow")) {
            return Color.YELLOW;
        }
        throw new ParseExceptionFx("\nInvalid colour name");
    }

    private int getInteger(StringTokenizer tokenizer) throws ParseExceptionFx {
        if (tokenizer.hasMoreTokens()) {
            return Integer.parseInt(tokenizer.nextToken());
        } else {
            throw new ParseExceptionFx("\nMissing Integer value");
        }
    }

    private void penMoveTo(String args) throws ParseExceptionFx {
        int x1 = 0;
        int y1 = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        x1 = getInteger(tokenizer);
        y1 = getInteger(tokenizer);
        image.logError("\nI am drawing a line");
        image.penMoveTo(x1,y1);
   }

    private void penDown(String args) throws ParseExceptionFx {
        image.penDown();
        image.logError("\nPen Down");
   }

    private void penUp(String args) throws ParseExceptionFx {
        image.penUp();
        image.logError("\nPen up");
   }

    private void penRight(String args) throws ParseExceptionFx {
        int degr = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        degr = getInteger(tokenizer);
        image.penright(degr);
        image.logError("\nPen right");
   }

    private void penLeft(String args) throws ParseExceptionFx {
        int degr = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        degr = getInteger(tokenizer);
        image.penleft(degr);
        image.logError("\nPen left");
   }

    private void penFoward(String args) throws ParseExceptionFx {
        int l = 0;

        StringTokenizer tokenizer = new StringTokenizer(args);
        l = getInteger(tokenizer);
        image.foward(l);
        image.logError("\nPen forward");
   }
    private void drawCubicCurve(String args) throws ParseExceptionFx {
        int StartX; 
        int StartY; 
        int ControlX1; 
        int ControlY1; 
        int ControlX2; 
        int ControlY2; 
        int EndX; 
        int EndY;

        StringTokenizer tokenizer = new StringTokenizer(args);
        StartX = getInteger(tokenizer);
        StartY = getInteger(tokenizer);
        ControlX1 = getInteger(tokenizer);
        ControlY1 = getInteger(tokenizer);
        ControlX2 = getInteger(tokenizer);
        ControlY2 = getInteger(tokenizer);
        EndX = getInteger(tokenizer);
        EndY = getInteger(tokenizer);
        image.drawCubicCurve(StartX, StartY, ControlX1, ControlY1, ControlX2, ControlY2, EndX, EndY);
        image.logError("\nDraw Cubic Curve");
    }

    public int getAction (){
        return this.action;
    }
    
    


}
