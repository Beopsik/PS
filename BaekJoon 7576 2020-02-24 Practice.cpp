#include<iostream>
#include<queue>
#include<cstdio>

using namespace std;

int box[1001][1001];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

int main()
{
    queue< pair<int, int> > tomatos;
    
    int total=0;
    int m, n;
    
    scanf("%d %d", &m, &n);
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<m; j++)
        {
            scanf("%d", &box[i][j]);
            
            if(box[i][j]==1)
            {
                tomatos.push(make_pair(i, j));
            }
            else if(box[i][j]==-1)
            {
                total++;
            }
        }
    }
    
    pair<int, int> curr;
    int nextx;
    int nexty;
    int  size, days=0;
    
    while(!tomatos.empty())
    {
        size=tomatos.size();
        total+=size;
        
        if(total==n*m)
        {
            printf("%d\n", days);
            break;
        }
        
        for(int i=0; i<size; i++)
        {
            curr=tomatos.front();
            tomatos.pop();
            
            for(int j=0; j<4; j++)
            {
                nexty=curr.first+dy[j];
                nextx=curr.second+dx[j];
                
                if(nextx<0||nextx>=m||nexty<0||nexty>=n||box[nexty][nextx]!=0)
                    continue;
                if(box[nexty][nextx]==0)
                {
                    box[nexty][nextx]=1;
                    tomatos.push(make_pair(nexty, nextx));
                }
            }
        }
        days++;
    }
    if(total!=n*m)
    {
        printf("-1\n");
    }
    
    return 0;
}










