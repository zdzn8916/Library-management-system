package com.xiaokasidi.entity;

public class Library {
    private Integer libraryId;
    private String libraryName;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId=" + libraryId +
                ", libraryName='" + libraryName + '\'' +
                '}';
    }

    public Library(Integer libraryId, String libraryName) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
}
