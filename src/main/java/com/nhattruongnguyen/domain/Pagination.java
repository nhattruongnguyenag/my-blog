package com.nhattruongnguyen.domain;

import java.util.List;

public class Pagination {
    private int totalPages;
    private int currentIndex;
    private List<PaginationItem> paginations;

    public Pagination(int totalPages, int currentIndex) {
        this.totalPages = totalPages;
        this.currentIndex = currentIndex;

        boolean showEllipsis = true;

        for (int i = 1; i <= this.totalPages; i++) {
            PaginationItem paginationItem = new PaginationItem();
            paginationItem.setIndex(i);

            if (i == currentIndex) {
                paginationItem.setActive(true);
            }

            if (i == 1) {
                paginationItem.setFirst(true);
            }

            if (i == totalPages) {
                paginationItem.setLast(true);
            }

            if (i <= 5 || i >= this.currentIndex && i <= this.currentIndex + 2 || i == this.totalPages) {
                paginationItem.setVisible(true);
//            } else if (showEllipsis || ) {
//
//            }
            }
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public List<PaginationItem> getPaginations() {
        return paginations;
    }

    public void setPaginations(List<PaginationItem> paginations) {
        this.paginations = paginations;
    }
}
