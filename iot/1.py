import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)  # LED
GPIO.setup(23, GPIO.IN, pull_up_down=GPIO.PUD_UP)  # Switch
GPIO.setup(24, GPIO.OUT)  # Buzzer

try:
    while True:
        if GPIO.input(23) == GPIO.LOW:  # Pressed
            GPIO.output(18, GPIO.HIGH)
            GPIO.output(24, GPIO.HIGH)
        else:
            GPIO.output(18, GPIO.LOW)
            GPIO.output(24, GPIO.LOW)
        time.sleep(0.1)
except KeyboardInterrupt:
    GPIO.cleanup()
