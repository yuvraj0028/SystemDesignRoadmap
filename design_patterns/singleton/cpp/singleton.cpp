#include <iostream>

class Singleton {
public:
    Singleton(const Singleton&) = delete;
    Singleton& operator=(const Singleton&) = delete;

    static Singleton& getInstance() {
        static Singleton instance;
        return instance;
    }

private:
    Singleton() = default;
};

int main() {
    Singleton& a = Singleton::getInstance();
    Singleton& b = Singleton::getInstance();

    std::cout << (&a == &b ? "Equal" : "Unequal") << std::endl;
    return 0;
}
