import sys
import zeep
import requests

# SOAP request URL

if sys.argv[2] == "+":
    operator = 'add'
elif sys.argv[2] == "-":
    operator = 'sub'
elif sys.argv[2] == "*":
    operator = 'mul'
elif sys.argv[2] == "/":
    operator = 'div'
elif sys.argv[2] == "**":
    operator = 'pow'

operands = sys.argv[1] + "_" + sys.argv[3]

url = "http://localhost:5000/calculator/" + operator + "?operands=" + operands

response = requests.get(url)

print(response.json())

