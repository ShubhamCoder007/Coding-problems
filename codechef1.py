# cook your dish here


def input_data():
    W = []
    H = []
    P = []
    print("\n")
    B = int(input("Enter the Budget: "))
    N = int(input("Enter the number of inputs: "))
    print("\n")
	for i in range(0,N):
		W.append(int(input("Width: ")))
		H.append(int(input("Height: ")))
		P.append(int(input("Price: ")))
		print("\n")
	return tablet(B,N,W,H,P)

def tablet(B,N,W,H,P):
	select = 0
	for i in range(0,N):
		if B < P[i] and B < 1:
			return "no tablet"
		elif select <= W[i]*H[i]:
			select = W[i]*H[i]
		else:
			continue
	return select	
		
cases = int(input("Enter the number of cases: "))
for i in range(0,cases):
    print(input_data())
    #print(tablet(B,N))

global B  #int(input("Enter the Budget: "))
global N  #int(input("Enter the number of inputs: "))

#input_data()
#print(tablet(B,N))