#include<cstdio>
#include<iostream>
#include<cstring>
#include<algorithm>
#include<queue>
using namespace std;

struct Priority{
	int x, y, x_c, y_c, b_c, pri;
};
int arr[9][9];
bool check[9][9];
queue <pair<int, int>> coor;
Priority p[81];
int cnt;

void search(int y, int x)
{	
	int y_count=0, x_count=0;
	int box_count=0;
	for(int i=0; i<9; i++){
		if(arr[y][i]==0)
			x_count++;
	}
	for(int i=0; i<9; i++){
		if(arr[i][x]==0)
			y_count++;
	}
	int Y=y/3;
	int X=x/3;
	for(int i=Y*3; i<(Y+1)*3; i++){
		for(int j=X*3; j<(X+1)*3; j++){
			if(arr[i][j]==0)
				box_count++;
		}
	}
	p[cnt].y=y;
	p[cnt].x=x;
	p[cnt].y_c=y_count;
	p[cnt].x_c=x_count;
	p[cnt].b_c=box_count;
	p[cnt].pri=x_count+y_count+box_count;
	//printf("y:%d x:%d pri:%d\n",p[cnt].y, p[cnt].x, p[cnt].pri);
}
void fillsdoku(int index)
{
	int Min;
	
	Min=min(p[index].y_c, p[index].x_c);
	Min=min(Min, p[index].b_c);
	if(Min==p[index].y_c){
		arr[p[index].y][p[index].x]=
	}
	}else if(Min==p[index].x_c){
		
	}else{
		
	}
}

bool cmp(const Priority &p1, const Priority &p2){
    if(p1.pri < p2.pri)
        return true;
    else
        return false;
}
int main(){
	
	for(int i=0; i<9; i++){
		for(int j=0; j<9; j++){
			scanf("%d", &arr[i][j]);
			if(arr[i][j]==0){
				coor.push(pair<int, int>(i, j));
			}
		}
	}
	
	for(int i=0; i<coor.size(); i++){
		pair<int, int> temp=coor.front();
		coor.pop();
		coor.push(temp);
		search(temp.first, temp.second);
		cnt++;
		sort(p, p+cnt, cmp);
		/*for(int i=0; i<cnt; i++){
			printf("[%d]->y:%d x:%d pri:%d\n",i, p[i].y, p[i].x, p[i].pri);
		}
		printf("----------------------\n");*/
	}
	for(int i=0; i<coor.size(); i++){
		fillsdoku(i);
	}
	

	return 0;
}













