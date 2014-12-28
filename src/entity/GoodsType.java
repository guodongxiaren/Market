package entity;

public class GoodsType {
    private int goodsTypeId;
    private String goodsTypeName;
    
	public GoodsType(int goodsTypeId, String goodsTypeName) {
		this.goodsTypeId = goodsTypeId;
		this.goodsTypeName = goodsTypeName;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

}
