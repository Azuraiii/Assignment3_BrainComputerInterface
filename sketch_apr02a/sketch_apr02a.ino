#include <stdlib.h>
#include <SoftwareSerial.h>
SoftwareSerial BTSerial(0,1);

String BluetoothData;
String acc = ""l

void setup(){
  //setup code here
  BTSerial.begin(9600);
  //setup channel A
  pinMode(12,OUTPUT); //initialize motor channel A pin
  pinMode(9,OUTPUT); //initiates brake channel A pin

  //setup channel B
  pinMode(13,OUTPUT);//inititates motor channel B pin
  pinMode(8,OUTPUT);//inititiates brake channel B pin

  digitalWrite(9,HIGH);
  digitalWrite(8,HIGH);
 
}
void loop(){

  
}

void move(float acc){
          if (acc < -150)
        {
          digitalWrite(12, HIGH);
          digitalWrite(13, HIGH);

          digitalWrite(9, LOW);
          digitalWrite(8, LOW);

          analogWrite(11, 220); // RIGHT
          analogWrite(3, 50); // LEFT
        } else if (acc > 150)
        {
          digitalWrite(12, HIGH);
          digitalWrite(9, LOW);
          digitalWrite(13, HIGH);
          digitalWrite(8, LOW);

          analogWrite(11, 50); // RIGHT
          analogWrite(3, 200); // LEFT
        } else if (acc > -150 && acc < 150 && acc != 0)
        {
          digitalWrite(12, HIGH);
          digitalWrite(9, LOW);
          digitalWrite(13, HIGH);
          digitalWrite(8, LOW);

          analogWrite(11, 200);
          analogWrite(3, 170);
        }
}

