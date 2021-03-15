#include <iostream>
#include <cstdio>
#include <algorithm>
#include <queue>

using namespace std;

int N, K;
int up, down, teleport=0;
int res=100000;
bool check[100001];

void find(int n, int cnt)
{
	queue<pair<int, int>> q;
	
	q.push(pair<int, int>(n, cnt));
	check[n]=true;
	
	while(!q.empty())
	{
		pair<int, int>temp=q.front();
		q.pop();
		//printf("%d\n", temp.first);
		cnt=temp.second+1;
		up=temp.first+1;
		down=temp.first-1;
		teleport=2*temp.first;
		
		if(up==K||down==K||teleport==K){
			res=min(res, cnt);
			//printf("%d\n", res);
		}
		if(up>=0&&up<=100000&&check[up]==false){
			q.push(pair<int, int>(up, cnt));
			check[up]=true;
		}
		if(down>=0&&down<=100000&&check[down]==false){
			q.push(pair<int, int>(down, cnt));
			check[down]=true;
		}
		if(teleport>=0&&teleport<=100000&&check[teleport]==false){
			q.push(pair<int, int>(teleport, cnt));
			check[teleport]=true;
		}
	}
}
int main(void)
{	
	scanf("%d %d", &N, &K);
	if(N!=K){
		find(N, 0);
		printf("%d\n", res);
	}
	else{
		printf("%d\n", 0);
	}
    return 0;
}







