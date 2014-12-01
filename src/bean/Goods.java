package bean;

public class Goods {
	private int goodsid;
	private String goodsname;
	private int supplierid;
	private int goodstypeid;
	private String brand;
	private String goodsmodel;
	private String description;
	private double price;
	private int storage;

	public Goods(int goodsid, String goodsname, int supplierid,
			int goodstypeid, String brand, String goodsmodel,
			String description, double price, int storage) {
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.supplierid = supplierid;
		this.goodstypeid = goodstypeid;
		this.brand = brand;
		this.goodsmodel = goodsmodel;
		this.description = description;
		this.price = price;
		this.storage = storage;
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public int getGoodstypeid() {
		return goodstypeid;
	}

	public void setGoodstypeid(int goodstypeid) {
		this.goodstypeid = goodstypeid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGoodsmodel() {
		return goodsmodel;
	}

	public void setGoodsmodel(String goodsmodel) {
		this.goodsmodel = goodsmodel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

}
