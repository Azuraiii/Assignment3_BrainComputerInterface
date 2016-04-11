#include <SoftwareSerial.h>
#include <stdlib.h>
SoftwareSerial BTserial(0, 2);

String BluetoothData;
String acc = "";
int choice = 0;

void setup() {
  
  //setup code here
  BTserial.begin(9600);
  
  //setup channel A
  pinMode(12, OUTPUT); //initialize motor channel A pin
  pinMode(9, OUTPUT); //initiates brake channel A pin

  //setup channel B
  pinMode(13, OUTPUT); //inititates motor channel B pin
  pinMode(8, OUTPUT); //inititiates brake channel B pin

  digitalWrite(9, HIGH);
  digitalWrite(8, HIGH);

}
void loop() {

  if (choice > 1)
  {
    float nacc = acc.toFloat();
    move(nacc);
  }
}

void serialEvent()
{
  if (BTserial.available()) {
    BluetoothData = BTserial.readStringUntil(',');
    if (BluetoothData.startsWith("3")){
    BluetoothData.replace("3", "");
      acc = "";
      if (BluetoothData.startsWith("A")) {
        acc = BluetoothData;
        acc.replace("A", "");
      }
      choice = 1;
      BTserial.flush();
    }
  }
}

void move(float acc) {
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

