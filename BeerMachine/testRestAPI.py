import requests

# ---------- CREATE TYPE -----------#
url = 'http://localhost:8081/type/add'
type = {'name': 'Pilsner',
        'idealCycleTime': 460,
        'maxSpeed': 600}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'Wheat',
        'idealCycleTime': 300,
        'maxSpeed': 300}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'IPA',
        'idealCycleTime': 150,
        'maxSpeed': 150}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'Stout',
        'idealCycleTime': 200,
        'maxSpeed': 200}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'Ale',
        'idealCycleTime': 100,
        'maxSpeed': 100}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'Alcohol Free',
        'idealCycleTime': 125,
        'maxSpeed': 125}

x = requests.post(url, json = type)

#---------- CREATE Batch -----------#
url = 'http://localhost:8081/batch/add'
batch = {'amount': 10000,
       'typeId': 1,
       'speed': 460}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 1,
       'speed': 540}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'

batch = {'amount': 1000,
       'typeId': 3,
       'speed': 150}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 4,
       'speed': 200}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 5,
       'speed': 100}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 6,
       'speed': 125}

x = requests.post(url, json = batch)
