# Git Workflow

| Date       | Status   | Decided By     | Description     |
|------------|----------|----------------|-----------------|
| 14/12/2023 | Accepted | - Nick Bauters | Initial version |

## Workflow

### Public repository

The public repository is hosted on GitHub and can be found [here]().   
How GitHub is being implemented in this project, is described via [github-usage.md](./github-usage.md).

### Branching

For every issue that is picked up, a new branch should be created that adheres to the style rules.
This branch should be created from the most recent version of the master branch.
This should always be done via the GitHub interface as described in the GitHub guidelines.

### Commits

Committing should be done regularly, so commits don't get to large.
This can only be done on a specific branch.
Committing to master/main is not permitted.

Every commit should be accompanied by a commit message. This message should be styled as the style guide for commits describes.

### Pull Requests

Once feedback is needed on a branch, at the latest when the branch is ready for merge review, a pull request should be created.
The creation of pull requests should always be done via the GutHub interface as described in the GitHub guidelines.

A pull request may only be closed by the project Owner or the creator of the pull request.

### Merging

Merging should always be done via the GitHub interface as described in the GitHub guidelines.
Merging requires
- A Pull request is created for feedback on the submitted code.
- At least one approval from a team member that is not the creator of the pull request.
- All checks to be passed.
- All pull request discussions to be resolved.
- No merge conflicts.

The merging of a pull request may only be done by the project owner or the creator of the pull request.

When a merge is completed, the branch should be deleted via the GitHub interface.

## Naming conventions

This chapter describes the naming conventions that should be used when working with git in this project.

Not following these rules, might result in changes not being approved for merging.

### Branches

A branch should always adhere to the following styling rules:

- The branch name should be written in English
- The branch name should begin with a subdivision in the kind of change that is requested
    - `feature`: For new features and changes to functionality
    - `fix`: For branches that tackle specific bugs that need fixing
    - `refactor`: For branches that are specific in nog changing function, but only clean up the code base
    - `docs`: For branches that add documentation or research cases to the project or change configuration based on investigation
- The branch should than follow with a `/` and the issue number
- Example
    - `feature/issue-#1`
    - `fix/issue-#2`
    - `refactor/issue-#3`

### Commits

A commit should always adhere to the following styling rules:
- The commit message should be written in English
- The commit message should be written in present tense
- The commit message should be written in imperative mood
- First line message format:
    - The commit message should start with the issue number `issue-#<number>:`
    - The commit message should be followed with the type of commit
        - `feat`: A functionality change
        - `test`: A test change
        - `refactor`: A code refactor
        - `fix`: A bug fix
        - `info`: An investigative commit that changes documentation
        - `config`: A configuration change
    - The commit message should be ended with a short descriptive message that explains the change
- Following lines should only be added to add context to the commit message.