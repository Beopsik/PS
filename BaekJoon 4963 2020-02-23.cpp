#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> com;

int map[51][51];
int dx[]={-1, 1, 0, 0, -1, 1, -1, 1};
int dy[]={0, 0, -1, 1, 1,  1, -1, -1};
int w;
int h;

void dfs(int i, int j)
{
    map[i][j]=0;
    
    for(int t=0; t<8; t++)
    {
        if(i+dy[t]<0||i+dy[t]>=h||j+dx[t]<0||j+dx[t]>=w)
            continue;
        
        if(map[i+dy[t]][j+dx[t]]==1)
        {
            dfs(i+dy[t],j+dx[t]);
        }
    }
}
int main()
{
    
    while(true)
    {
        int island=0;
        scanf("%d %d", &w, &h);
        if(w==0&&h==0)
            break;
            
        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
            {
                scanf("%d", &map[i][j]);
            }
        }
        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
            {
                if(map[i][j]==1)
    			{
                    dfs(i, j);
                    island++;
    			}
            }
        }
        com.push_back(island);
    }
    
    for(int i=0; i<com.size(); i++)
    {
        printf("%d\n", com[i]);
    }
    
    return 0;
}









