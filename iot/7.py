import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD
import Adafruit_DHT
import requests
import time

lcd = CharLCD('PCF8574', 0x27)
pin = 4
api_key = 'YOUR_API_KEY'
sensor_type = Adafruit_DHT.DHT11

try:
    while True:
        humidity, temp = Adafruit_DHT.read_retry(sensor_type, pin)
        if temp is not None:
            lcd.clear()
            lcd.write_string(f"Temp: {temp:.1f}C")
            lcd.write_string(" Publishing...")
            url = f'https://api.thingspeak.com/update?api_key={api_key}&field1={temp}'
            response = requests.get(url)
            if response.status_code == 200:
                lcd.clear()
                lcd.write_string("Published OK!")
            else:
                lcd.clear()
                lcd.write_string("Publish Failed")
            time.sleep(3)
        time.sleep(20)
except KeyboardInterrupt:
    lcd.clear()
