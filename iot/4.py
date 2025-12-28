import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(16, GPIO.IN)  # LDR
GPIO.setup(18, GPIO.OUT)  # LED

lcd = CharLCD('PCF8574', 0x27)

try:
    while True:
        light = GPIO.input(16)
        lcd.clear()
        if light == GPIO.LOW:  # Dark
            lcd.write_string("Dark - LED ON")
            GPIO.output(18, GPIO.HIGH)
        else:  # Light
            lcd.write_string("Light - LED OFF")
            GPIO.output(18, GPIO.LOW)
        time.sleep(1)
except KeyboardInterrupt:
    lcd.clear()
    GPIO.cleanup()
