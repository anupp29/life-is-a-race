import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
import bluetooth
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)

lcd = CharLCD('PCF8574', 0x27)

sock = bluetooth.BluetoothSocket(bluetooth.RFCOMM)
sock.bind(('', bluetooth.PORT_ANY))
sock.listen(1)
bluetooth.advertise_service(sock, 'LEDControl')

print("Waiting for BT connection...")
client, addr = sock.accept()
print(f"Connected: {addr}")
lcd.clear()
lcd.write_string("BT Connected")

try:
    data = client.recv(1024).decode()
    if data == '1':
        GPIO.output(18, GPIO.HIGH)
        lcd.clear()
        lcd.write_string("LED ON via BT")
    elif data == '0':
        GPIO.output(18, GPIO.LOW)
        lcd.clear()
        lcd.write_string("LED OFF via BT")
    time.sleep(2)
    lcd.clear()
    client.send(b'OK')
except:
    pass

client.close()
sock.close()
GPIO.cleanup()
