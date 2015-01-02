package res;

public final class Table {

	public static final class title {
		public static final String goods = "商品列表";
		public static final String customer = "客户列表";
		public static final String supplier = "供应商列表";
		public static final String order = "订单列表";
		public static final String goodsType = "商品类型列表";
		public static final String creditGrade = "信誉等级列表";
		public static final String summary = "信息汇总";
	}

	public static final class goods {
		public static final String[] fields = { "商品编号", "商品名称", "供应商", "商品类型",
				"商标", "商品型号", "描述", "价格", "库存量" };
	}

	public static final class customer {
		public static final String[] fields = { "编号", "名称", "注册名", "密码",
				"注册时间", "信誉等级", "地址", "邮编", "联系电话", "邮箱地址", "备注信息" };
	}

	public static final class supplier {
		public static final String[] fields = { "编号", "名称", "注册名", "密码",
				"注册时间", "信誉等级", "自我描述", "地址", "邮编", "联系电话", "邮箱地址", "备注信息" };
	}

	public static final class order {
		public static final String[] fields = { "订单编号", "客户姓名", "商品名称", "订单数量",
				"订单金额", "订货日期" };
	}

	public static final class goodsType {
		public static final String[] fields = { "编号", "商品名称" };
	}

	public static final class creditGrade {
		public static final String[] fields = { "等级编号", "等级名称" };
	}

	public static final class summary {

		public static final String goodsCount = "商品数量";
		public static final String orderCount = "订单数量";
		public static final String customerCount = "客户数量";
		public static final String supplierCount = "供应商数量";
	}
}
