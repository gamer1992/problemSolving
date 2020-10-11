package com.guru.learning;

public class Tuple<T> {
    T minimum;
    T maximum;

    public Tuple(T min, T max){
        this.minimum=min;
        this.maximum=max;
    }

    @Override
    public String toString() {
        return minimum +" "+ maximum;
    }
}
