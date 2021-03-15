#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

void bfs(int start, vector<int> graph[], bool check[], int bi[])
{   
    if(check[start]!=true){
		queue<int> q;
    	int b=0;
		
		q.push(start);
		check[start]=true;
		bi[start]=b;
		b=1;

		while(!q.empty())
		{
			int temp=q.front();
			q.pop();
			//printf("%d ", temp);
			if(bi[temp]==0)
				b=1;
			else if(bi[temp]==1)
				b=0;
			for(int i=0; i<graph[temp].size(); i++)
			{
				if(check[graph[temp][i]]==false)
				{
					q.push(graph[temp][i]);
					check[graph[temp][i]]=true;
					bi[graph[temp][i]]=b;
				}
			}
		}
    }
}
int main (){

	int c, n, m;
	
	scanf("%d", &c);
	
	char result[c][4];
	
	for(int i=0; i<c; i++)
	{
		int count=0;
		
    	scanf("%d %d", &n, &m);
        
    	vector<int> graph[n+1];
    	bool check [n+1];
    	int bi [n+1];
    	fill(check, check+n+1, false);
    
    	for(int i=0; i<m; i++){
    		int u,v;
    		scanf("%d %d", &u, &v);
    
    		graph[u].push_back(v);
    		graph[v].push_back(u);
    	}
    
    	for(int i=1; i<=n; i++){
    		sort(graph[i].begin(), graph[i].end());
    	}
        
        for(int i=1; i<=n; i++){
            bfs(i, graph, check, bi);
        }
        //printf("\n");
        
        for(int i=1; i<=n; i++){
    		//printf("%d ", bi[i]);
    	}
    	//printf("\n");
    	
    	for(int i=1; i<=n; i++){
    	    //printf("%d, %d: ", i, bi[i]);
    		for(int j=0; j<graph[i].size(); j++)
    		{
    		    //printf("%d, %d| ", graph[i][j], bi[graph[i][j]]);
    		    if(bi[i]==bi[graph[i][j]])
    		        count++;
    		}
    		//printf("\n");
    	}
    	if(count!=0)
    	    strcpy(result[i], "NO");
    	else
			strcpy(result[i], "YES");
	}
	
	for(int i=0; i<c; i++)
	{
		printf("%s\n", result[i]);
	}
	return 0;
}














