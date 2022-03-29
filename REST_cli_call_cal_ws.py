from flask import Flask
from flask import request
import requests
import zeep

# SOAP request URL
url = "http://localhost:8080/cc/calculator.wsdl"
client = zeep.Client(wsdl=url)

app = Flask(__name__)
@app.route("/calculator/<operator>")
"""
API REST: http://localhost:5000/calculator/{operator}?operands={operands}
- operator : add/sub/mul/div/pow
- operands : gom 2 toan hang cach nhau bang dau _
VD: http://localhost:5000/calculator/add?operands=2_3
"""

def get_calculator_result(operator):
    operands = request.args.get('operands').split("_")
    if operator == "add":
        formatExpression = operands[0] + " + " + operands[1]
        return client.service.getExpressionResult(formatExpression)
    elif operator == "sub":
        formatExpression = operands[0] + " - " + operands[1]
        return client.service.getExpressionResult(formatExpression)
    elif operator == "mul":
        formatExpression = operands[0] + " * " + operands[1]
        return client.service.getExpressionResult(formatExpression)
    elif operator == "div":
        formatExpression = operands[0] + " / " + operands[1]
        return client.service.getExpressionResult(formatExpression)
    elif operator == "pow":
        formatExpression = operands[0] + " ** " + operands[1]
        return client.service.getExpressionResult(formatExpression)
    

if __name__ == "__main__":

    app.run()
