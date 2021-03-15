#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

int arr[1001];
int dp1[1001];
int dp2[1001];

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
        
        dp1[1]=1;
        dp2[n]=1;
        
        for(int i=2; i<=n; i++)
        {
            dp1[i]=1;
            for(int j=1; j<i; j++)
            {
                if(arr[i]>arr[j]&&dp1[i]<=dp1[j])
                    dp1[i]=dp1[j]+1;
                else if(arr[i]==arr[j])
                    dp1[i]=dp1[j];
            }
        }
        for(int i=n; i>=1; i--)
        {
            dp2[i]=1;
            for(int j=n; j>=i; j--)
            {
                if(arr[i]>arr[j]&&dp2[i]<=dp2[j])
                    dp2[i]=dp2[j]+1;
                else if(arr[i]==arr[j])
                    dp2[i]=dp2[j];
            }
        }
        for(int i=1; i<=n; i++)
        {
            Max=max(Max, dp1[i]+dp2[i]-1);
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















