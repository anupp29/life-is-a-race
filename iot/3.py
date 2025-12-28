import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
from w1thermsensor import W1ThermSensor
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)  # LED
GPIO.setup(24, GPIO.OUT)  # Buzzer

lcd = CharLCD('PCF8574', 0x27)
sensor = W1ThermSensor()
threshold = 30

try:
    while True:
        temp = sensor.get_temperature()
        lcd.clear()
        lcd.write_string(f"Temp: {temp:.1f}C")
        if temp > threshold:
            lcd.write_string(" HOT! ")
            GPIO.output(18, GPIO.HIGH)
            GPIO.output(24, GPIO.HIGH)
        else:
            lcd.write_string(" Normal ")
            GPIO.output(18, GPIO.LOW)
            GPIO.output(24, GPIO.LOW)
        time.sleep(2)
except KeyboardInterrupt:
    lcd.clear()
    GPIO.cleanup()
