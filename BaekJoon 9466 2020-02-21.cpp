#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool cycle[100001];
int cnt;

void dfs(bool check[], vector<int> graph[], int start)
{
    check[start]=true;
    
    int next=graph[start][0];
        
    if(check[next]==false)
    {
        dfs(check, graph, next);
    }
    else if(cycle[next]==false)
    {
        for(int i=next; i!=start; i=graph[i][0])
            cnt++;
        cnt++;
    }
    cycle[start]=true;
}
int main (){

	int n, m, c;
	
	scanf("%d", &c);
	
	for(int i=0; i<c; i++)
	{
	
    	scanf("%d", &n);
    
    	vector<int> graph[n+1];
    	bool check [n+1];
    	fill(check, check+n+1, false);
    	fill(cycle, cycle+100001, false);
    
    	for(int i=1; i<=n; i++){
    		int u;
    		scanf("%d", &u);
    
    		graph[i].push_back(u);
    	}
        
        for(int i=1; i<=n; i++)
        {
            if(check[i]==false)
            {
        	    dfs(check, graph, i);
            }
        }
        
        printf("%d\n", n-cnt);
        cnt=0;
	}

	return 0;
}

















