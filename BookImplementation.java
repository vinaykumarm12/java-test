package bookstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.arwizon.model.Products;
import com.arwizon.service.ConnectionClass;

public class BookImplementation implements BookInterface
{
	Connection con=ConnectionClass.connectDb();
	@Override
	public void addbook(String bookname, double cost, int numunits, String author, String booktype) 
	{
		ResultSet rs=null;
		PreparedStatement st=null;
		try {
			 String sq="select max(bookid) from Books";
			 st=con.prepareStatement(sq);
			 rs=st.executeQuery();
			int i=100;
			while(rs.next()) {
				i=rs.getInt(1);
			String sql="insert into Books values(?,?,?,?,?,?)";
			PreparedStatement st1=con.prepareStatement(sql);
			st1.setInt(1,i+1);
			st1.setString(2, bookname);
			st1.setDouble(3, cost);
			st1.setInt(4, numunits);
			st1.setString(5, author);
			st1.setString(6, booktype);
			st1.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				rs.close();
				st.close();
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			
			}
		}
		
	}

	@Override
	public Set<BookDetails> searchbook(int id) 
	{

		Set<BookDetails> booklist=new HashSet<BookDetails>();

		ResultSet rs=null;
		PreparedStatement st=null;
		try {
			String sql="select * from Books where bookid=?";
			 st=con.prepareStatement(sql);
			 rs=st.executeQuery();
			while(rs.next()) {
				BookDetails p=new BookDetails();
				p.setBookid(rs.getInt(1));
				p.setBookName(rs.getString(2));
				p.setCost(rs.getInt(3));
				p.setNumunits(rs.getInt(4));
				p.setAuthor(rs.getString(5));
				p.setBooktype(rs.getString(6));
				booklist.add(p);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return booklist;
		
	}

	@Override
	public Set<BookDetails> displaybook() {
		Set<BookDetails> Prolist=new HashSet<BookDetails>();
		String sql="select * from Books ";

		ResultSet rs=null;
		PreparedStatement st=null;
		try {					
			 st=con.prepareStatement(sql);
			 rs=st.executeQuery();
			while(rs.next()) {
				BookDetails p=new BookDetails();
				p.setBookid(rs.getInt(1));
				p.setBookName(rs.getString(2));
				p.setCost(rs.getInt(3));
				p.setNumunits(rs.getInt(4));
				p.setAuthor(rs.getString(5));
				p.setBooktype(rs.getString(6));
				Prolist.add(p);
			}
			
				}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				st.close();
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			
			}}
		return Prolist;
}
	

	@Override
	public void deletebook(int id) {
		String sql="delete from Books where bookid=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatebook(int pid, int unit) {
		String sql="update Books set numunits=? where bookid=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(2, pid);
			st.setInt(1, unit);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
