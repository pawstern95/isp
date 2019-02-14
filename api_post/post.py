import requests
import random
import time

api_host = 'https://storm-api-model.azurewebsites.net/samples'
id = 4
temperature = 0.0
dew = 0.0
humidity = 0.0
pressure = 0.0
wind = 0.0

while(True):
    temperature = random.randrange(100, 350, 5)/10
    dew = random.randrange(80, 200, 5)/10
    humidity = random.randrange(500, 900, 1)/10
    pressure = random.randrange(970, 1030, 1)
    wind = random.randrange(0, 100, 1)/10
    requests.post(api_host, json={"id":id, "timestamp":"1200", "temperature":temperature, "dew":dew, "humidity":humidity, "pressure":pressure, "wind":wind})
    time.sleep(15)
    id += 1