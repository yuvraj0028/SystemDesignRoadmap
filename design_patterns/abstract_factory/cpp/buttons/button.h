#pragma once

class Button {
public:
    virtual ~Button() = default;
    virtual void paint() const = 0;
};