package bookstore;

import java.util.Set;



public interface BookInterface 
{
	public  void addbook(String bookname,double cost,int numunits,String author,
			String booktype);

			public Set<BookDetails> searchbook(int id);
			public Set<BookDetails> displaybook();
			public void deletebook(int id);
			public void updatebook(int pid,int unit);
}
