#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
#include<deque>
#include<queue>
#include<tuple>

using namespace std;

int dy1[4][1]={{-1}, {0}, {1}, {0}};
int dx1[4][1]={{0}, {1}, {0}, {-1}};
int dy2[2][2]={{0, 0}, {-1, 1}};
int dx2[2][2]={{-1, 1}, {0, 0}};
int dy3[4][2]={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int dx3[4][2]={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
int dy4[4][3]={{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {-1, 0, 1}};
int dx4[4][3]={{-1, 0, 1}, {0, 1, 0}, {1, 0, -1}, {0, -1, 0}};
int dy5[1][4]={{-1, 0, 1, 0}};
int dx5[1][4]={{0, 1, 0, -1}};

vector <pair<int, int>> coordi;
int board[8][8];
int check[8][8];
int n, m;
int MIN=64;

int blind(int dir_y[], int dir_x[],int len, int y, int x, int blindNum)
{
	for(int i=0; i<len; i++){
		int temp_y=y;
		int temp_x=x;
		while(true){
			temp_y+=dir_y[i];
			temp_x+=dir_x[i];
			if(board[temp_y][temp_x]==6||temp_y<0||temp_y>=n||temp_x<0||temp_x>=m)
				break;
			if(board[temp_y][temp_x]>=1&&board[temp_y][temp_x]<=5)
				continue;
			
			if(check[temp_y][temp_x]==0)
				blindNum--;
			check[temp_y][temp_x]-=board[y][x];
		}
	}
	return blindNum;
}
void recover(int dir_y[], int dir_x[],int len, int y, int x)
{
	for(int i=0; i<len; i++){
		int temp_y=y;
		int temp_x=x;
		while(true){
			temp_y+=dir_y[i];
			temp_x+=dir_x[i];
			if(board[temp_y][temp_x]==6||temp_y<0||temp_y>=n||temp_x<0||temp_x>=m)
				break;
			if(board[temp_y][temp_x]>=1&&board[temp_y][temp_x]<=5)
				continue;
			
			if(check[temp_y][temp_x]<0){
				check[temp_y][temp_x]+=board[y][x];
			}
		}
	}
}
int cctv(int idx, int blindNum)
{
	if(idx>=coordi.size()){
		return blindNum;
	}
	int y=coordi[idx].first;
	int x=coordi[idx].second;
	int cctvNum=board[y][x];
	int temp;
	switch(cctvNum){
		case 1:
			for(int i=0; i<4; i++){
				temp=min(blindNum, blind(dy1[i], dx1[i], sizeof(dy1[i])/sizeof(int), y, x, blindNum));
				MIN=min(MIN, cctv(idx+1, temp));
				recover(dy1[i], dx1[i], sizeof(dy1[i])/sizeof(int), y, x);
			}
			break;
		case 2:
			for(int i=0; i<2; i++){
				temp=min(blindNum, blind(dy2[i], dx2[i], sizeof(dy2[i])/sizeof(int), y, x, blindNum));
				MIN=min(MIN, cctv(idx+1, temp));
				recover(dy2[i], dx2[i], sizeof(dy2[i])/sizeof(int), y, x);
			}
			break;
		case 3:
			for(int i=0; i<4; i++){
				temp=min(blindNum, blind(dy3[i], dx3[i], sizeof(dy3[i])/sizeof(int), y, x, blindNum));
				MIN=min(MIN, cctv(idx+1, temp));
				recover(dy3[i], dx3[i], sizeof(dy3[i])/sizeof(int), y, x);
			}
			break;
		case 4:
			for(int i=0; i<4; i++){
				temp=min(blindNum, blind(dy4[i], dx4[i], sizeof(dy4[i])/sizeof(int), y, x, blindNum));
				MIN=min(MIN, cctv(idx+1, temp));
				recover(dy4[i], dx4[i], sizeof(dy4[i])/sizeof(int), y, x);
			}
			break;
		case 5:
			for(int i=0; i<1; i++){
				temp=min(blindNum, blind(dy5[i], dx5[i], sizeof(dy5[i])/sizeof(int), y, x, blindNum));
				MIN=min(MIN, cctv(idx+1, temp));
				recover(dy5[i], dx5[i], sizeof(dy5[i])/sizeof(int), y, x);
			}
			break;
	}
	
	return MIN;
}
int main()
{	
	int result;
	
	scanf("%d %d", &n, &m);
	int blindNum=n*m;
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%d", &board[i][j]);
			if(board[i][j]!=0){
				blindNum--;
				check[i][j]=board[i][j];
			}
			if(board[i][j]>=1&&board[i][j]<=5){
				coordi.push_back(make_pair(i, j));
			}
		}
	}
	
	result=cctv(0, blindNum);
	printf("%d\n", result);
	
	return 0;
}














