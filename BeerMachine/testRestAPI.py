import requests

#---------- CREATE Batch -----------#
#url = 'http://localhost:8081/batch/add'
#batch = {'amount': 10,
#        'typeId': 1}

#x = requests.post(url, json = batch)

#url = 'http://localhost:8081/batch/add'
#batch = {'amount': 20,
#        'typeId': 2}

#x = requests.post(url, json = batch)

#url = 'http://localhost:8081/batch/add'
#batch = {'amount': 30,
#        'typeId': 3}

#x = requests.post(url, json = batch)


#---------- CREATE TYPE -----------#
#url = 'http://localhost:8081/type/add'
#type = {'name': 'Pilsner'}

#x = requests.post(url, json = type)

#url = 'http://localhost:8081/type/add'
#type = {'name': 'IPA'}

#x = requests.post(url, json = type)

#url = 'http://localhost:8081/type/add'
#type = {'name': 'Alcohol_Free'}

#x = requests.post(url, json = type)


#---------- CREATE BatchReport -----------#
#url = 'http://localhost:8081/batchReport/add'
#batchReport = {'batchId': 5,
#               'speed': 50,
#               'totalCount': 540}

#x = requests.post(url, json = batchReport)

#url = 'http://localhost:8081/batchReport/add'
#batchReport = {'batchId': 6,
#               'speed': 20,
#               'totalCount': 123}

#x = requests.post(url, json = batchReport)

#url2 = 'http://localhost:8081/batchReport/add'
#batchReport = {'batchId': 7,
#               'speed': 80,
#               'totalCount': 345}

#x = requests.post(url2, json = batchReport)

#---------- CREATE Humidity -----------#
        #TimePattern: dd/MM/yyyy HH:mm:ss
url = 'http://localhost:8081/humidity/add'
humidity = {'batchReportId': 8,
            'humidity': 100,
            'timestamp': '09/11/2021 19:18:50'}

x = requests.post(url, json = humidity)

#url = 'http://localhost:8081/humidity/add'
#humidity = {'batchReportId': 9,
#            'humidity': 50,
#            'timestamp': '09/11/2021 18:51:00'}

#x = requests.post(url, json = humidity)

#url2 = 'http://localhost:8081/humidity/add'
#humidity = {'batchReportId': 10,
#            'humidity': 50,
#            'timestamp': '09/11/2021 18:51:10'}

#x = requests.post(url2, json = humidity)
print(x.text)
