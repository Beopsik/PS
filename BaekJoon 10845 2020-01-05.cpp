#include<cstdio>
#include<cstring>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    
    queue<int>st;
    
	char order[10];
	int count=0;
	int n;
	int value;
	
	scanf("%d", &n);
	
	for(int i=0; i<n; i++)
	{
	    scanf("%s", order);
	    if(strcmp(order,"push")==0)
	    {
	        scanf("%d", &value);
	        st.push(value);
	        count++;
	    }
	    else if(strcmp(order,"pop")==0)
	    {
    	    if(count==0)
    	        printf("%d\n", -1);
    	    else
    	    {
    	        printf("%d\n", st.front());
    	        st.pop();
    	        count--;
    	    }
	    }
	    else if(strcmp(order,"size")==0)
	    {
	        printf("%ld\n", st.size());
	    }
	    else if(strcmp(order,"empty")==0)
	    {
	        if(st.empty()==true)
	            printf("%d\n", 1);
	        else
	            printf("%d\n", 0);
	    }
	    else if(strcmp(order,"front")==0)
	    {
	        if(count==0)
	            printf("%d\n", -1);
	        else
	            printf("%d\n", st.front());
	    }
	    else if(strcmp(order,"back")==0)
	    {
	        if(count==0)
	            printf("%d\n", -1);
	        else
	            printf("%d\n", st.back());
	    }
	}
	
	return 0;
}





