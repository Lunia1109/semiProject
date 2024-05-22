package com.web.shoppingmall.model.service;

import static com.web.common.JDBCTemplate.close;
import static com.web.common.JDBCTemplate.getConnection;
import static com.web.shoppingmall.model.dao.ShoppingmallDao.getDao;

import java.sql.Connection;
import java.util.List;

import com.web.shoppingmall.model.dto.Product;
import com.web.shoppingmall.model.dto.ProductOption;
import com.web.user.model.dto.User;
/*
 * 	쇼핑몰 관련 서비스 클래스
 */
public class ShoppingmallService {
	private static ShoppingmallService service= new ShoppingmallService();
	public static ShoppingmallService getService() {return service;}
	private ShoppingmallService() {}
	
	/*
	 * 	매개변수로 받은 카테고리의 총 상품 갯수 반환 메소드
	 * 	매개변수 : 카테고리 정보
	 * 	반환 : 해당 카테고리 상품 총 갯수
	 */
	public int allProductCount(int category) {
		Connection conn=getConnection();
		int result=getDao().AllProductCount(conn, category);
		close(conn);
		return result;
	}
	
	/*
	 * 	매개변수로 받은 페이지와 카테고리와 정렬기준에 맞는 상품들의 정보를 가져오는 메소드
	 * 	매개변수 : 카테고리넘버, 현재페이지숫자, 출력할상품갯수, 정렬기준
	 * 	반환 : 상품 리스트
	 */
	public List<Product> selectProduct(int category, int cPage, int numPerpage, String sort){
		Connection conn=getConnection();
		List<Product> result=getDao().selectProduct(conn, category, cPage, numPerpage, sort);
		close(conn);
		return result;
	}
	
	/*
	 * 	쇼핑몰 상품 상세페이지에 필요한 상품정보를 가져오는 메소드
	 * 	상품의 고유키로 상품을 검색하여 가져온다.
	 * 	매개변수 : 상품고유키
	 * 	반환 : 상품 객체
	 */
	public Product selectProductByKey(int productKey) {
		Connection conn=getConnection();
		Product result=getDao().selectProductByKey(conn, productKey);
		close(conn);
		return result;
	}
	
	/*
	 * 	쇼핑몰 상품 상세페이지의 상품에 대한 상품옵션 객체를 반환하는 메소드
	 * 	상품의 고유키로 검색하여 상품옵션객체를 가져온다
	 * 	매개변수 : 상품고유키, 사이즈
	 * 	반환 : 상품옵션 객체
	 */
	public ProductOption selectProductOptionByKey(int productKey) {
		Connection conn=getConnection();
		ProductOption result=getDao().selectProductOptionByKey(conn, productKey);
		close(conn);
		return result;
	}
	
	/*
	 * 	쇼핑몰 상품 상세페이지의 상품에 대한 사이즈 옵션에 대한 상품옵션 객체리스트를 반환하는 메소드
	 * 	상품의 고유키와 사이즈로 검색하여 상품옵션객체리스트를 가져온다
	 * 	매개변수 : 상품고유키, 사이즈
	 * 	반환 : 상품옵션 리스트
	 */
	public List<ProductOption> selectProductOptionBySize(int productKey, String size){
		Connection conn=getConnection();
		List<ProductOption> result=getDao().selectProductOptionBySize(conn, productKey, size);
		close(conn);
		return result;
	}
	
	/*
	 * 	쇼핑몰 상품 상세페이지의 상품에 대한 사이즈 옵션에 대한 상품옵션 객체를 반환하는 메소드
	 * 	상품의 고유키와 사이즈로 검색하여 상품옵션객체를 가져온다
	 * 	매개변수 : 상품고유키, 사이즈
	 * 	반환 : 상품옵션 객체
	 */
	public ProductOption selectProductOptionByColor(int productKey, String color){
		Connection conn=getConnection();
		ProductOption result=getDao().selectProductOptionByColor(conn, productKey, color);
		close(conn);
		return result;
	}
	
	/*
	 * 	쇼핑몰 상품 상세페이지의 상품에대한 리뷰들을 가진 회원 객체를 반환하는 메소드
	 * 	상품의 고유키로 리뷰들을 검색하여 리뷰 리스트를 반환
	 * 	매개변수 : 상품고유키
	 * 	반환 : 리뷰 리스트
	 */	
	 public List<User> selectReviewByProductKey(int productKey){
		 Connection conn=getConnection();
		 List<User> result=getDao().selectReviewByProductKey(conn, productKey);
		 close(conn);
		 return result;
	 }
}
