#include <stdio.h>
#include "graphics.h"

/* 
 *
 * Author: Aizhan Demeugaliyeva
 * ./drawappcturtle | java -jar project.jar 
 *
 */

void setWindowSize(int width, int height)
{
  printf("WS %i %i\n", width, height);
}

void drawLine(int x1, int x2, int x3, int x4)
{
  printf("DL %i %i %i %i\n", x1, x2, x3, x4);
}

void drawRect(int x1, int x2, int x3, int x4)
{
  printf("DR %i %i %i %i\n", x1, x2, x3, x4);
}

void drawOval(int x, int y, int width, int height)
{
  printf("DO %i %i %i %i\n",x,y,width,height);
}

void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
{
  printf("DA %i %i %i %i %i %i\n",x,y,width,height, startAngle, arcAngle);
}

void fillRect(int x1, int x2, int x3, int x4)
{
  printf("FR %i %i %i %i\n", x1, x2, x3, x4);
}

void gradRect(int x1, int x2, int x3, int x4)
{
  printf("GR %i %i %i %i\n", x1, x2, x3, x4);
}

void drawString(char* s, int x, int y)
{
  printf("DS %i %i @%s\n",x,y,s);
}

void drawImage(int width, int height, char* s)
{
  printf("DI %i %i @%s\n",width,height,s);
}

void saveImageToFile(char* s)
{
  printf("SI @%s\n", s);
}

void setColour(colour c)
{
  char* colourName;
  switch(c)
  {
    case black : colourName = "black"; break;
    case blue : colourName = "blue"; break;
    case cyan : colourName = "cyan"; break;
    case darkgray : colourName = "darkGray"; break;
    case gray : colourName = "gray"; break;
    case green : colourName = "green"; break;
    case lightgray : colourName = "lightGray"; break;
    case magenta : colourName = "magenta"; break;
    case orange : colourName = "orange"; break;
    case pink : colourName = "pink"; break;
    case red : colourName = "red"; break;
    case white : colourName = "white"; break;
    case yellow : colourName = "yellow"; break;
  }
  printf("SC %s\n", colourName);
  
}
void setGrad(colour c1, colour c2)
{
  char* colourName, * colourName2;
  switch(c1)
  {
    case black : colourName = "black"; break;
    case blue : colourName = "blue"; break;
    case cyan : colourName = "cyan"; break;
    case darkgray : colourName = "darkGray"; break;
    case gray : colourName = "gray"; break;
    case green : colourName = "green"; break;
    case lightgray : colourName = "lightGray"; break;
    case magenta : colourName = "magenta"; break;
    case orange : colourName = "orange"; break;
    case pink : colourName = "pink"; break;
    case red : colourName = "red"; break;
    case white : colourName = "white"; break;
    case yellow : colourName = "yellow"; break;
  }
  switch(c2)
  {
    case black : colourName2 = "black"; break;
    case blue : colourName2 = "blue"; break;
    case cyan : colourName2 = "cyan"; break;
    case darkgray : colourName2 = "darkDray"; break;
    case gray : colourName2 = "gray"; break;
    case green : colourName2 = "green"; break;
    case lightgray : colourName2 = "lightGray"; break;
    case magenta : colourName2 = "magenta"; break;
    case orange : colourName2 = "orange"; break;
    case pink : colourName2 = "pink"; break;
    case red : colourName2 = "red"; break;
    case white : colourName2 = "white"; break;
    case yellow : colourName2 = "yellow"; break;
  }
  printf("SG %s %s\n", colourName, colourName2);
  
}
void drawCubicCurve(int StartX, int StartY, int ControlX1, int ControlY1, int ControlX2, int ControlY2, int EndX, int EndY){
    printf("DC %d %d %d %d %d %d %d %d\n", StartX, StartY, ControlX1, ControlY1, ControlX2, ControlY2, EndX, EndY);
}
//Turtle Graphics
void penMoveTo(int x, int y){
  printf("MT %d %d\n", x, y);
}
void penUp(){
  printf("PU\n");
}
void penDown(){
  printf("PD\n");
}
void penRight(int degr){
  printf("PR %d\n", degr);
}
void penLeft(int degr){
  printf("PL %d\n", degr);
}
void penFoward(int l){
  printf("PF %d\n", l);
}

