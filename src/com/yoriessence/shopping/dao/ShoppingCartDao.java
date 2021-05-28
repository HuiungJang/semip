package com.yoriessence.shopping.dao;

import static com.yoriessence.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.yoriessence.shopping.vo.OrderDetails;
import com.yoriessence.shopping.vo.Product;
import com.yoriessence.shopping.vo.ShoppingCart;

public class ShoppingCartDao {
	
	private Properties prop=new Properties();
	
	public ShoppingCartDao() {
		try {
			String filePath=ShoppingCartDao.class.getResource("/sql/shopping.properties").getPath();
			prop.load(new FileReader(filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<ShoppingCart> ShoppingCartCheck(Connection conn,String memberId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ShoppingCart> list=new ArrayList();
		String sql=prop.getProperty("shoppingmember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ShoppingCart sc=new ShoppingCart();
				sc.setMemberid(rs.getString("MEMBER_ID"));
				sc.setProductname(rs.getString("PRODUCT_NAME"));
				sc.setProductprice(rs.getInt("PRODUCT_PRICE"));
				sc.setProductnumber(rs.getInt("PRODUCT_NUMBER"));
				sc.setProductshopify(rs.getInt("PRODUCT_SHOPIFY"));
				list.add(sc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	

	public List<Product> ProductAll(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("ProductAll"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product pd=new Product();
				pd.setProductNo(rs.getInt("PRODUCTNO"));
				pd.setStock(rs.getInt("STOCK"));
				pd.setPrice(rs.getInt("PRICE"));
				pd.setExplanation(rs.getString("EXPLANATION"));
				pd.setProductName(rs.getString("PRODUCTNAME"));
				pd.setProductImage(rs.getString("PRODUCTIMAGE"));
				pd.setProductkategorie(rs.getString("PRODUCTKATEGORIE"));
				pd.setProductshopify(rs.getInt("PRODUCTSHOPIFY"));
				list.add(pd);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public int selectProductCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("Productpage"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	public Product Productsearch(Connection conn,String search) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product pds=null;
		String sql=prop.getProperty("searchproduct");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pds=new Product();
				pds.setProductNo(rs.getInt("PRODUCTNO"));
				pds.setStock(rs.getInt("STOCK"));
				pds.setPrice(rs.getInt("PRICE"));
				pds.setExplanation(rs.getString("EXPLANATION"));
				pds.setProductName(rs.getString("PRODUCTNAME"));
				pds.setProductImage(rs.getString("PRODUCTIMAGE"));
				pds.setProductkategorie(rs.getString("PRODUCTKATEGORIE"));
				pds.setProductshopify(rs.getInt("PRODUCTSHOPIFY"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return pds;
	}
	
	public Product selectProduct(Connection conn, int productno) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product pd=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectProduct"));
			pstmt.setInt(1, productno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pd=new Product();
				pd.setProductNo(rs.getInt("PRODUCTNO"));
				pd.setStock(rs.getInt("STOCK"));
				pd.setPrice(rs.getInt("PRICE"));
				pd.setExplanation(rs.getString("EXPLANATION"));
				pd.setProductName(rs.getString("PRODUCTNAME"));
				pd.setProductImage(rs.getString("PRODUCTIMAGE"));
				pd.setProductkategorie(rs.getString("PRODUCTKATEGORIE"));
				pd.setProductshopify(rs.getInt("PRODUCTSHOPIFY"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return pd;
	}
	
	public int deleteShopping(Connection conn, String productname) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteShopping"));
			pstmt.setString(1, productname);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public List<Product> Shoppingkategori(Connection conn, String katagori ){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("Productkatagori"));
			pstmt.setString(1, katagori);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product pd=new Product();
				pd.setProductNo(rs.getInt("PRODUCTNO"));
				pd.setStock(rs.getInt("STOCK"));
				pd.setPrice(rs.getInt("PRICE"));
				pd.setExplanation(rs.getString("EXPLANATION"));
				pd.setProductName(rs.getString("PRODUCTNAME"));
				pd.setProductImage(rs.getString("PRODUCTIMAGE"));
				pd.setProductkategorie(rs.getString("PRODUCTKATEGORIE"));
				pd.setProductshopify(rs.getInt("PRODUCTSHOPIFY"));
				list.add(pd);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public int insertShoppingCart(Connection conn, ShoppingCart sc) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertShoppingCart"));
			pstmt.setString(1, sc.getMemberid());
			pstmt.setString(2, sc.getProductname());
			pstmt.setInt(3, sc.getProductprice());
			pstmt.setInt(4, sc.getProductnumber());
			pstmt.setInt(5, sc.getProductshopify());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int ProductInsert(Connection conn, Product pd) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("ProductInsert"));
			pstmt.setInt(1, pd.getStock());
			pstmt.setInt(2, pd.getPrice());
			pstmt.setString(3, pd.getExplanation());
			pstmt.setString(4, pd.getProductName());
			pstmt.setString(5, pd.getProductImage());
			pstmt.setString(6, pd.getProductkategorie());
			pstmt.setInt(7, pd.getProductshopify());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public List<OrderDetails> OrderDetails(Connection conn, String memberid){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<OrderDetails> list=new ArrayList();
		String sql=prop.getProperty("OrderDetails");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberid);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OrderDetails od=new OrderDetails();
				od.setMEMBERID(rs.getString("MEMBERID"));
				od.setORDERAMOUTNT(rs.getInt("ORDERAMOUNT"));
				od.setORDERDATE(rs.getDate("ORDERDATE"));
				od.setPAYMENTDATE(rs.getDate("PAYMENTDATE"));
				list.add(od);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
}



















