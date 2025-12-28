import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(16, GPIO.IN)  # IR sensor
GPIO.setup(18, GPIO.OUT)  # LED
GPIO.setup(24, GPIO.OUT)  # Buzzer

lcd = CharLCD('PCF8574', 0x27)

try:
    while True:
        if GPIO.input(16) == GPIO.LOW:  # Obstacle
            GPIO.output(18, GPIO.HIGH)
            GPIO.output(24, GPIO.HIGH)
            lcd.clear()
            lcd.write_string("Obstacle!")
        else:
            GPIO.output(18, GPIO.LOW)
            GPIO.output(24, GPIO.LOW)
            lcd.clear()
            lcd.write_string("Clear Path ")
        time.sleep(0.5)
except KeyboardInterrupt:
    lcd.clear()
    GPIO.cleanup()
