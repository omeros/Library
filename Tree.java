    
/*
 * a generic tree. its main field "_root"'s type is a generic class that every tree node type must inherit from.
 */
public class Tree 
{
	static final int RED=0,BLACK=1;
	
	TreeNode nil;
	TreeNode _root;
	
	Tree()
	{
	    
		nil=new TreeNode();
		nil._color=BLACK;
		_root=nil;
	}
	
	TreeNode search(int x)
	{
		if (_root==nil)
			return nil;
		
		return _root.search(this,x);
	}
	
	
	/*
	 * the next algorithms are fully described in the book,
	 * therefore i don't see it necessary to write a documentation for them.
	 */
	private void leftRotate(TreeNode x)
	{
	
	    //algorithm's assumption.
		if (x==nil || x._right==nil)
		{
		    return;
		 }
		TreeNode y=x._right;
		x._right=y._left;
		if (y._left!=nil)
		{
			y._left._parent=x;
		}
		y._parent=x._parent;
		if (x._parent==nil)
		{
			_root=y;
		}
		else
		{
		 		if (x==x._parent._left)
			{
				x._parent._left=y;
			}
			else
			{
				x._parent._right=y;
			}
		}
		y._left=x;
		x._parent=y;
     }
     

	private void rightRotate(TreeNode x)
	{
		//algorithm's assumption.
		if (x==nil || x._left==nil)
			return;
		
		TreeNode y=x._left;
		x._left=y._right;
		if (y._right!=nil){
			y._right._parent=x;
		}
		y._parent=x._parent;
		if (x._parent==nil){
			_root=y;
		}
		else {
			if (x==x._parent._right){
				x._parent._right=y;
			}
			else{
				x._parent._left=y;
			}
		}
		y._right=x;
		x._parent=y;
	}
	
	
	void insert(TreeNode z)
	{
		TreeNode y=nil;
		TreeNode x=_root;
		while (x!=nil){
			y=x;
			if(z._value<x._value){ //(z._value.compareTo(x._value)<0){
				x=x._left;
			}
			else{
				x=x._right;
			}
		}
		z._parent=y;
		if (y==nil){
			_root=z;
		}
		else {
			if (z._value<y._value){   // (z._value.compareTo(y._value)<0){
				y._left=z;
			}
			else {
				y._right=z;
			}
		}
		z._left=nil;
		z._right=nil;
		
		z._color=RED;
		insertFixUp(z);
	}
	
	void insertFixUp(TreeNode z)
	{
		TreeNode y;
		
		while (z._parent._color==RED){
			if (z._parent==z._parent._parent._left){
				y=z._parent._parent._right;
				if (y._color==RED){
					z._parent._color=BLACK;
					y._color=BLACK;
					z._parent._parent._color=RED;
					z=z._parent._parent;
				}
				else{
					if (z==z._parent._right){
						z=z._parent;
						leftRotate(z);
					}
					z._parent._color=BLACK;
					z._parent._parent._color=RED;
					rightRotate(z._parent._parent);
				}
			}
			else{
				y=z._parent._parent._left;
				if (y._color==RED){
					z._parent._color=BLACK;
					y._color=BLACK;
					z._parent._parent._color=RED;
					z=z._parent._parent;
				}
				else{
					if (z==z._parent._left){
						z=z._parent;
						rightRotate(z);
					}
					z._parent._color=BLACK;
					z._parent._parent._color=RED;
					leftRotate(z._parent._parent);
				}
			}

		}
		_root._color=BLACK;
	}
	
	
	
  	  TreeNode RBDelete (TreeNode z)
   {
	 TreeNode y;
     TreeNode x;
	 if (z._left==nil || z._right==nil )
    {
        y=z;
    }
        else
     {
         y= TreeSuccessor(z);
     }
	 if(y._left!=nil)
	 {
	   x=y._left;
     }
      else
     {
         x=y._right;
     }
     x._parent=y._parent;
     if ( y._parent==nil)
     {
       _root=x;
     }                                
      else
      {
          if( y==y._parent._left)
          {
              y._parent._left=x;
          }
          else
          {            
             y._parent._right=x;  
          }
     }
     if( y!=z)
     {
         z._value=y._value;
        
      }
     //copy y's satellite data into z
      if (y._color == BLACK)
      {
          RBDeleteFixup (x);
      }
        return y;
    }
    
     void RBDeleteFixup (TreeNode x)
     {
      TreeNode w=null;
   
         while ( x!=_root && x._color == BLACK)
        {
            if( x== x._parent._left)
            {
               w= x._parent._right;  //_right
               if (w._color==RED)
               {
                   w._color=BLACK;
               
                   x._parent._color=RED;
                   leftRotate (x._parent);
                   w=x._parent._right;
               }
               if( w._left._color == BLACK && w._right._color== BLACK)
               {
                  w._color= RED;
                  x=x._parent;
                }
               else 
               {
                  if ( w._right._color == BLACK)
                  {
                    w._left._color= BLACK;                  
                    w._color=RED;
                    rightRotate(w);
                    w=x._parent._right;
                  }
                  w._color=x._parent._color;
                  x._parent._color=BLACK;
                  w._right._color=BLACK;
                  leftRotate(x._parent);
                  x=_root;
                }
             }
             else
             {
                w._right._color= BLACK;                  
                w._color=RED;
                leftRotate(w);
                w=x._parent._left;
                 
             }      
         }
         x._color=BLACK;
      }
    
     TreeNode  TreeSuccessor( TreeNode z)
    {
       TreeNode y;
       TreeNode x=null;
        if ( x._right!=nil)
        {
            return TreeMinimum(x._right);  ////_right
        }
     y=x._parent;
     while( y!=nil && x==y._right)
     {
         x=y;
         y=y._parent;
     }
     return y;
    }
    
     TreeNode TreeMinimum(TreeNode x)
     {
         while( x._left!= nil)
         {
             x=x._left;
         }
      return x;    
     }
    


}

















