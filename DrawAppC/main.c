/* 
 * File:   main.c
 *  Aizhan Demeugaliyeva
 * ./drawappc | java -jar project.jar 
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include "graphics.h"


int main(int argc, char** argv) {
  
  setWindowSize(900, 700);
    
  drawLine(40, 250, 290, 250);
  drawLine(40, 250, 40, 50);

  drawString("CDs", 50, 270);
  drawString("DVDs", 98, 270);
  drawString("Books", 146, 270);
  drawString("Clothes", 190, 270);
  drawString("Shoes", 248, 270);

  char buf[20];
  int y;
  for (y = 0 ; y < 200 ; y += 50)
  {
    sprintf(buf,"%i",y);
    drawLine(40, 250 - y, 35, 250 - y);
    drawString(buf, 10, 255 - y);
  }

  setColour(blue);
  fillRect(40, 190, 50, 60);
  setColour(green);
  fillRect(90, 110, 50, 140);
  setColour(red);
  fillRect(140, 130, 50, 120);
  setColour(yellow);
  fillRect(190, 155, 50, 95);
  setGrad(green, magenta);
  gradRect(240, 110, 50, 140); 
  drawCubicCurve(0, 50, 25, 0, 75, 100, 100, 50);

 
  return (EXIT_SUCCESS);
}



