#include<cstdio>
#include<iostream>
#include <queue>
using namespace std;

bool check[1000000];
int f,s, g, u,d;

int up(int num)
{
	if(num+u>f)
		return num;
	else
		return num+u;
}
int down(int num)
{
	if(num-d<1)
		return num;
	else
		return num-d;
}
int main(){
	
	queue<pair<int, int>> q;
	int now_floor, now_count;
	int up_floor, down_floor;
	int stair=0;
	
	scanf("%d %d %d %d %d", &f, &s, &g, &u, &d);
	
	q.push(pair<int, int>(s, 0));
	check[s]=true;
	while(!q.empty()){
		pair<int, int> temp=q.front();
		q.pop();
		
		if(temp.first==g){
			printf("%d\n", temp.second);
			stair=1;
			break;
		}
		int now_floor=temp.first;
		int now_count=temp.second+1;
		
		up_floor=up(now_floor);
		if(check[up_floor]==false){
			q.push(pair<int, int>(up_floor, now_count));
			check[up_floor]=true;
		}
		down_floor=down(now_floor);
		if(check[down_floor]==false){
			q.push(pair<int, int>(down_floor, now_count));
			check[down_floor]=true;
		}
	}
	
	if(stair==0){
		printf("use the stairs\n");
	}
	
	return 0;
}













