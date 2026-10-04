#pragma once

class Checkbox {
public:
    virtual ~Checkbox() = default;
    virtual void paint() const = 0;
};