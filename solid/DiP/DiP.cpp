#include <iostream>
#include <string>

// Interface for version control system
class IVersionControl {
public:
    virtual ~IVersionControl() = default;
    virtual void commit(const std::string& message) = 0;
    virtual void push() = 0;
    virtual void pull() = 0;
};

// Git version control implementation
class GitVersionControl : public IVersionControl {
public:
    void commit(const std::string& message) override {
        std::cout << "Committing changes to Git with message: " << message << std::endl;
    }

    void push() override {
        std::cout << "Pushing changes to remote Git repository." << std::endl;
    }

    void pull() override {
        std::cout << "Pulling changes from remote Git repository." << std::endl;
    }
};

// Team class that relies on version control, but only on the abstraction
class DevelopmentTeam {
private:
    IVersionControl& versionControl;

public:
    explicit DevelopmentTeam(IVersionControl& vc) : versionControl(vc) {}

    void makeCommit(const std::string& message) {
        versionControl.commit(message);
    }

    void performPush() {
        versionControl.push();
    }

    void performPull() {
        versionControl.pull();
    }
};

int main() {
    GitVersionControl git;
    DevelopmentTeam team(git);

    team.makeCommit("Initial commit");
    team.performPush();
    team.performPull();

    return 0;
}