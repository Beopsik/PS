#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
#include<time.h>
using namespace std;

char str1[1001][1001];

void Dic(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(str1[l], str1[p]);
	while (i < j) {
		do { i++; } while (strcmp(str1[l], str1[i])>0&&i<=r);
		do { j--; } while (strcmp(str1[l], str1[j])<0&&j>=l+1);
		if (i < j){
	        swap(str1[i], str1[j]);
		}
	}
	swap(str1[l], str1[j]);
	
	Dic(l, j - 1);
	Dic(j + 1, r);
}

int main() {
    
    srand(time(NULL));
    
	char str[1001];
	int t;
	
	scanf("%s", str);
	t=strlen(str);
	
	for(int s=0; s<t; s++)
	{
	    int j=0;
	    
    	for(int i=s; i<t; i++)
    	{
    	    str1[s][j]=str[i];
    	    j++;
    	}
	}
	Dic(0, t-1);
	
	for(int i=0; i<t; i++)
	{
	    printf("%s\n", str1[i]);
	}
	
	return 0;
}













