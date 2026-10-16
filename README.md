# CS 2114 Project 2: To-Do List

## About the Project

This is a Java to-do list app for keeping track of school assignments, chores, and other personal tasks. From the menu, a user can add tasks, view them, or mark them complete.

A big part of the project was learning to reuse a generic data structure instead of writing a different linked list for every task type. We use the staff-provided `LinkedChain<T>` for `SchoolAssignment`, `Chore`, and `CustomTask` objects. Each task class stores its own details, while `TaskManager` keeps track of the three chains. `ToDoApp` runs the menu, and `InputHandler` reads and checks the user's input. Assignment types are homework, exam, or project, and due dates must be entered as `YYYY-MM-DD`.

## How to Build and Run

### In Eclipse

1. Save your changes.
2. Make sure the project uses **JRE System Library [JavaSE-1.8]**. You can check this under the project's **Properties → Java Build Path → Libraries**. The compiler compliance setting should also be 1.8.
3. Choose **Project → Build Project**. If **Build Automatically** is enabled, Eclipse normally rebuilds when you save.
4. In the Package Explorer, right-click `src/todo/ToDoApp.java` and choose **Run As → Java Application**.


### Run Tests and Check Coverage

To run the tests, right-click the `todo.tests` package in the Package Explorer and choose **Run As → JUnit Test**. To see which application code the tests reach, choose **Coverage As → JUnit Test** instead. Run the test package, not `ToDoApp.java`, so the test cases execute. The JUnit view shows errors and failures, and the Coverage view shows covered and uncovered lines.

## Reflection

### 1. What changed from our specification, and why?

The overall design stayed pretty close to our original plan, but some details had to change once we started connecting the classes.

One example was the `LinkedChain` API. Our specification used names such as `getEntry(int position)` and `getLength()`, but the provided class has `get(int index)` and `size()`. It also removes an entry with `remove(T anEntry)` rather than removing by index, so `TaskManager` first gets the task at the selected index and then removes that task.

We kept one chain per task type in `TaskManager`. When adding a task, we use `addToEnd()` so the list stays in the order the user entered things. The provided `add()` method puts new entries at the front, which would reverse that order.

We also added input checks as we built the menu. Numeric prompts repeat if the input is not a valid number or is outside the allowed range. Priorities must be from 1 to 5, estimated hours cannot be negative, names cannot be blank, and school assignments must use one of the listed types and a real date in `YYYY-MM-DD` format.

The classes each have a main job: the task classes hold task details, `TaskManager` manages the chains, `InputHandler` handles input, and `ToDoApp` runs the menu. Keeping those responsibilities separate made it easier to see where a change belonged.

Our class design came from our group specification. We checked the provided `LinkedChain` source when its API did not match our original method names. We also used ChatGPT to talk through implementation ideas, method usage, input checks, and README wording. We still need to review suggestions as a group and make sure we understand and verify the final code.

### 2. What changed in `LinkedChain`?

We reused the generic `LinkedChain<T>` supplied by the CS 2114 staff instead of making three separate linked-list classes. Our code uses methods such as `addToEnd()`, `remove(T anEntry)`, `get(int index)`, `size()`, and `isEmpty()`.

The chain only handles storing entries. The rest of the application decides what those entries represent and how the user works with them. We did not modify `LinkedChain.java`; the provided implementation is unchanged.

### 3. What happened to our unknowns?

At first, we were not sure how one generic structure could hold different kinds of tasks. Giving each type its own `LinkedChain<T>` turned out to be a straightforward way to reuse the same class without mixing the task types.

We also had to account for the difference between the menu numbers and the chain indexes. The menu shows the first task as number 1, but `LinkedChain.get()` starts at index 0. `ToDoApp` subtracts 1 from the user's selection before passing the index to `TaskManager`.

Some method calls in our first version did not match the declarations in `InputHandler` or `LinkedChain`. Comparing the calls with the actual method names helped us fix those mismatches. We also used loops and exception handling so the program can ask again when a user enters invalid numeric input.

### 4. What still needs work?

The MVP is working, and our tests cover the important task, input, collection, and menu behavior. We can run the suite with Eclipse's coverage runner to see which lines are reached. The `DailyPlanner` and `FileHandler` ideas are not part of the current version, so they are optional stretch goals rather than unfinished MVP work.

We didnt know if we had to do code testing covereage for the provided LinkedChain class, so if we have to do that that still needs to be done. 

## Next Steps

Now that the MVP is working, our next project work is to choose a stretch goal and build it into the app we already have. We can keep using the current task classes and `TaskManager` instead of creating a separate program for the new feature.

1. Decide whether to implement `DailyPlanner`, `FileHandler`, or both. Owner: [All]
2. For `DailyPlanner`, use tasks already stored in `TaskManager`. Recommend tasks based on their priority and estimated hours, and add a menu option in `ToDoApp` for the user to enter available time and see the recommendations. Owner: [Rohan]
3. For `FileHandler`, save and load the existing school assignments, chores, and custom tasks. Connect saving and loading to the app menu, and make sure loaded tasks go back into the appropriate `TaskManager` lists. Owner: [Issac]
4. Test the new feature with normal data and edge cases, such as no tasks that fit the available time or a missing or invalid save file. If we build both goals, test that saved tasks can be loaded and then used by the planner. Owner: [Aaron]

## Stretch Goals

**DailyPlanner (deferred):** Our original idea was a planner that recommends tasks based on priority and estimated completion time. If we add it, we will need to test task selection, available hours, and what happens when no task fits the time available.

**FileHandler (deferred):** We also considered saving tasks to a file and loading them later. That would need tests for saving, loading, and handling missing or invalid files.

## Who Worked on What

Fill in the names and adjust the descriptions to match the work each person actually did.

- `LinkedChain.java`: CS 2114 staff provided this file; our project left it unchanged.
- `SchoolAssignment.java`: [Rohan] - [Implementation, revisions, and testing]
- `Chore.java`: [Rohan] - [Implementation, revisions, and testing]
- `CustomTask.java`: [Rohan] - [Implementation, revisions, and testing]
- `TaskManager.java`: [Rohan] - [Implementation, revisions, and testing]
- `InputHandler.java`: [Rohan] - [Implementation, revisions, and testing]
- `ToDoApp.java`: [Rohan] - [Implementation, revisions, and testing]
- `ChoreTest.java`: [Issac] - [Tests written and verified]
- `CustomTaskTest.java`: [Issac] - [Tests written and verified]
- `InputHandlerTest.java`: [Issac] - [Tests written and verified]
- `SchoolAssignmentTest.java`: [Rohan] - [Tests written and verified]
- `TaskManagerTest.java`: [Rohan] - [Tests written and verified]
- `ToDoAppTest.java`: [Rohan] - [Tests written and verified]
- `README.md`: [Rohan] - [Documentation and reflection]

### Generative AI Attribution

We used ChatGPT to discuss Java implementation ideas, check method usage against the provided `LinkedChain` API, think through input validation, plan and finish our coverage tests, and help draft this README. We are responsible for reviewing the suggestions, understanding the final code, and making sure the project and tests work before submitting.
