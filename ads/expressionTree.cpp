#include <bits/stdc++.h>
using namespace std;

class Node{
    public :
    char data ;
    Node *left,*right ;
    
    Node(char n) { data=n; left=right=NULL;}
};

class Exp {
    private :
    Node* root ;
    bool isOp(char ch) {
        return(ch=='+'||ch=='-'||ch=='*'||ch=='/') ;
    }
    
    public :
    Exp() { root=NULL; }
    
    //build-post
    Node* buildPost(string exp) {
        stack<Node*> s ;
        for(int i=0;i<exp.size();i++){
            if(!isOp(exp[i]))
                s.push(new Node(exp[i])) ;
            else {
                Node* right = s.top(); s.pop();
                Node* left = s.top(); s.pop();
                Node* temp = new Node(exp[i]);
                temp->left=left;
                temp->right=right;
                s.push(temp);
            }
        }
        root = s.top() ;
        return root ;
    }
    
    //build-pre
    Node* buildPre(string exp) {
        stack<Node*> s ;
        for(int i=exp.size()-1;i>=0;i--){
            if(!isOp(exp[i]))
                s.push(new Node(exp[i])) ;
            else {
                Node* left = s.top(); s.pop();
                Node* right = s.top(); s.pop();
                Node* temp = new Node(exp[i]);
                temp->left=left;
                temp->right=right;
                s.push(temp);
            }
        }
        root = s.top() ;
        return root;
    }
    
    void inRec(Node* root) {
        if(!root) return ;
        inRec(root->left) ;
        cout << root->data << " " ;
        inRec(root->right);
    }
    void preRec(Node* root) {
        if(!root) return ;
        cout << root->data << " " ;
        preRec(root->left);
        preRec(root->right);
    }
    void postRec(Node* root) {
        if(!root) return ;
        postRec(root->left);
        postRec(root->right);
        cout << root->data << " " ;
    }
    
    void inIter(Node* root)  {
        Node* temp = root ;
        stack<Node*> s ;
        while(1) {
            while(temp!=NULL) {
                s.push(temp);
                temp = temp->left;
            } if(!s.empty()) return ;
            temp = s.top();s.pop();
            cout << temp->data ;
            temp = temp->right ;
        }
    }
    
    void preIter(Node* root) {
        Node* temp = root ;
        stack<Node*> s ;
        while(1) {
            while(temp!=NULL) {
                cout << temp->data ;
                s.push(temp);
                temp = temp->left;
            } if(!s.empty()) return ;
            temp = s.top(); s.pop();
            temp = temp->right ;
        }
    }
    
    void postIter(Node* root) { 
        if(!root) return ;
        stack<Node*> s1,s2 ;
        s1.push(root) ;
        while(!s1.empty()) {
            Node* temp = s1.top(); s1.pop();
            s2.push(temp);
            if(temp->left) s1.push(temp->left);
            if(temp->right) s1.push(temp->right);
        }
        while(!s2.empty()) {
            cout << s2.top()->data << " ";
            s2.pop();
        }
    }
    
    void mirror(Node* root){
        if(!root) return ;
        mirror(root->left);
        mirror(root->right);
        swap(root->left,root->right);
    }
    
    int height(Node* root) {
        if(!root) return 0;
        return 1+max(height(root->left),height(root->right));
    }
    int countLeaf(Node* root){
        if(!root) return 0;
        if(!root->left && !root->right) return 1 ;
        return countLeaf(root->left)+countLeaf(root->right);
    }
    int countInternal(Node* root){
        if(!root || (!root->left && !root->right)) return 0 ;
        return 1+countInternal(root->left)+countInternal(root->right);
    }
    int countTotal(Node* root) {
        return countLeaf(root) + countInternal(root) ;
    }
    
    int evaluate(Node* root) {
        if(!root) return 0 ; 
        if(!isOp(root->data)) return root->data-'0';
        
        int l=evaluate(root->left);
        int r=evaluate(root->right);
        
        switch(root->data) { 
            case '+' : return l+r ;
            case '-' : return l-r ;
            case '*' : return l*r ;
            case '/' : return r!=0 ? l/r : 0;
        }
        return 0;
    }
    
    string toIn(Node* root) { 
        if(!root) return "" ;
        if(!isOp(root->data)) return string()+root->data;
        return "("+toIn(root->left)+(string()+root->data)+toIn(root->right)+")";
    }
    string toPre(Node* root) { 
        if(!root) return "" ;
        if(!isOp(root->data)) return string()+root->data;
        return "("+(string()+root->data)+toPre(root->left)+toPre(root->right)+")";
    }
    string toPost(Node* root) { 
        if(!root) return "" ;
        if(!isOp(root->data)) return string()+root->data;
        return "("+toPost(root->left)+toPost(root->right)+(string()+root->data)+")";
    }
    
    Node* getRoot() {return root;}
};

int main() {
    Exp e ;
    
    Node* tree = nullptr ;
    string exp ;
    int ch ;
    
    cout << "1.PostFix\n2.Prefix\nEnter type of Expression : ";
    cin >> ch ;
    cout << "Enter Expression : ";
    cin >> exp ;
    
    if(ch==1) tree = e.buildPost(exp);
    else tree = e.buildPre(exp);
    
    cout << "\nRecursive Traversals :" ;
    cout << "\nInorder : "; e.inRec(tree);
    cout << "\nPreorder : "; e.preRec(tree);
    cout << "\nPostorder : "; e.postRec(tree);
    
    cout << "\n\nHeight : " << e.height(tree) ;
    cout << "\nLeaf Nodes : " << e.countLeaf(tree) ;
    cout << "\nInternal Nodes : " << e.countInternal(tree) ;
    cout << "\nTotal : " << e.countTotal(tree) ;
    
    cout << "\n\nInfix Expression : " << e.toIn(tree) ;
    cout << "\nPrefix Expression : " << e.toPre(tree) ;
    cout << "\nPostfix Expression : " << e.toPost(tree) ;
    
    cout << "\n Evaluated Value : " << e.evaluate(tree) ;
    
    cout << "\n\nMirror Inorder : ";
    e.mirror(tree);
    e.inRec(tree);
    cout << endl ;
    return 0 ;
}