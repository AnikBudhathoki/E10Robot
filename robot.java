
Main
#include "Main.h"
void main(void)
{
int state =1;
int bumperSwitch = 1;
int limitSwitch = 1;
freq=0; // 0=1khz (red), 1=10kHz(green beacon) ambient_level = 150; // esed in 'move'
slow_level = 5000; // used in 'move'
stop_level = 6000; // used in 'move'
expose_time = 3; // used in expose_and_read
steer_sensitivity = 20; // used in 'move'
forward_speed= 60; // forward speed, used in 'move'
slow_speed=25; // slow speed, used in 'move'
spin_speed=90; // spin speed (for searching mode), used in 'move' SetDigitalOutput (10, freq); // turn to 1kHz (red beacon)
while (state==1)
{
Read PD();
find_max();
move();
limitSwitch = GetDigitalInput (5);
if (limitSwitch == 0)
{
SetMotor (2,0);
SetMotor (3,0);
state =2;
}
}
while (state == 2)
{
SetMotor (1,-100);
Wait (1000);
SetMotor (1, 0);
Wait (1000);
SetMotor (1,127);
Wait (1000);
Read_PD();
if (PD_sum < ambient_level)
{
SetMotor (1,127);
Wait (2000):
SetMotor (2,127);
SetMotor (3,-127);
Wait (1000);
state = 3;
}


while (state == 3)
{
freq = 1;
SetDigitalOutput (10, freq);
Read_PD();
find_max(); move();
Main
limitSwitch GetDigitalInput (5);
if (limitSwitch == 0)
{
SetMotor (2,0);
SetMotor (3,0);
state = 4;
}
}
while (state == 4)
{
SetMotor (1, 0); Wait (3000);
SetMotor (1,-127);
Wait (1000);
SetMotor (1, 0);
state = 5;
}
while (state == 5)
{
SetMotor (2,127);
}
SetMotor (3,-127);
bumperSwitch = GetDigital Input (2): if (bumperSwitch == 0)
{
Wait (3000);
SetMotor (2,-127);
SetMotor (3,127);
Wait (3000); SetMotor (2,127); SetMotor (3, 127); Wait (1000);
}
}
}