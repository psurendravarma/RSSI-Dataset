# RSSI-Dataset
This RSSI Dataset is generated through WiFi Fingerprinting in a 22 feet wide and 34 feet long indoor environment.
A smart phone used as the navigating device, which scans the RSSI values from five access points and sends them to the server.
An android application is developed to scan these RSSI values which uses android.net.wifi.WifiManager class and sends them through URL to a computer having flask server implemented using python. The proposed algorithms were implemented in python which predict location label based on the RSSI values received.
