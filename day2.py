'''Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?'''

def process_list(a):
	fact = 1
	b = []
	for i in a:
		fact = fact * i
	for i in a:
		b.append(int(fact/i))
	return b
	
def process_list_nodiv(a):
	fact = 1
	b = {}
	res = []
	for i in a:
		fact = fact * i
	for i in a:
		if i in b:
			res.append(b[i])
			continue
		for j in range(1,fact+1):
			if i*j is fact:
				b[i]=j
				res.append(j)
	return res
	
a = [1,2,3,4,5]
print(process_list(a))
print(process_list_nodiv(a))
a = [3, 2, 1]
print(process_list(a))
print(process_list_nodiv(a))
