#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;
	
int main() {
    
	char string[101];
	int t=0;
	
	scanf("%[^\n]", string);
	
	t=strlen(string);
	
	for(int i=0; i<t; i++)
	{
	    if(string[i]<=77&&string[i]>=65)
	        string[i]+=13;
        else if(string[i]>77&&string[i]<=90)
            string[i]-=13;
        else if(string[i]<=109&&string[i]>=97)
            string[i]+=13;
        else if(string[i]>109&&string[i]<=122)
            string[i]-=13;
	}
	printf("%s\n", string);
	
	return 0;
}









