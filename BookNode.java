public class BookNode extends TreeNode 
{
    int _id=0;  
    BookNode( int numBook, int id )
   {
      _value=numBook; 
      _id=id;
   }
 
   void setId (int id)
   {
       _id=id;
   }
   
   int getId()
   {
       return _id;
   }
   
   
}
 
