import serial;

ser = serial.Serial('/dev/tty.usbmodemfa131', 115200)
ser.write(bytes('D','UTF-8'))

