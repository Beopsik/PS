#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> com;

int dx[]={-1, 1, 0, 0};
int dy[]={0, 0, -1, 1};
int map[26][26];
int n;
int room;

void dfs(int i, int j)
{
    map[i][j]=0;
    room++;
    
    for(int t=0; t<4; t++)
    {
        if(i+dy[t]<0||i+dy[t]>=n||j+dx[t]<0||j+dx[t]>=n)
            continue;
        
        if(map[i+dy[t]][j+dx[t]]==1)
        {
            dfs(i+dy[t],j+dx[t]);
        }
    }
}
int main()
{
    scanf("%d", &n);
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            scanf("%1d", &map[i][j]);
        }
    }
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            if(map[i][j]==1)
			{
                room=0;
                dfs(i, j);
                com.push_back(room);
			}
        }
    }
    sort(com.begin(), com.end());
    
    printf("%d\n",com.size());
    
    for(int i=0; i<com.size(); i++)
    {
        printf("%d\n", com[i]);
    }
    
    return 0;
}








