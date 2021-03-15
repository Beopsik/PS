#include<cstdio>
#include<cstring>
#include <deque>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    
    deque<int>st;
    
	char order[11];
	int count=0;
	int n;
	int value;
	
	scanf("%d", &n);
	
	for(int i=0; i<n; i++)
	{
	    scanf("%s", order);
	    if(strcmp(order,"push_front")==0)
	    {
	        scanf("%d", &value);
	        st.push_front(value);
	        count++;
	    }
	    else if(strcmp(order,"push_back")==0)
	    {
	        scanf("%d", &value);
	        st.push_back(value);
	        count++;
	    }
	    else if(strcmp(order,"pop_front")==0)
	    {
    	    if(count==0)
    	        printf("%d\n", -1);
    	    else
    	    {
    	        printf("%d\n", st.front());
    	        st.pop_front();
    	        count--;
    	    }
	    }
	    else if(strcmp(order,"pop_back")==0)
	    {
    	    if(count==0)
    	        printf("%d\n", -1);
    	    else
    	    {
    	        printf("%d\n", st.back());
    	        st.pop_back();
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





