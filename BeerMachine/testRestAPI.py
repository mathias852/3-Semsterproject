
import requests


url = 'http://localhost:8081/machine/stop'
x = requests.post(url)


'''# ---------- CREATE TYPE -----------#
url = 'http://localhost:8081/type/add'
type = {'name': 'Pilsner',
        'idealCycleTime': 437,
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

x = requests.post(url, json = type)'''

'''#---------- CREATE Batch -----------#
url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 1,
       'speed': 300}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 1,
       'speed': 540}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 1000,
       'typeId': 2,
       'speed': 300}

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

x = requests.post(url, json = batch) '''

#---------- CREATE BatchReport -----------#
#url = 'http://localhost:8081/batchReport/add'
#batchReport = {'batchId': 1,
#              'speed': 50,
#              'totalCount': 540}

#x = requests.post(url, json = batchReport)

#url = 'http://localhost:8081/batchReport/add'
#batchReport = {'batchId': 2,
#              'speed': 20,
#              'totalCount': 123}

#x = requests.post(url, json = batchReport)

#url2 = 'http://localhost:8081/batchReport/add'
#batchReport = {'batchId': 3,
#              'speed': 80,
#              'totalCount': 345}

#x = requests.post(url2, json = batchReport)

#---------- CREATE Humidity -----------#
        # TimePattern: dd/MM/yyyy HH:mm:ss
#url = 'http://localhost:8081/humidity/add'
#humidity = {'batchReportId': 7,
#            'humidity': 100,
#            'timestamp': '2021-11-15 20:33:46.000000'}

#x = requests.post(url, json = humidity)

#url = 'http://localhost:8081/humidity/add'
#humidity = {'batchReportId': 7,
#           'humidity': 50,
#           'timestamp': '2021-11-15 20:33:46.000000'}

#x = requests.post(url, json = humidity)

#url2 = 'http://localhost:8081/humidity/add'
#humidity = {'batchReportId': 7,
#           'humidity': 50,
#           'timestamp': '2021-11-15 20:33:46.000000'}

#x = requests.post(url2, json = humidity)
#print(x.text)
