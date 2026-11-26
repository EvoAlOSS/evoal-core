"""Writes data.json: y = 2x + 1 with a noise of +-0.1 on the grid x = 0.05, 0.1, ..., 1, and two
outliers (y = 10) inside the gap 0.7 <= x <= 0.8 that the validation pipeline cuts out."""
import json

rows = []
for i in range(1, 21):
    x = i / 20
    noise = 0.1 if i % 2 == 0 else -0.1
    rows.append((x, 2 * x + 1 + noise))
rows += [(0.72, 10.0), (0.76, 10.0)]

with open("data.json", "w", encoding="utf-8") as file:
    json.dump([[{"name": "x:0", "value": x}, {"name": "y:0", "value": y}] for x, y in rows], file)
