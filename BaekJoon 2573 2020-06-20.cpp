#include<cstdio>
#include<iostream>
#include<cstring>
#include<algorithm>
#include<queue>

using namespace std;
int arr[300][300];
int test[300][300];
bool check[300][300];
int n, m;

int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};
int cnt;
int year;

void dfs(int y, int x)
{	
	int zero_count=0;
	
	queue <pair<int, int>> next;
	
	check[y][x]=true;
	
	for(int i=0; i<4; i++){
		if(y+dy[i]<n&&y+dy[i]>=0&&x+dx[i]<m&&x+dx[i]>=0){
			if(arr[y+dy[i]][x+dx[i]]==0){
				zero_count++;
			}else if(arr[y+dy[i]][x+dx[i]]!=0&&check[y+dy[i]][x+dx[i]]==false){
				next.push(pair<int, int>(y+dy[i], x+dx[i]));
			}	
		}
	}
	
	if(test[y][x]>=zero_count)
		test[y][x]-=zero_count;
	else
		test[y][x]=0;
	while(!next.empty()){
		pair<int, int> temp=next.front();
		next.pop();
		if(check[temp.first][temp.second]==false)
			dfs(temp.first, temp.second);
	}
}
void icebergCount(int y, int x)
{	
	check[y][x]=true;
	
	for(int i=0; i<4; i++){
		if(y+dy[i]<n&&y+dy[i]>=0&&x+dx[i]<m&&x+dx[i]>=0){
			if(arr[y+dy[i]][x+dx[i]]!=0&&check[y+dy[i]][x+dx[i]]==false){
				icebergCount(y+dy[i], x+dx[i]);
			}
		}
	}
}

int main(){
	
	scanf("%d %d", &n, &m);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%d", &arr[i][j]);
			test[i][j]=arr[i][j];
		}
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(arr[i][j]==0)
				continue;
			else{
				memset(check, false, sizeof(check));
				cnt=0;
				for(int N=0; N<n; N++){
					for(int M=0; M<m; M++){
						if(arr[N][M]==0||check[N][M]==true)
							continue;
						else{
							icebergCount(N, M);
							cnt++;
						}
					}
				}
				if(cnt>=2){
					printf("%d\n", year);
					return 0;
				}
				memset(check, false, sizeof(check));
				dfs(i, j);
				year++;
				for(int N=0; N<n; N++){
					for(int M=0; M<m; M++)
						arr[N][M]=test[N][M];
				}
			}
		}
	}
	printf("0");
	return 0;
}













