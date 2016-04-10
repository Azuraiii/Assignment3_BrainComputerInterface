# Assignment3_BrainComputerInterface:
This assignment is for my 3rd assignment for Object Oriented Programming.
The goal of this assignment is to manipulate virtual and physical objects and also visualize the output received by the headset.
The software visualizes the brain output in realtime using a Bar Graph.
For the virtual manipulation, with this software a user who is concentrating is able to rotate and move a cube
and also make it disappear by relaxing their mind.
For the physical manipulation, with this software a user can make an arduino robot move forward with concentration and backwards with relaxation.
The steering control of the arduino is manipulated by an accelerometer built into the headset.

#Understanding Brainwaves:
To get a better understanding of the brain output I needed to do some research about brainwaves.
Taken from: http://www.brainworksneurotherapy.com/what-are-brainwaves

##Alpha-(8-12Hz)
Alpha brainwaves are produced when your brain is in a meditative or relaxed state.
It is a resting state for your brain. Alpha waves aid mental co-ordination, calmness, alertness, mind/body integration and learning.
Alpha is indicated in red

##Beta-(12-38Hz)
Beta brainwaves are produced when our attention is directed towards cognitive tasks.
Beta is a fast activity, present when we are alert,attentive and engaged in problem solving, judgement,decision making and engaged in focused mental activity.
Beta is indicated in blue.

##Delta-(.5-3Hz)
Delta waves are slow but carry a high amplitude, They are generated in deep meditation and dreamless sleep.
Delta waves suspend external awareness and are the source of empathy. Healing and regeneration are stimulated in this state and that is why deep
restorative sleep is important.

##Gamma-(28-42Hz)
Gamma are the fastest brainwaves. It passes information rapidly and is the most subtle of the brainwave frequencies.
Gamma was dismissed as "Spare Brainwave Noise" until researchers discovered it was highly active when in states of universal love, altruism and higher virtues.

##Theta-(3-8Hz)
Theta brainwaves occur most often in sleep and deep meditation. It acts as our gateway to learning and memory.
In theta we are in dream, vivid imagery, intuition, and sub conscious awareness.

#Visualization

#Instructions:
##Connecting to the Muse Headset
To connect to the headset you will first need to pair the device first via bluetooth.
1. Turn on the headset by pressing the button
2. Pair the device to the computer via bluetooth.
3. Open the command line and enter the following: muse-io --device Muse --osc osc.udp://localhost:5000
4. For the command line to work you will need to download the muse-io file from the Muse website.

##Test Headset
The first part of the program is just to test the headset to see if it works.
An empty rectangle appears and if the headset is properly connected to the users head the rectangle will be in color.
An poorly designed eye and smile will appear when a user blinks and clenches their jaw.

##Mind Cube
The cube rotates and moves closer to the screen when the user is concentrating their mind and disappears when the user is relaxing their mind.

##Arduino Robot
When the user uses the headset..data from the headset is sent to the computer and towards the arduino robot via bluetooth.
When the user concentrates it will cause the robot to move forward.
When the user relaxes their thoughts it will cause the robot to move backwards.
The accelerometer build onto the headset will cause the robot to steer left and right when the user tilts their head left or right.


