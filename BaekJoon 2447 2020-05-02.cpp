#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;
char star[6562][6562];

void pattern(int beginX, int beginY, int size)
{
	for(int y=beginY; y<beginY+size; y++)
	{
		for(int x=beginX; x<beginX+size; x++)
		{
			if(y>=beginY+size/3&&y<beginY+(size/3)*2&&x>=beginX+size/3&&x<beginX+(size/3)*2){
				star[y][x]=' ';
			}
			else{
				star[y][x]='*';
			}
		}
	}
	

	int halfSize=size/3;
	if(halfSize<=1)
		return;

	pattern(beginX, beginY, halfSize);
	pattern(beginX+halfSize, beginY, halfSize);
	pattern(beginX+2*halfSize, beginY, halfSize);

	pattern(beginX, beginY+halfSize, halfSize);
	pattern(beginX+2*halfSize, beginY+halfSize, halfSize);

	pattern(beginX, beginY+2*halfSize, halfSize);
	pattern(beginX+halfSize, beginY+2*halfSize, halfSize);
	pattern(beginX+2*halfSize, beginY+2*halfSize, halfSize);	
}

int main(void){
	
	int n;
	
	scanf("%d", &n);
	
	pattern(0, 0, n);
	
	for(int i=0; i<n; i++)
	{
		for(int t=0; t<n; t++)
		{
				printf("%c",star[i][t]);
		}
		printf("\n");
	}
    return 0;
}


