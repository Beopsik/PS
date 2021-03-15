#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

int arr[1001];
int dp[1001];

class makeOne{
    
    private:
        int n;
        int sum;
        int min;
        int Max=0;
    
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
        for(int i=1; i<=n; i++)
        {
            cin>>arr[i];
        }
        
        for(int i=1; i<=n; i++)
        {
            dp[i]=arr[i];
        }
        
        for(int i=2; i<=n; i++)
        {
            Max=0;
            for(int j=1; j<i; j++)
            {
                if(arr[i]>arr[j])
                {
                    Max=max(Max, dp[j]+arr[i]);
                    dp[i]=Max;
                }
                else if(arr[i]==arr[j])
                    dp[i]=dp[j];
            }
        }
        for(int i=1; i<=n; i++)
        {
            Max=max(Max, dp[i]);
        }
    }
    void printMin()
    {
        cout<<Max<<endl;
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
















