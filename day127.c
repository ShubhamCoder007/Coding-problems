/*Let's represent an integer in a linked list format by having each node represent a digit in the number. The nodes make up the number in reversed order.

For example, the following linked list:

1 -> 2 -> 3 -> 4 -> 5
is the number 54321.

Given two linked lists in this format, return their sum in the same linked list format.

For example, given

9 -> 9
5 -> 2
return 124 (99 + 25) as:

4 -> 2 -> 1
*/


#include<stdio.h>
#include<malloc.h>

typedef struct node
{
	int data;
	struct node* next;
}N;

N* newNode(int data){
	N* n = (N*)malloc(sizeof(N));
	n->data = data;
	n->next = NULL;
	return n;
}

N* insert(N* head, int data){
	if(head == NULL)
		head = newNode(data);
	
	else{
		N* temp = head;
		for(; temp->next != NULL; temp = temp->next);
		temp->next = newNode(data);
	}
		
	return head;
}

N* getNumLink(int num){
	N* head = NULL;
	while(num > 0){
		head = insert(head, num%10);
		num = num / 10;
	}
	
	return head;
}

int getNum(N* head){
	int s = 0, d = 0;
	
	while(head != NULL){
		s = s*10 + head->data;
		head = head->next;
	}
	
	do{
		int r = s % 10;
		d = d * 10 + r;
		s /= 10;
	}while(s > 0);
	
	return d;
}

N* sum(N* h1, N* h2){
	int n1 = getNum(h1);
	int n2 = getNum(h2);
	printf("nums: %d %d ,",n1,n2);
	return getNumLink(n1 + n2);
}

void display(N* head){
	if(head == NULL)
		return;
	N* temp = head;
	for(; temp != NULL; temp = temp->next)
		printf("%d -> ",temp->data);
	printf("\n");
}

int main()
{
	int n1 = 0, n2 = 0;
	printf("Enter the 2 numbers: ");
	scanf("%d %d",&n1,&n2);
	
	N* head1 = getNumLink(n1);
	N* head2 = getNumLink(n2);
	
	display(head1);
	display(head2);
	display(sum(head1, head2));
	
	return 0;
}
	
	