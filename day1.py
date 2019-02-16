'''Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?'''


a = [10, 15, 3, 7]
target = int(input("Enter the target: "))


def list_input(n):
	for i in range(1,n):
		a.append(int(input("Enter the number:")))

		
def compute(target, a):
	for i,j in zip(a,range(1,len(a))):
		if target < min(a):
			return False
		if i is target:
			return True
		elif target - i in a:
			return True
		else:
			return compute(target - i,a) or compute(target, a[j:])
			
print(compute(target,a))