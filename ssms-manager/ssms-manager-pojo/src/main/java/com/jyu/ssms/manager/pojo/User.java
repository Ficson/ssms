package com.jyu.ssms.manager.pojo;


import java.util.Date;

public class User {
    private Integer id;

    private String apikey;

    private String phone;

    private String password;

    private Integer status;

    private Integer balance;

    private Date createtime;

    private Date updatetime;

    public User(Integer id, String apikey, String phone, String password, Integer status, Integer balance, Date createtime, Date updatetime) {
        this.id = id;
        this.apikey = apikey;
        this.phone = phone;
        this.password = password;
        this.status = status;
        this.balance = balance;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey == null ? null : apikey.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
