s = input("Enter brackets: ")

def rev(s):
	b = ''
	for i in s:
		b = b + i
	return b

def bracket_balance(s):
	b = s[0:int(len(s)/2)]
	br = rev(b)
	print(br)
	if b + br is s:
		return True 
	return False
	
print(bracket_balance(s))
