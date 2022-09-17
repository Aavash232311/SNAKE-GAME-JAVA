
ArrayList<Integer> x = new ArrayList<Integer>();
ArrayList<Integer> y = new ArrayList<Integer>();
int expandWidth = 40, expandHeight = 40;
int snakeWidth = 30;
int blockSize = 20;
int vector = 0;
int[] xVector = {0, 0, 1, -1};
int[] yVector = {1, -1, 0, 0};
int appleCordX = 5;
int appleCordY = 5;
boolean runtime = false;
float speed = 15;
int intervalCount = 0;


void setup() {
  size(800, 800);
  x.add(0);
  y.add(0);
}

void draw() {
background(0);
fill(0, 255, 0);

for (int i= 0; i < x.size(); i++){
  // appending blocks in this code
  int cordX = x.get(i) * blockSize;
  int cordY = y.get(i) * blockSize;
  
  //    x      y      width       height
  rect(cordX, cordY, blockSize, blockSize);
}

if (runtime == false) {
  fill(255, 0, 0);
  rect(appleCordX * blockSize, appleCordY * blockSize, blockSize, blockSize);
    textAlign(RIGHT); 
    textSize(18);
    fill(255);
    int actScore = x.size() - 1;
    text("Score: " + actScore, 10, 10, width - 20, 50);
 if (frameCount % speed == 0){
    x.add(0, x.get(0) + xVector[vector]);
    y.add(0, y.get(0) + yVector[vector]);

    if (x.get(0) < 0 || y.get(0) < 0 || x.get(0) > expandWidth ||  y.get(0) > expandWidth) {
       runtime = true;
    }
    for (int i=1; i<x.size(); i++) {
        if (x.get(0)==x.get(i)&&y.get(0)==y.get(i)) {
          // front coordinate of block should not match x and y coordinates of any other blocks excluding itself so loop started from 1

        runtime=true;
      } 
    }
    if (x.get(0) == appleCordX && y.get(0) == appleCordY) {
     appleCordX = (int)random(0, expandWidth);
     appleCordY = (int)random(0, expandHeight);
     // 4 count interval speed increment
     
     if (intervalCount > 1) {
       if (speed >= 7){
       speed -= 1;
       }
       intervalCount = 0;
     }
     intervalCount++;
     
    } else {
    x.remove(x.size() - 1);
    y.remove(y.size() - 1);
    }
  }

}else {
  textAlign(CENTER);
  fill(153, 102, 255);
  textSize(30);
  text("GAME OVER", 10, 10, width - 20, 50);
  
  if (keyCode == 10){
    runtime = false;
    x.clear();
    y.clear();
    x.add(0);
    y.add(0);
    vector = 0;
  }
  
  
}
}

void keyPressed() {
  if (!runtime) {
  if (keyCode == 40){
    if (vector != 1){
        vector = 0;
    }
  }else if (keyCode == 38){
    if (vector != 0) {
    vector = 1;
    }
  }else if (keyCode == 37) {
      System.out.println("LEFT");
      if (vector != 2) {
        vector = 3;
      }
  }else if (keyCode == 39) {
      System.out.println("RIGHT");
      if (vector != 3) {
   vector = 2;
      }
  }
 
  }
}
