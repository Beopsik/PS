#include<iostream>
#include<queue>
#include<cstdio>
#include<algorithm>

using namespace std;

int box[101][101];
bool visited[101][101];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int n;
int cnt=2;

void is(int i, int j)
{
	queue< pair<int, int> > island;
	pair<int, int> curr;
    int nextx;
    int nexty;
    int size;
    
    island.push(make_pair(i, j));
	box[i][j]=cnt;
	
    while(!island.empty())
    {
		size=island.size();
        for(int i=0; i<size; i++)
        {
            curr=island.front();
            island.pop();
            for(int j=0; j<4; j++)
            {
                nexty=curr.first+dy[j];
                nextx=curr.second+dx[j];
                    
                if(nextx<0||nextx>=n||nexty<0||nexty>=n)
                    continue;
                if(box[nexty][nextx]==1)
                {
                    island.push(make_pair(nexty, nextx));
                    box[nexty][nextx]=cnt;
                }
            }
        }
    }
	cnt++;
}
int bridge(int c)
{
	queue< pair<int, int> > island;
    pair<int, int> curr;
    int nextx;
    int nexty;
    int size;
    int t=0;
	
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(box[i][j]==c)
			{
				island.push(make_pair(i, j));
				visited[i][j]=true;
			}
		}
	}
    while(!island.empty())
    {
        size=island.size();
        for(int i=0; i<size; i++)
        {
            curr=island.front();
            island.pop();
            for(int j=0; j<4; j++)
            {
                nexty=curr.first+dy[j];
                nextx=curr.second+dx[j];
                    
                if(nextx>=0&&nextx<n&&nexty>=0&&nexty<n)
				{
					if(box[nexty][nextx]!=0&&box[nexty][nextx]!=c)
					{
						return t;
					}
					else if(box[nexty][nextx]==0&&visited[nexty][nextx]==false)
					{
						island.push(make_pair(nexty, nextx));
						visited[nexty][nextx]=true;
					}
				}
        	}
        }
		t++;
	}
}
int main()
{
	
    scanf("%d", &n);
	
	int result=10201;
    
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            scanf("%1d", &box[i][j]);
        }
    }
	for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
        {
            if(box[i][j]==1)
            {
                is(i, j);
            }
        }
    }
	for(int s=2; s<cnt; s++)
	{
		fill(visited[0], visited[0]+10201, false);
		result=min(result, bridge(s));
	}
    printf("%d\n", result);
    return 0;
}













