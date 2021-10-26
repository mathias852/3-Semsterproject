import requests

url = 'http://localhost:8081/batch/add'
batch = {'amount': '10',
        'type_id': '3'}

x = requests.post(url, json = batch)

print(x.text)
