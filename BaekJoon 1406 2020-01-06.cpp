#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
#include<stack>
using namespace std;

stack<char>s1;
stack<char>s2;
char str[100001];
char order[1];

int main() {
    
    int cur=0;
    int num;
    int t1=0;
    int t2=0;
    
	scanf("%s", str);
	
	t1=strlen(str);
	
	for(int i=0; i<t1; i++)
	{
	    s1.push(str[i]);
	}
	
	scanf("%d", &num);
	
	for(int i=0; i<num; i++)
	{
	    char ch[1];
	    scanf("%s", order);
	    
	    if(strcmp(order,"L")==0)
	    {
	        if(t1>0)
	        {
    	        s2.push(s1.top());
    	        s1.pop();
    	        t1--;
    	        t2++;
	        }
	    }
	    else if(strcmp(order,"D")==0)
	    {
	        if(t2>0)
	        {
    	        s1.push(s2.top());
    	        s2.pop();
    	        t1++;
    	        t2--;
	        }
	    }
	    else if(strcmp(order,"B")==0)
	    {
	        if(t1>0)
	        {
    	        s1.pop();
    	        t1--;
	        }
	    }
	    else if(strcmp(order,"P")==0)
	    {
	        scanf("%s", ch);
	        s1.push(ch[0]);
	        t1++;
	    }
	}
	
	for(int i=0; i<t1; i++)
	{
	    s2.push(s1.top());
	    s1.pop();
	}
	for(int i=0; i<t1+t2; i++)
	{
	    printf("%c",s2.top());
	    s2.pop();
	}
	printf("\n");
	
	
	return 0;
}



















