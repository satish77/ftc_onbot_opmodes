# FTC Robotics OnBot Java operational modes

This repo has a set of OpModes written in java.

These programs are for practice using the Onbot java. 
All the opmodes can also be built and deployed using Android Studio as well.

All these programs are created while mentoring Team 11691 for 2018-19 season. 

# Steps to use Android Studio wirelessly with Robot Controller
* Enable wireless adb(Android Debug Bridge) using the following steps.
  1. Connect Robot controller Android Phone using usb cable to Computer.
  2. Make sure adb is in the path. Otherwise use full path to adb.
  3. Open Android Studio and select any file containing opmode.
  4. Goto LogCat in Android Studio and make sure that Robot controller is recognized as connected.
  5. Goto Terminal in Android Studio and type the following
    * adb tcpip 5555
  6. Robot Controller is restarted by the command waiting for wireless connections.
  7. Disconnect usb cable from the computer and connect it to the Rev Expansion Hub.
  8. Connect computer to Robot Controller using its network (WIFI DIRECT).
* Connect Android Studio to Robot Controller using the following steps.
  1. Connect computer to Robot Controller wifi direct network.
  2. Type the following in the terminal of Android Studio
      * adb connect 192.168.49.1:5555
* Run the opmode using Android Studio. This will build and deploy apk everytime it is modified.

Remember enabling wireless adb at least once after restarting Robot controller using usb cable. 
This procedure works on both Mac and PC.







