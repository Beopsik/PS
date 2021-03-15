#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

int n;

class SquareMatrix
{
	private:
		int **matrix;
	
	public:
		SquareMatrix(int size){
			matrix=new int*[size];
			for(int i=0; i<size; i++)
				matrix[i]=new int[size];
		}
		void SetMatrix(){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					scanf("%d", &matrix[i][j]);
				}
			}
		}
		void SetMatrix(int i, int j, int num){
			matrix[i][j]=num;
		}
		void ShowMatrix(){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					printf("%d ", matrix[i][j]);
				}
				printf("\n");
			}
		}
		SquareMatrix &operator*(SquareMatrix &b){

			SquareMatrix result(n);

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					result.matrix[i][j]=0;
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					for(int k=0; k<n; k++)
						result.matrix[i][j]+=(matrix[i][k]*b.matrix[k][j]);
						if(result.matrix[i][j]>=1000)
							result.matrix[i][j]%=1000;
				}
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					matrix[i][j]=result.matrix[i][j];
				}
			}

			return *this;
		}
};
SquareMatrix identity(int n){
	
	SquareMatrix base(n);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(i==j)
				base.SetMatrix(i, j, 1);
			else
				base.SetMatrix(i, j, 0);
		}
	}
	
	return base;
}
SquareMatrix pow(SquareMatrix& A, long long int b){
	if(b==0)
		return identity(n);
	
	if(b%2>0)
		return pow(A, b-1)*A;
	
	SquareMatrix half=pow(A, b/2);
	
	return half*half;
}

int main(void)
{
	long long int b;
	
	scanf("%d", &n);
	scanf("%lld", &b);
	
	SquareMatrix mt(n);
	mt.SetMatrix();
	
	mt=pow(mt, b);
	
	mt.ShowMatrix();
	
	return 0;
}














