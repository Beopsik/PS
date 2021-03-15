#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

class makeOne{
    
    private:
        int n;
        int arr[1000];
    
    public:
    void setNum()
    {
        cin>>n;
        memset(arr, 0, sizeof(int)*(n+1));
    }
    void solution()
    {
        arr[1]=1;
        arr[2]=3;
        
        for(int i=3; i<=n; i++)
        {
            arr[i]=(arr[i-1]+2*arr[i-2])%10007;
        }
    }
    void printMin()
    {
        cout<<arr[n]%10007;
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







