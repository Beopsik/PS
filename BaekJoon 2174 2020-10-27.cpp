#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
#include<deque>
#include<tuple>

using namespace std;

int a, b;
int n, m;
int ro_x, ro_y;
int ro_dx, ro_dy;
char ro_dir;
int board[101][101];
bool crash_w;
bool crash_r;

vector <tuple<int, int, char>> robot;
vector <tuple<int, char, int>> direction;

void turn(int y, int x, char dir)
{
	if(dir=='L'){
		if(y==1&&x==0)
			ro_dy=0, ro_dx=-1, ro_dir='W';
		else if(y==0&&x==-1)
			ro_dy=-1, ro_dx=0, ro_dir='S';
		else if(y==-1&&x==0)
			ro_dy=0, ro_dx=1, ro_dir='E';
		else if(y==0&&x==1)
			ro_dy=1, ro_dx=0, ro_dir='N';
	}else if(dir='R'){
		if(y==1&&x==0)
			ro_dy=0, ro_dx=1, ro_dir='E';
		else if(y==0&&x==1)
			ro_dy=-1, ro_dx=0, ro_dir='S';
		else if(y==-1&&x==0)
			ro_dy=0, ro_dx=-1, ro_dir='W';
		else if(y==0&&x==-1)
			ro_dy=1, ro_dx=0, ro_dir='N';
	}
}
void move()
{
	
	int ro_idx;
	char dir;
	int cnt;
	
	for(int i=0; i<direction.size(); i++){
		
		ro_idx=get<0>(direction[i]);
		dir=get<1>(direction[i]);
		cnt=get<2>(direction[i]);
		
		ro_x=get<0>(robot[ro_idx-1]);
		ro_y=get<1>(robot[ro_idx-1]);
		ro_dir=get<2>(robot[ro_idx-1]);
		
		if(ro_dir=='N'){
			ro_dx=0;
			ro_dy=1;
		}else if(ro_dir=='W'){
			ro_dx=-1;
			ro_dy=0;
		}else if(ro_dir=='S'){
			ro_dx=0;
			ro_dy=-1;
		}else if(ro_dir=='E'){
			ro_dx=1;
			ro_dy=0;
		}
		
		if(dir=='F'){
			board[ro_y][ro_x]=0;
			for(int j=0; j<cnt; j++){
				ro_y+=ro_dy;
				ro_x+=ro_dx;
				if(ro_x>a||ro_x<1||ro_y>b||ro_y<1){
					crash_w=true;
					printf("Robot %d crashes into the wall\n", ro_idx);
					return;
				}else if(board[ro_y][ro_x]>0){
					crash_r=true;
					printf("Robot %d crashes into robot %d\n", ro_idx, board[ro_y][ro_x]);
					return;
				}
			}
			board[ro_y][ro_x]=ro_idx;
			robot[ro_idx-1]=make_tuple(ro_x, ro_y, ro_dir);
		}else if(dir=='L'||dir=='R'){
			for(int j=0; j<cnt; j++){
				turn(ro_dy, ro_dx, dir);
			}
			robot[ro_idx-1]=make_tuple(ro_x, ro_y, ro_dir);
		}
	}
}
int main()
{	
	int result;
	scanf("%d %d", &a, &b);
	scanf("%d %d", &n, &m);
	
	for(int i=0; i<n; i++){
		int x, y;
		char dir;
		scanf("%d %d %c", &x, &y, &dir);
		board[y][x]=i+1;
		robot.push_back(make_tuple(x, y, dir));
	}
	for(int i=0; i<m; i++){
		int r, cnt;
		char dir;
		scanf("%d %c %d", &r, &dir, &cnt);
		direction.push_back(make_tuple(r, dir, cnt));
	}
	
	move();
	
	if(crash_r==false&&crash_w==false)
		printf("OK\n");
	
	return 0;
}














