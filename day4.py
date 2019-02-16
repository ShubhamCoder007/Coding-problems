'''Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.'''


'''
def lowest_positive(a):
	min_list = [i for i in range(1,len(a)+1)]
	if min_list in a:
		return lowest_positive([i for i in range(len(a),2*len(a)+1)])
	else:
		for i in min_list:
			if i in a:
				continue
			else:
				return i  '''
		
def lowest_positive(a):
	a = dump_neg(a)
	i = 1
	for j in range(0,len(a)):
		if min(a) > i:
			return i 
		else:
			i = min(a)
			a.remove(min(a))
			i = i + 1
	return i
		
def dump_neg(a):
	for i in a:
		if i < 0:
			a.remove(i)
	print(a)
	return a
		
a = [3, 4, -1, 1, 2 , 5, 9, -7]
print(lowest_positive(a))
a = [1, 2, 0]
print(lowest_positive(a))