l = 'abcdefghijklmnopqrstuvwxyz'
letter = {str(i+1):l[i] for i in range(0,26)}

def create_combination(s):
	a = []
	for i in s:
		a.append(i)
	for j in range(0,len(s)):
		if int(s[j:j+2]) < 27:
			a.append(s[j:j+2])
	#a.append(s[-2:])
	return a

def generate(s):
	a = create_combination(s)
	for i in range(0,len(s)):
		st = st + letter[i]
		
	
print(create_combination('111126'))




'''
def create_combination(a):
	b = a
	for i in a:
		for j in a:
			if int(i+j) < 27:
				b.append(i+j)
	return b
	

def generate_lookup(s):
	a = []
	for c in s:
		if c not in a:
			a.append(c)
	return create_combination(a)

	
print(generate_lookup('1121'))


def decrypt(n):
	if n > 26:
		return
	'''