#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

class makeOne{
    
    private:
        int n;
        int sum;
        int arr[1001][10]={0};
    
    public:
    makeOne()
        : sum(0)
    {
    }
    void setNum()
    {
        cin>>n;
    }
    void solution()
    {
        for(int i=0; i<10; i++)
        {
            arr[1][i]=1;
        }
        
        for(int i=2; i<=n; i++)
        {
            for(int t=0; t<10; t++)
            {
                for(int j=0; j<=t; j++)
                {
                    arr[i][t]+=arr[i-1][j];
                    arr[i][t]%=10007;
                }
            }
        }
    }
    void printMin()
    {
        for(int i=0; i<10; i++)
        {
            sum+=arr[n][i];
        }
        sum%=10007;
        cout<<sum;
    }
};

int main(void)
{
    makeOne one;
    one.setNum();
    one.solution();
    one.printMin();
    
    return 0;
    
}











