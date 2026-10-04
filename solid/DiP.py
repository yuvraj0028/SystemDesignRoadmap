from abc import ABC, abstractmethod


# Interface for version control system
class IVersionControl(ABC):
    @abstractmethod
    def commit(self, message: str) -> None:
        ...

    @abstractmethod
    def push(self) -> None:
        ...

    @abstractmethod
    def pull(self) -> None:
        ...


# Git version control implementation
class GitVersionControl(IVersionControl):
    def commit(self, message: str) -> None:
        print(f"Committing changes to Git with message: {message}")

    def push(self) -> None:
        print("Pushing changes to remote Git repository.")

    def pull(self) -> None:
        print("Pulling changes from remote Git repository.")


# Team class that relies on version control, but only on the abstraction
class DevelopmentTeam:
    def __init__(self, version_control: IVersionControl) -> None:
        self.version_control = version_control

    def make_commit(self, message: str) -> None:
        self.version_control.commit(message)

    def perform_push(self) -> None:
        self.version_control.push()

    def perform_pull(self) -> None:
        self.version_control.pull()


def main() -> None:
    git = GitVersionControl()
    team = DevelopmentTeam(git)

    team.make_commit("Initial commit")
    team.perform_push()
    team.perform_pull()


if __name__ == "__main__":
    main()