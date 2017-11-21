package com.denny.task01.common.domain;

public class Org {

    private Long id;

    private String orgName;

    private String orgAddress;

    public Org(Long id, String orgName, String orgAddress) {
    	this.id = id;
        this.orgName = orgName;
        this.orgAddress = orgAddress;
    }

    public Org() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }
}