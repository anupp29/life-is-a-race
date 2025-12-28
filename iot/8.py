import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
from flask import Flask
import time

app = Flask(__name__)
GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT)

lcd = CharLCD('PCF8574', 0x27)

@app.route('/')
def home():
    return '<button onclick="fetch(\'/on\')">ON</button><button onclick="fetch(\'/off\')">OFF</button>'

@app.route('/on')
def on():
    GPIO.output(18, GPIO.HIGH)
    lcd.clear()
    lcd.write_string("LED ON via Web")
    time.sleep(2)
    lcd.clear()
    return 'LED ON'

@app.route('/off')
def off():
    GPIO.output(18, GPIO.LOW)
    lcd.clear()
    lcd.write_string("LED OFF via Web")
    time.sleep(2)
    lcd.clear()
    return 'LED OFF'

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
