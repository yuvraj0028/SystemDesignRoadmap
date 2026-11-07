class GPSNavigator:
    DEFAULT_ROUTE = (
        "221b, Baker Street, London to Scotland Yard, 8-10 Broadway, London"
    )

    def __init__(self, route: str | None = None) -> None:
        self.route = route if route is not None else self.DEFAULT_ROUTE

    def get_route(self) -> str:
        return self.route
