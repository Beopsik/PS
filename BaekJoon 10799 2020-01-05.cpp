#include<cstdio>
#include<cstring>
#include <stack>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    
    stack<int>st;
    
	char vps[100001];
	int result=0;
	int count=0;
	int laser=0;
	int n;
	int t;
	
	scanf("%s", vps);
	for(t=0; vps[t]!=NULL; t++)
	{
	    if(vps[t]=='('&&vps[t+1]!=')'){
	        laser=0;
            st.push(vps[t]);
            count++;
        }
        else if(vps[t]=='('&&vps[t+1]==')'){
            st.push(vps[t]);
            result+=count;
            t++;
            
        }
        else if(vps[t]==')'){
            st.push(vps[t]);
            result++;
            count--;
            laser=0;
            
        }
	}
	for(; t>0; t--)
	{
	    st.pop();
	}
	printf("%d\n", result);
	return 0;
}





