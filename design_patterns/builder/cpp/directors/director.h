#pragma once

#include "../builders/builder.h"

class Director {
public:
    void constructSportsCar(Builder& builder) const;
    void constructCityCar(Builder& builder) const;
    void constructSUV(Builder& builder) const;
};
