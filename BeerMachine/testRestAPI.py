import requests

# Start machine
url = 'http://localhost:8081/machine/start/3'
x = requests.post(url)

""" # ---------- CREATE TYPE -----------#
url = 'http://localhost:8081/type/add'
type = {'name': 'Pilsner'}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'IPA'}

x = requests.post(url, json = type)

url = 'http://localhost:8081/type/add'
type = {'name': 'Alcohol_Free'}

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

x = requests.post(url, json = batch) """