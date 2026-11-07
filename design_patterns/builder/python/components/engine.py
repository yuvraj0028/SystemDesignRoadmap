class Engine:
    def __init__(self, volume: float, mileage: float) -> None:
        self.volume = volume
        self.mileage = mileage
        self.started = False

    def on(self) -> None:
        self.started = True

    def off(self) -> None:
        self.started = False

    def is_started(self) -> bool:
        return self.started

    def get_volume(self) -> float:
        return self.volume

    def get_mileage(self) -> float:
        return self.mileage

    def go(self, mileage: float) -> None:
        if self.started:
            self.mileage += mileage
        else:
            print("Cannot go(), you must start engine first!")
