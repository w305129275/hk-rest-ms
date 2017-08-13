package com.team.hk.storeInfo.entity;

/**
 * Created by lidongliang on 2017/7/9.
 * 餐厅相片实体
 */
public class StoreImg {

    private static final long serialVersionUID = 1L;

    private Long id;            // 主键ID
    private Long storeId;       // 餐厅编号
    private String imgUrl;      // 餐厅相片


    public StoreImg() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "StoreImg{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
