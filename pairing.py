''' This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr. '''

def fun(a,b):
	return lambda num: num(a,b)
	
def sum(num):
	return num(lambda a,b: a+b)
	
def sub(num):
	return num(lambda a,b: a-b)
	
def div(num):
	def pair(a,b):
		return a/b 
	return num(pair)

def mul(num):
	return num(lambda a,b: a*b)
	
print(sum(fun(1,2)))
print(sub(fun(1,2)))
print(div(fun(1,2)))
print(mul(fun(3,2)))