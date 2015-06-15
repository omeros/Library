/*
 * a generic TreeNode that CourseNode, StudentNode and CourseStatNode inherit from.
 * it contains the basic fields of an RBT, and a main value.
 */
public class TreeNode {
	
	TreeNode _left;
	TreeNode _right;
	TreeNode _parent;
	int _color; //red or black
	int _value; //will store the student's ID or the book's number.
	
	
	//algorithm described in the book
	TreeNode search(Tree t,int x){
		if (_value==x){ //value=x
			return this;
		}
		else if (_value>x){ 
			if (_left==t.nil){
				return t.nil;
			}
			else {
				return _left.search(t,x);
			}
		}
		else{ //value>x
			if (_right==t.nil){
				return t.nil;
			}
			else{
				return _right.search(t,x);
			}
		}
    }
}

  //int inspectTree1 (TreeNode current, int i)  // inspect tree function
    // { 
      //   if ( current._left != null )        
       //  {
        //      inspectTree1(current._left); 
         //}
//         if ( current._right != null ) 
  //       {
 //            inspectTree1(current._right); 
//         }
//         if (i ==current.amountOfBooks() )
//         {                                                       //  current.printData();         
//             return  i=-1;
//         }     
///     }
//     void inspectTree2 (TreeNode current, int j)  // inspect tree function
 //    { 
 //        if ( current._left != null )        
 //        {
   //           inspectTree2(current._left); 
 //        }
  //       if ( current._right != null ) 
 //        {
 //            inspectTree2(current._right); 
 //        }
 //        if (j ==current.amountOfBooks() )
 //        {                                          
 //            current.printData();         
       
  //       }
        
    
 //   }            




//}




//algorithm described in the book
//	TreeNode search(Tree t, String x){
//		if (_value.equals(x)){ //value=x
//			return this;
//		}
//		else if (_value.compareTo(x)>0){ //value>x
//			if (_left==t.nil){
	//			return t.nil;
//			}
//			else {
//				return _left.search(t,x);
//			}
//		}
//		else{ //value>x
//			if (_right==t.nil){
//				return t.nil;
//			}
//			else{
//				return _right.search(t,x);
//			}
//		}
	//}




























