package com.company.train.constant;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Constant {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final double CENT = 100;

    public static final double[][] ticket_prices = {
            {-1, -1, -1, -1, -1},
            {-1, 2.4, 2.4, 2.8, 3},
            {-1, 2.4, 2.4, 2.8, 3},
            {-1, 2.8, 2.8, 2, 2},
            {-1, 3, 3, 2, 2}
    };

    private Constant() {
    }
}
