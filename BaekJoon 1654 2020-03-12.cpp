#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int N;
int sum;
int diamiter;
int far=0;

void dfs(bool check[], vector<int> graph[], int start, vector<int> weight[])
{
	int temp;
	
    check[start]=true;
    
    for(int i=0; i<graph[start].size(); i++)
    {
        int next=graph[start][i];
        temp=sum;
        if(check[next]==false)
        {
			sum+=weight[start][i];
			if(diamiter<sum)
				far=next;
			diamiter=max(sum, diamiter);
            dfs(check, graph, next, weight);
        }
		sum=temp;
    }
}
int main()
{
    int n;
    int u, v, w;
    
    scanf("%d", &n);
    
    vector<int>graph[n+1];
    vector<int>weight[n+1];
    bool check[n+1];
    fill(check, check+n+1, false);
    
    for(int i=1; i<=n; i++)
    {
        scanf("%d %d %d", &u, &v, &w);
 
        graph[u].push_back(v);
        graph[v].push_back(u);
        weight[u].push_back(w);
        weight[v].push_back(w);
    }
    
	sum=0;
	fill(check, check+n+1, false);
    dfs(check, graph, 1, weight);
	sum=0;
	fill(check, check+n+1, false);
    dfs(check, graph, far, weight);
	
    printf("%d\n", diamiter);
    
    return 0;
}












