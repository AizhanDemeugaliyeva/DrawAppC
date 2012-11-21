enum colour {black,blue,cyan,darkgray,gray,green,lightgray,magenta,orange,pink,red,white,yellow};
typedef enum colour colour;

void drawLine(int,int,int,int);
void drawRect(int,int,int,int);
void drawOval(int,int,int,int);
void drawArc(int,int,int,int,int,int);
void fillRect(int,int,int,int);
void drawString(char*,int,int);

void setColour(colour);
void setGrad(colour, colour);
void gradRect(int x1, int x2, int x3, int x4);
void drawCubicCurve(int, int, int, int, int, int, int, int);

//Turtle Graphics
void penMoveTo(int x, int y);
void penUp();
void penDown();
void penRight(int degr);
void penLeft(int degr);
void penFoward(int l);
