#include<cstdio>
#include<iostream>
#include <queue>
using namespace std;

struct Data{
	int a, b, c;
};

int A, B, C;
bool check[202][202];
bool ans[202];

int main(){

	scanf("%d %d %d", &A, &B, &C);
	
	queue <Data> q;
	q.push({0, 0, C});
	
	while(!q.empty()){
		Data now=q.front();
		q.pop();
		
		if(check[now.a][now.b])
			continue;
		
		check[now.a][now.b]=true;
		
		if(now.a==0)
			ans[now.c]=true;
		
		//A->B
		if(now.a+now.b>B)
			q.push({(now.a+now.b)-B, B, now.c});
		else
			q.push({0, now.a+now.b, now.c});
		
		//A->C
		if(now.a+now.c>C)
			q.push({(now.a+now.c)-C, now.b, C});
		else
			q.push({0, now.b, now.a+now.c});
		
		//B->A
		if(now.b+now.a>A)
			q.push({A, (now.b+now.a)-A, now.c});
		else
			q.push({now.b+now.a, 0, now.c});
		
		//B->C
		if(now.b+now.c>C)
			q.push({now.a, (now.b+now.c)-C, C});
		else
			q.push({now.a, 0, now.b+now.c});
		
		//C->A
		if(now.c+now.a>A)
			q.push({A, now.b, (now.c+now.a)-A});
		else
			q.push({now.c+now.a, now.b, 0});
		
		//C->B
		if(now.c+now.b>B)
			q.push({now.a, B, (now.c+now.b)-B});
		else
			q.push({now.a, now.c+now.b, 0});
	}
	
	for(int i=0; i<=C; i++){
		if(ans[i])
			printf("%d ", i);
	}
	printf("\n");
	
	return 0;
}













