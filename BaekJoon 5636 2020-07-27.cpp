#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

typedef struct node {
	int data;
	node* left = NULL;
	node* right = NULL;
}node;

void postOrder(node *n)
{
	if (n != NULL) {
		postOrder(n->left);
		postOrder(n->right);
		printf("%d\n", n->data);
	}
}
int main() {

	node *root = new node;
	node *cur = new node;
	int num;

	scanf("%d", &root->data);

	while (scanf("%d", &num) != EOF) {
		cur = root;
		while (1) {
			if (num<cur->data) {
				if (cur->left != NULL)
					cur = cur->left;
				else {
					cur->left = new node;
					cur->left->data = num;
					break;
				}
			}
			else {
				if (cur->right != NULL)
					cur = cur->right;
				else {
					cur->right = new node;
					cur->right->data = num;
					break;
				}
			}
		}
	}

	postOrder(root);

	return 0;
}














