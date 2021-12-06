
import requests



url = 'http://localhost:8081/machine/reset'
x = requests.post(url)


 # ---------- CREATE TYPE -----------#
url = 'http://localhost:8081/type/add'
type = {'name': 'Pilsner',
        'maxSpeed': 600}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'IPA',
        'maxSpeed': 300}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'Alcohol_Free',
        'maxSpeed': 125}

x = requests.post(url, json = type)


#---------- CREATE Batch -----------#
url = 'http://localhost:8081/batch/add'
batch = {'amount': 10,
       'typeId': 1}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 20,
        'typeId': 2}

x = requests.post(url, json = batch)

url = 'http://localhost:8081/batch/add'
batch = {'amount': 30,
        'typeId': 3}

x = requests.post(url, json = batch)


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
