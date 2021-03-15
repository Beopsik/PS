#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int parent[100001];

void dfs(bool check[], vector<int> graph[], int start)
{
    check[start]=true;
    
    for(int i=0; i<graph[start].size(); i++)
    {
        int next=graph[start][i];
        
        if(check[next]==false)
        {
            parent[next]=start;
            dfs(check, graph, next);
        }
    }
}
int main()
{
    int n;
    
    scanf("%d", &n);
    
    vector<int>graph[n+1];
    bool check[n+1];
    fill(check, check+n+1, false);
    
    for(int i=1; i<=n-1; i++)
    {
        int u, v;
        
        scanf("%d %d", &u, &v);
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    
    for(int i=1; i<=n; i++)
    {
        sort(graph[i].begin(), graph[i].end());
    }
    
    dfs(check, graph, 1);

    for(int i=2; i<=n; i++)
    {
        printf("%d\n", parent[i]);
    }
    
    return 0;
}







