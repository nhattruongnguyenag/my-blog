package com.nhattruongnguyen.domain;

public class PaginationItem {
    private boolean isFirst = false;
    private boolean isLast = false;
    private boolean isActive = false;
    private boolean visible = false;
    private boolean isRenderEllipsis = false;
    private int index = 1;
    private String currentPage;
    private String prevPage;
    private String nextPage;

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isRenderEllipsis() {
        return isRenderEllipsis;
    }

    public void setRenderEllipsis(boolean renderEllipsis) {
        isRenderEllipsis = renderEllipsis;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(String prevPage) {
        this.prevPage = prevPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
