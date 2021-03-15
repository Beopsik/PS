#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<queue>

using namespace std;

struct Coor{
	int x=0;
	int y=0;
	int pri=0;
};
int dx[4]={1, -1, 0,  0};
int dy[4]={0, 0, 1, -1};

char arr[100][100];
int ans[100][100];
queue <Coor> q;
int n, m;

bool compare(Coor a, Coor b)
{
	return a.pri<b.pri;
}
void bfs()
{
	Coor c[4];
	check[0][0]=true;
	c[0].x=0;
	c[0].y=0;
	c[0].pri=0;
	q.push(c[0]);
	
	while(!q.empty()){
		int j=0;
		memset(c, 0, sizeof(c));
		Coor temp=q.front();
		q.pop();
		for(int i=0; i<4; i++){
			if(temp.x+dx[i]<m&&temp.x+dx[i]>=0&&temp.y+dy[i]<n&&temp.y+dy[i]>=0){
				c[j].x=temp.x+dx[i];
				c[j].y=temp.y+dy[i];
				if(arr[temp.y+dy[i]][temp.x+dx[i]]-'0'==1)
					c[j].pri=temp.pri+1;
				else
					c[j].pri=temp.pri;
				j++;
			}
		}
		sort(c, c+j, compare);

		for(int k=0; k<j; k++){
			if(ans[c[k].y][c[k].x]>c[k].pri){
				q.push(c[k]);
				ans[c[k].y][c[k].x]=c[k].pri;
			}
		}
	}
	
}
int main(){
	
	scanf("%d %d", &m, &n);
	memset(ans, 10000, sizeof(ans));
	for(int i=0; i<n; i++){
		scanf("%s", arr[i]);
	}
	if(m==1&&n==1){
		printf("0\n");
		return 0;
	}
	bfs();
	printf("%d\n", ans[n-1][m-1]);
	
	return 0;
}














