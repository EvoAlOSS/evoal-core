import json
import random

points = list()

for i in range(0, 1000):
    x = random.uniform(-5.0, 5.0)
    y = 3*x + 7
    points.append([{"name":"x:0","value":x},{"name":"y:0","value":y}])

content = json.dumps(points) # note i gave it a different name
print(content)