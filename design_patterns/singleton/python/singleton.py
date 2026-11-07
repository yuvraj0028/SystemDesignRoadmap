import threading


class Singleton:
    _instance = None
    _lock = threading.Lock()

    def __new__(cls) -> "Singleton":
        if cls._instance is None:
            with cls._lock:
                if cls._instance is None:
                    cls._instance = super().__new__(cls)
        return cls._instance


def main() -> None:
    a = Singleton()
    b = Singleton()

    print("Equal" if a is b else "Unequal")


if __name__ == "__main__":
    main()
