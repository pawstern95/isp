import numpy as np
from sklearn import datasets, linear_model, metrics


X = np.array([[1,21,87,1016,0],[1,21,88,1016,0],[1,19,83,1017,10],[1,17,84,1017,10],[1,19,84,1015,6],[1,17,84,1014,0],[1,19,88,1014,0],[1,19,84,1016,0],[1,19,86,1016,0],[1,21,87,1016,0]])

y = np.array([22,21.5,20.5,17.5,20.5,18,20.5,21,20,22])

reg = linear_model.LinearRegression()
reg.fit(X,y)

print("Coefficients: ", reg.coef_)