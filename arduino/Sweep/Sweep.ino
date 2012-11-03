/** Sweep
  * Reqs: PMEServo
  * Author: Michael Lin
  * borrowed code from BARRAGAN <http://barraganstudio.com> 
  */

#include <PWMServo.h> 
 
PWMServo servo1;
 
int pos = 0;    // variable to store the servo position 
char serIn;
char code = 'D'; //This is the message that the computer will send through Serial

void setup() {
  
  Serial.begin(115200);
  servo1.attach(9);  // PWM pin 9
  
}
 
void loop() { 
  if (Serial.available()) {  //Only read when there is something to read
    while(Serial.available() > 0) {
      serIn = Serial.read();
      if (serIn == code) {
        for(pos = 0; pos < 180; pos += 1) {  // goes from 0 degrees to 180 degrees 
          servo1.write(pos);              // tell servo to trigger the gun 
          delay(15);                       // waits 15ms for the servo to reach the position 
        }
      }
    }
  }
}
