#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;
	
int main() {
    
	char string[102];
	int t=0;
	
    while(fgets(string, 102, stdin))
    {
        if(feof(stdin))
            break;
            
        int sl=0;
        int cl=0;
        int gap=0;
        int num=0;
        int size=strlen(string);
            
    	for(int i=0; i<size; i++)
    	{
    	    if(string[i]>='a'&&string[i]<='z')
    	        sl++;
    	    else if(string[i]>='A'&&string[i]<='Z')
    	        cl++;
    	    else if(string[i]==' ')
    	        gap++;
    	    else if(string[i]>=48&&string[i]<=57)
    	        num++;
    	}
		if(sl!=0||cl!=0||gap!=0||num!=0)
        	printf("%d %d %d %d\n", sl, cl, num, gap);
	}

	return 0;
}








