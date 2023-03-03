package com.company.train.service.price;

import java.util.Objects;

public class Price {
    private final Integer zoneStart;
    private final Integer zoneEnd;
    private final int price;

    public Price(Integer zoneStart, Integer zoneEnd, int price) {
        this.zoneStart = zoneStart;
        this.zoneEnd = zoneEnd;
        this.price = price;
    }

    public Integer getZoneStart() {
        return zoneStart;
    }

    public Integer getZoneEnd() {
        return zoneEnd;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 && zoneStart.equals(price1.zoneStart) && zoneEnd.equals(price1.zoneEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoneStart, zoneEnd, price);
    }
}
