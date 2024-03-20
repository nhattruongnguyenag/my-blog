package com.nhattruongnguyen.properties;

public class PaginationProperties {
    private Integer webPostNumberItemPerPage;
    private Integer adminCategoryNumberItemPerPage;
    private Integer adminPostNumberItemPerPage;

    public Integer getWebPostNumberItemPerPage() {
        return webPostNumberItemPerPage;
    }

    public void setWebPostNumberItemPerPage(Integer webPostNumberItemPerPage) {
        this.webPostNumberItemPerPage = webPostNumberItemPerPage;
    }

    public Integer getAdminCategoryNumberItemPerPage() {
        return adminCategoryNumberItemPerPage;
    }

    public void setAdminCategoryNumberItemPerPage(Integer adminCategoryNumberItemPerPage) {
        this.adminCategoryNumberItemPerPage = adminCategoryNumberItemPerPage;
    }

    public Integer getAdminPostNumberItemPerPage() {
        return adminPostNumberItemPerPage;
    }

    public void setAdminPostNumberItemPerPage(Integer adminPostNumberItemPerPage) {
        this.adminPostNumberItemPerPage = adminPostNumberItemPerPage;
    }
}
