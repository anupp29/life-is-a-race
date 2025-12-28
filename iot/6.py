import cv2
from RPLCD.i2c import CharLCD
import time

lcd = CharLCD('PCF8574', 0x27)

cap = cv2.VideoCapture(0)
ret, frame = cap.read()
if ret:
    cv2.imwrite('image.jpg', frame)
    lcd.clear()
    lcd.write_string("Photo Taken!")
    time.sleep(3)
    lcd.clear()
    print("Image saved!")
else:
    lcd.clear()
    lcd.write_string("Capture Failed")
    time.sleep(3)
    lcd.clear()
cap.release()
