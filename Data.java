

public class Data
{
    Tree _students;
    Tree _books;
    
    Data()
    {
        _students=new Tree(); // student info tree.
        _books=new Tree(); // "books    " tree.  
    }
    
    
     //  student borrowers a book
    void addBook ( String lName, int numId, int numBook)
   {      
      TreeNode found1= _books.search(numBook);      //search for the book at the bookTree
      BookNode found3= (BookNode)found1;             //casting
      found3.setId(numId);                 //update the id, at the book's borrowerId	            
     
      
	
      TreeNode found2= _students.search(numId);      //search for the student  at the studentTree
      if (found2== _students.nil)                     // if the student doesn't exist in the database,
      {
         StudentNode found4=(StudentNode)found2;     //casting
          
         found4= new StudentNode(lName, numId);       // create a new node containing the info about the student.
         found4.addBook(numBook);                     // add the  book int to the student's book list
        _students.insert(found4);                    //insert  the new node into the tree
       }
       else                                          // if the student does exist
      {
           StudentNode found4=(StudentNode)found2;    //casting
          found4.addBook(numBook);                  // add the  book into the student's book list
      }
   }
   
   void returnBook (String lName, int numId, int numBook)   //returning abook
   {
       TreeNode found1= _books.search(numBook);        //search for the book at the bookTree
       BookNode found2=(BookNode)found1;               //casting
       found2.setId(0);                                 // Id defined as 0, when the book was returned to the library
	          
       TreeNode found3= _students.search(numId);      //search for the student  at the studentTree
       StudentNode found4=(StudentNode)found3;    
       found4.setBook (numBook,0);                      // delet the  book from the student's book list
       System.out.println (lName + "   ID:" +numId + "    returns the book num:   " + numBook);    
      
    }
  
    void newBook(int num)             //Receives a new book
   {
     BookNode newB= new BookNode(num,0);
     _books.insert(newB);
   }
    void newSubscriber (String name, int num)  //a new subscriber entered to the student tree
   {
       StudentNode newSub=new StudentNode (name,num);  // create a new studentNode containing info about the student.
       _students.insert(newSub);
       System.out.println (name + "   ID:" +num + "    welcome to our lybrary");   //prints the information
    }
  
    void endSubscrib (String name , int num)   //delete an subscrib from the list
    {
     TreeNode s= _students.search (num);
     StudentNode t= (StudentNode)s;       //casting           
     _students.RBDelete(t);
    }
    
    void whatBooks (int num)  //prints all the books  the student has
    {
       TreeNode s= _students.search (num);     //find the student
       StudentNode t= (StudentNode)s;         //casting
    
     //   StudentNode t= _students.search (num);
       t.printBooks();                            //prints the books
    }
    
    int bookBelongs (int num )                //returns the ID of the one who hold this book
    {
        TreeNode c =_books.search(num);     // finds the BookNode
        BookNode k= (BookNode)c;           //casting
        int student= k.getId();
        return student;
    }
    void haveMostBooks ()       ///  print the ID of the students who hold the most amount of books
    {
      int i =10;                                            
      int k=0;
      while ( i!=0 && k!=-1)             // && j==-1)
      {
        k= this.inspectTree1(_students._root, i);
      
        i--;
      }
      this.inspectTree2(_students._root, i);
      
    }
     int inspectTree1 (TreeNode current, int i)  // inspect tree function1
     { 
         if ( current._left != null )        
         {
              inspectTree1(current._left,i); 
         }
         if ( current._right != null ) 
         {
             inspectTree1(current._right,i); 
         }
          StudentNode t= (StudentNode)current;                //casting
         if (i ==t.amountOfBooks() )
         {                                                       
             return  i=-1;
         }     
      return i;
      }
     void inspectTree2 (TreeNode current, int j)       // inspect tree function2
     { 
         if ( current._left != null )        
         {
              inspectTree2(current._left,j); 
         }
         if ( current._right != null ) 
         {
             inspectTree2(current._right,j); 
         }
          StudentNode t= (StudentNode)current;          ///casting
         if (j ==t.amountOfBooks() )
         {                                          
             t.printData();         
       
         }
        
    
    }
}
       
       
       
   
   
