#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
#include<stack>
using namespace std;

struct Node {
	int data;
	Node * next;
};
Node * list;
void init() {

	if (list == NULL) {
		return;
	}
	else {
		Node * cur;
		cur = list;

		while (cur != NULL) {
			list = cur->next;
			free(cur);
			cur = list;
		}
	}
}
void add(int key) {

	Node * new_node = (Node*)malloc(sizeof(Node));
	new_node->data = key;
	new_node->next = NULL;

	// Check first element
	if (list == NULL) {
		list = new_node;
	}
	else {
		// Add new node to head
		new_node->next = list;
		list = new_node;
	}
}
bool remove(int key) {

	if (list == NULL) {
		return false;
	}

	if (list->data == key) {
		Node * cur = list;
		list = list->next;
		free(cur);
		return true;
	}
	else {
		Node * cur = list->next;
		Node * prev = list;
		while (cur != NULL && cur->data != key) {
			prev = cur;
			cur = cur->next;
		}

		if (cur == NULL) return false;

		prev->next = cur->next;
		free(cur);
		return true;
	}
}
void traverse() {

	Node * cur = list;
	while (cur != NULL) {
		printf("%d ", cur->data);
		cur = cur->next;
	}
	printf("\n");

}
int num[100001];
int result[100001];

int main() {
    
    int n, k=0;
    int t=1;
    int count;
	int list_count;
	
	scanf("%d %d", &n, &k);
	
	for(int i=n; i>=1; i--)
	{
	    num[n-i+1]=i;
	}
	init();
	for(int i=1; i<=n; i++)
	{
	    add(num[i]);
	}
	Node *cur=list;
	while(cur!=NULL)
	{
	    cur=cur->next;
	}
	count=k;
	list_count=n;
	printf("<");
	while(true)
	{
	    cur=list;
	    for(; cur!=NULL; cur=cur->next)
	    {
    	    count--;
    	    if(count==0&&list_count!=1)
    	    {
    	        printf("%d, ", cur->data);
    	        result[t]=cur->data;
    	        remove(cur->data);
    	        list_count--;
    	        count=k;
    	        t++;
    	    }
    	    else if(count==0&&list_count==1)
    	    {
    	        printf("%d>", cur->data);
    	        result[t]=cur->data;
    	        remove(cur->data);
    	        list_count--;
    	        count=k;
    	        t++;
    	    }
	    }
	    if(list_count==0)
	        break;
	}
	return 0;
}








