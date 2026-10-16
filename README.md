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

If Eclipse seems to be running old code, use **Project → Clean…**, select this project, and clean it before running again. Cleaning removes generated class files, not your Java source files; Eclipse rebuilds the class files from the saved source.

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

The menu includes options to add, view, and complete each kind of task, but we still need to verify the full application. The JUnit test files are in the project, though they do not have test methods yet. We need to write tests for the task classes, `TaskManager`, and input handling, then run through the whole menu flow.

The `DailyPlanner` and `FileHandler` ideas are not in the current version. We plan to focus on finishing and testing the required features before trying either stretch goal.

Before submitting, update this line with the actual results: **Build and test results:** [Add the compile result, tests run, and any unfinished features or known bugs. If everything passes, say so here.]

## Next Steps

Our first priority is to finish the minimum version and make sure it works. Add an owner beside each item once the group decides who is handling it.

1. Test adding, viewing, and completing every task type, including empty lists. Owner: [Name]
2. Write `TaskManager` tests for adding, retrieving, removing, and invalid indexes. Owner: [Name]
3. Write task class tests for constructors, getters, and string output. Owner: [Name]
4. Test input handling for invalid numbers, out-of-range values, blank names, invalid assignment types and dates, and negative hours. Owner: [Name]
5. Compile the project, fix any remaining errors, and run the available tests. Owner: [Name]
6. Compare the finished README with the specification and update any details that changed. Owner: [Name]
7. If the required features are done, choose a stretch goal and add tests for it. Owner: [Name]

## Stretch Goals

**DailyPlanner (deferred):** Our original idea was a planner that recommends tasks based on priority and estimated completion time. If we add it, we will need to test task selection, available hours, and what happens when no task fits the time available.

**FileHandler (deferred):** We also considered saving tasks to a file and loading them later. That would need tests for saving, loading, and handling missing or invalid files.

## Who Worked on What

Fill in the names and adjust the descriptions to match the work each person actually did.

- `LinkedChain.java`: CS 2114 staff provided this file; our project left it unchanged.
- `SchoolAssignment.java`: [Rohan] - [Implementation, revisions, and testing]
- `Chore.java`: [Rohan] - [Implementation, revisions, and testing]
- `CustomTask.java`: [Rohan] - [Implementation, revisions, and testing]
- `TaskManager.java`: [Rohan)] - [Implementation, revisions, and testing]
- `InputHandler.java`: [Rohan] - [Implementation, revisions, and testing]
- `ToDoApp.java`: [Rohan] - [Implementation, revisions, and testing]
- `ChoreTest.java`: [Rohan] - [Tests written and verified]
- `CustomTaskTest.java`: [Name(s)] - [Tests written and verified]
- `InputHandlerTest.java`: [Name(s)] - [Tests written and verified]
- `SchoolAssignmentTest.java`: [Name(s)] - [Tests written and verified]
- `TaskManagerTest.java`: [Name(s)] - [Tests written and verified]
- `ToDoAppTest.java`: [Name(s)] - [Tests written and verified]
- `README.md`: [Name(s)] - [Documentation and reflection]

### Generative AI Attribution

We used ChatGPT to discuss Java implementation ideas, check method usage against the provided `LinkedChain` API, think through input validation, and help draft this README. We are responsible for reviewing the suggestions, understanding the final code, and making sure the project and tests work before submitting.
