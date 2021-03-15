#include<cstdio>
#include<cstring>
#include <stack>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    
    stack<int>st;
    
	char vps[51];
	int count=0;
	int n;
	int t;
	
	scanf("%d", &n);
	
	for(int i=0; i<n; i++)
	{
	    scanf("%s", vps);
	    
	    for(t=0; vps[t]!=NULL; t++)
	    {
	        if(vps[t]=='('){
    	        st.push(vps[t]);
    	        count++;
	        }
	        else if(vps[t]==')'){
	            st.push(vps[t]);
    	        count--;
    	        if(count<0)
    	            break;
	        }
	    }
	    if(count==0)
	        printf("YES\n");
	    else if(count!=0)
	        printf("NO\n");
	    
	    for(; t>0; t--)
	    {
	       st.pop();
	    }
	    
	    count=0;
	}
	return 0;
}




