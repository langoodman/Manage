package com.ctgu.lan.manage.model;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;

    private Integer staffId;

    private Integer pharmacyId;

    private Integer userId;

    private Double shouldMoney;

    private Double rellyMoney;

    private Integer integral;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getShouldMoney() {
        return shouldMoney;
    }

    public void setShouldMoney(Double shouldMoney) {
        this.shouldMoney = shouldMoney;
    }

    public Double getRellyMoney() {
        return rellyMoney;
    }

    public void setRellyMoney(Double rellyMoney) {
        this.rellyMoney = rellyMoney;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", staffId=").append(staffId);
        sb.append(", pharmacyId=").append(pharmacyId);
        sb.append(", userId=").append(userId);
        sb.append(", shouldMoney=").append(shouldMoney);
        sb.append(", rellyMoney=").append(rellyMoney);
        sb.append(", integral=").append(integral);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}