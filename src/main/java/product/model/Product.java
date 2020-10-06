package product.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int num;
	
	@Length(min = 3,max = 10,message = "상품이름은 최소3자리 최대10자리 입니다.")
	private String name ;
	private String company ;
	
	@NotEmpty(message = "화일 선택 안함")
	private String image ;
	
	private int stock ; 
	
	@Min(value = 3000,message = "가격은 최소 3000원 이상입니다.")
	private int price ;
	private String category ;
	
	@Length(min = 5,max = 10,message = "상품설명은 최소5자리 최대10자리 입니다.")
	private String contents ;
	
	private int point ;
	private String inputdate ;
	
	private int orderqty; // 주문수량
	
	private MultipartFile upload;
	
	private String uploadOld;//수정 이전 파일 담음
	
	public String getUploadOld() {
		return uploadOld;
	}
	public void setUploadOld(String uploadOld) {
		this.uploadOld = uploadOld;
	}
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("upload : " + upload); // coke.jpg(X) 
		if(upload != null) {
			System.out.println(upload.getName()); // upload
			System.out.println(upload.getOriginalFilename()); // coke.jpg
			this.image = upload.getOriginalFilename();
		}
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public int getOrderqty() {
		return orderqty;
	}
	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}
	
	
}
