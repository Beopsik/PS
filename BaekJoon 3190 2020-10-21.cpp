#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
#include<deque>
using namespace std;

int n, k, l;
int dy, dx;
int board[101][101];
vector <pair<int, int>> apple;
deque <pair<int, int>> snake;
vector <pair<int, char>> direction;

void turn(int y, int x, char dir)
{
	if(dir=='D'){
		if(y==-1&&x==0)
			dy=0, dx=1;
		else if(y==0&&x==1)
			dy=1, dx=0;
		else if(y==1&&x==0)
			dy=0, dx=-1;
		else if(y==0&&x==-1)
			dy=-1, dx=0;
	}else if(dir='L'){
		if(y==-1&&x==0)
			dy=0, dx=-1;
		else if(y==0&&x==-1)
			dy=1, dx=0;
		else if(y==1&&x==0)
			dy=0, dx=1;
		else if(y==0&&x==1)
			dy=-1, dx=0;
	}
}
int move(int y, int x)
{
	int time=0;
	int idx=0;
	int turn_time;
	char dir;
	
	while(true){
		pair <int, int> temp;
		
		turn_time=direction[idx].first;
		dir=direction[idx].second;
		
		y+=dy;
		x+=dx;
		time++;
		if(y>n||y<1||x>n||x<1||board[y][x]==1)
			break;
		if(board[y][x]==-1){
			board[y][x]=1;
			snake.push_front(make_pair(y, x));
		}else{
			board[y][x]=1;
			temp=snake.back();
			board[temp.first][temp.second]=0;
			snake.pop_back();
			snake.push_front(make_pair(y, x));
		}
		if(time==turn_time){
			turn(dy, dx, dir);
			idx++;
		}
	}
	return time;
}
int main()
{	
	
	scanf("%d %d", &n, &k);
	
	for(int i=0; i<k; i++){
		int y, x;
		scanf("%d %d", &y, &x);
		board[y][x]=-1;
		apple.push_back(make_pair(y, x));
	}
	
	scanf("%d", &l);
	for(int i=0; i<l; i++){
		int t;
		char dir;
		scanf("%d %c", &t, &dir);
		direction.push_back(make_pair(t, dir));
	}
	
	dy=0, dx=1;
	snake.push_back(make_pair(1, 1));
	int result=move(1, 1);
	
	printf("%d\n", result);
	return 0;
}













