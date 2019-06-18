/*Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.

For example, given the following tree and K of 20

    10
   /   \
 5      15
       /  \
     11    15
Return the nodes 5 and 15*/



#include<stdio.h>
#include<stdbool.h>
#include<malloc.h>
 
 typedef struct node
 {
	 int data;
	 struct node* left;
	 struct node* right;
 }N;
 
 N* newNode(int data){
	 N* n = (N*)malloc(sizeof(N));
	 n->data = data;
	 n->left = n->right = NULL;
	 return n;
 }
 
 N* insert(N* root, int data){
	 if(root == NULL){
		 root = newNode(data);
		 return root;
	 }
	 
	 if(root->data > data)
		 root->left = insert(root->left, data);
	 else
		 root->right = insert(root->right, data);
	 
	 return root;
 }
 
 void inorderDisplay(N* root){
	 if(root == NULL)
		 return;
	 inorderDisplay(root->left);
	 printf("%d ",root->data);
	 inorderDisplay(root->right);
 }
 
 int getNumNodes(N* root){
	 if(root == NULL)
		 return 0;
	 return getNumNodes(root->left) + getNumNodes(root->right) + 1;
 }
 
 
 
 //Logic 1
void sumNodes(N* root, int* k, int res[], int* fill){
	if(root == NULL || *k == 0)
		return;
	
	if(*k < root->data && root->left != NULL){
		sumNodes(root->left, k, res, fill);
		if(*k == root->data){
			*fill = *fill + 1;
			res[*fill] = root->data;
			*k = *k - root->data;
		}
		return;
	}
	
	if(*k > root->data)
		sumNodes(root->right, k, res, fill);
	
	if(*k >= root->data){
		if(*fill == -1){
			*fill = *fill + 1;
			res[*fill] = root->data;
			*k = *k - root->data;
			return;
		}
		if(root->data + res[0] == *k){
			*fill = *fill + 1;
			res[*fill] = root->data;
			*k = *k - root->data;
			return;
		}
		sumNodes(root->left, k, res, fill);
	}
	
}
	
	int* sumNodesUtil(N* root, int k, int res[]){

		int fill = -1;
		sumNodes(root, &k, res, &fill);
		
		return res;
	}
 
 
 
 //Logic 2
 
 bool check(N* root, int data){
	 if(root->data == data)
		 return true;
	 
	 if(root->data > data)
		return check(root->left, data);
	 else
		return check(root->right, data);
	 
	 return false;
 }
 
 int sum(N* root, int k){

	 if(root == NULL)
		 return 0;
	 
	 if(k - root->data < root->data){
		 if(check(root->left, k - root->data))
			 return root->data;
	 }
	 else{
		 if(check(root->right, k - root->data))
			 return root->data;
	 }
	 
	 sum(root->left, k);
	 sum(root->right, k);
	 
	 return 0;
 }
	
	
	 
	 

  void displayArr(int* a, int n){
	 int i = 0;
	 printf("\n");
	 for(; i < n; i++)
		 printf("%d ",a[i]);
 }
 
 int main()
 {
	 N* root = NULL;
	 root = insert(root, 10);
	 root = insert(root, 5);
	 root = insert(root, 15);
	 root = insert(root, 11);
	 root = insert(root, 15);
	 
	 inorderDisplay(root);
	 
	 int k = 0;
	 printf("\nEnter the value: ");
	 scanf("%d",&k);
	 
	 //int* res = (int*)malloc(sizeof(int));
	 //res[0] = res[1] = -1;
	 
	 printf("\n");
	 int r = sum(root, k);
	 printf("values: %d %d",r, k - r);
	 
	 return 0;
 }
	 
	 
	 