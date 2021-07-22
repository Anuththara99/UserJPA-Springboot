package com.anu.springunijpa.service.impl;

public enum Search {
    ID(0),NAME(null),TEL(null);
    private int value;

    Search(Integer value) {
        this.value = value;
    }
}
