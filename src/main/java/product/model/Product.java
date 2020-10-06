package product.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int num;
	
	@Length(min = 3,max = 10,message = "��ǰ�̸��� �ּ�3�ڸ� �ִ�10�ڸ� �Դϴ�.")
	private String name ;
	private String company ;
	
	@NotEmpty(message = "ȭ�� ���� ����")
	private String image ;
	
	private int stock ; 
	
	@Min(value = 3000,message = "������ �ּ� 3000�� �̻��Դϴ�.")
	private int price ;
	private String category ;
	
	@Length(min = 5,max = 10,message = "��ǰ������ �ּ�5�ڸ� �ִ�10�ڸ� �Դϴ�.")
	private String contents ;
	
	private int point ;
	private String inputdate ;
	
	private int orderqty; // �ֹ�����
	
	private MultipartFile upload;
	
	private String uploadOld;//���� ���� ���� ����
	
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
