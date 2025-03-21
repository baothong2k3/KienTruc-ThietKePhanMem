package fit;

public class TaskObserverDemo {
    public static void main(String[] args) {
        Task task1 = new Task("Implement Login Feature", "To Do");

        TeamMember alice = new TeamMember("Alice");
        TeamMember bob = new TeamMember("Bob");

        task1.registerObserver(alice);
        task1.registerObserver(bob);

        task1.setStatus("In Progress");
        task1.setStatus("Code Review");

        task1.removeObserver(bob);
        task1.setStatus("Done");
    }
}