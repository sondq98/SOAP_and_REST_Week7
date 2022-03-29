import sys
import zeep

# SOAP request URL
url = "http://localhost:8080/cc/calculator.wsdl"

client = zeep.Client(wsdl=url)

expressionRequest = sys.argv[1] + " " + sys.argv[2] + " " + sys.argv[3]

print(client.service.getExpressionResult(expressionRequest))

