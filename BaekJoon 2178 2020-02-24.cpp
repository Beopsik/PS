#include<iostream>
#include<queue>
#include<cstdio>

using namespace std;

int box[101][101];
int weight[101][101];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

int main()
{
    queue< pair<int, int> > maze;
    
    int total=0;
    int m, n;
    
    scanf("%d %d", &n, &m);
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++)
        {
            scanf("%1d", &box[i][j]);
        }
    }
    
    pair<int, int> curr;
    int nextx;
    int nexty;
    int  size, days=0;
    
    maze.push(make_pair(0, 0));
    weight[0][0]=1;
    box[0][0]=0;
    while(!maze.empty())
    {
        size=maze.size();
        
        for(int i=0; i<size; i++)
        {
            curr=maze.front();
            maze.pop();
            for(int j=0; j<4; j++)
            {
                nexty=curr.first+dy[j];
                nextx=curr.second+dx[j];
                
                if(nextx<0||nextx>=m||nexty<0||nexty>=n)
                    continue;
                if(box[nexty][nextx]==1)
                {
                    maze.push(make_pair(nexty, nextx));
                    box[nexty][nextx]=0;
                    weight[nexty][nextx]=weight[curr.first][curr.second]+1;
                }
            }
        }
    }
	
    printf("%d\n", weight[n-1][m-1]);
    
    return 0;
}













