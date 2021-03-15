#include<cstdio>
#include<iostream>

using namespace std;

class tree
{
    private:
        char data;
        tree* left;
        tree* right;
    
    public:
        tree()
        {
            left=NULL;
            right=NULL;
        }
        void setdata(char data)
        {
            this->data=data;
        }
        void setleft(tree* left)
        {
            this->left=left;
        }
        void setright(tree* right)
        {
            this->right=right;
        }
        void showdata(tree* root)
        {
            printf("%c", root->data);
        }
        void preorder(tree* root)
        {
            if(root)
            {
                showdata(root);
                preorder(root->left);
                preorder(root->right);
            }
        }
        void inorder(tree* root)
        {
            if(root)
            {
                inorder(root->left);
                showdata(root);
                inorder(root->right);
            }
        }
        void postorder(tree* root)
        {
            if(root)
            {
                postorder(root->left);
                postorder(root->right);
                showdata(root);
            }
        }
};
int main()
{
    int n;
    char data, left, right;
    
    scanf("%d", &n);
    getchar();
    
    tree *T=new tree[n];
    
    for(int i=0; i<n; i++)
    {
        scanf("%c %c %c", &data, &left, &right);
        getchar();
        if(data!='.')
            T[(int)(data-'A')].setdata(data);
        if(left!='.')
            T[(int)(data-'A')].setleft(&T[(int)(left-'A')]);
        else
            T[(int)(data-'A')].setleft(NULL);
        if(right!='.')
            T[(int)(data-'A')].setright(&T[(int)(right-'A')]);
        else
            T[(int)(data-'A')].setright(NULL);
    }
    
    tree *root=&T[0];
    T[0].preorder(root);
    printf("\n");
    T[0].inorder(root);
    printf("\n");
    T[0].postorder(root);
    printf("\n");
    
    return 0;
}













