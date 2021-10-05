package com.nepalaya.threadbasics;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class LimitedArrayList<T> extends ArrayList<T> {

    private int limit;

    public LimitedArrayList(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean add(T item) {
        if (this.size() > limit)
            throw new RuntimeException("Cannot store more than this");
        return super.add(item);
    }
}
