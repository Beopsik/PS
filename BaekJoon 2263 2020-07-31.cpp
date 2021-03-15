#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;
int pos_inorder[100001];
int postorder[100001];

void preOrder(int is, int ie, int ps, int pe)
{
	if(is>ie||ps>pe)
		return;
	
	int root=postorder[pe];
	printf("%d ", root);2
	
	preOrder(is, pos_inorder[root]-1, ps, ps+pos_inorder[root]-is-1);
	preOrder(pos_inorder[root]+1, ie, ps+pos_inorder[root]-is, pe-1);
}
int main() {

	int n;
	int in;
	
	scanf("%d", &n);
	
	for(int i=0; i<n; i++){
		scanf("%d", &in);
		pos_inorder[in]=i;
	}
	
	for(int i=0; i<n; i++){
		scanf("%d", &postorder[i]);
	}

	preOrder(0, n-1, 0, n-1);
	
	return 0;
}













