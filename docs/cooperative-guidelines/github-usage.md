# Git Workflow

| Date       | Status   | Decided By     | Description     |
|------------|----------|----------------|-----------------|
| 14/12/2023 | Accepted | - Nick Bauters | Initial version |

## Workflow

### Open Source Repository

The repository is made open source via GutHub.
This application might be pushed to maven-central in the future.

### Issues and Issueboard

The github issueboard is used to manage the project.
This board is implemented in the Project folder that connects to the github repository.

#### Issues

Every issue is a change request to the current project.
These are currently categorised as follows:

- **New Feature**: Proposition of new or adjusted functionality to the project code base.
- **Bug**: Proposition of a problem that needs to be looked at and fixed if needed.
- **Investigation**: Proposition for changes around documentation, cooperation and configuration of the project.

For every category, there is a template that should be used in the issue tracker on GitHub.
All new issues should be created within the issue tracker of the repository.
This will automatically add an issue ticket to the backlog of the project issueboard.

##### Creating a new Issue

A new issue should be created on the project board with the following steps:

1. Go to the project board **Product Development Board**
2. In the Backlog bucket, select the **+ Add item** button
3. Type # followed by the repository name or select it from the list (**archilios-DomainMapper**)
4. Select **create new issue**
5. Select the corresponding template
6. Fill in the issue template
7. Select **Submit new issue**

The issue will be added to the backlog of the issueboard.
And will be reviewed by the project owner.

#### Issueboard

The issueboard is used to plan upcomming issues into a production lifecycle.
Issue tickets are reviewed and planned for a specific milestone. They are also ordered in order of importance.

The issue board is divided into 5 columns:
1. **Backlog**: All issues that are not yet planned for a milestone
2. **Ready for Development**: All issues that are correctly documented and are ready to be developed. They are ordered from top to bottom, most important to least important.
3. **In Development**: All issues that are currently being developed. There should never be more tickets in this column than there are developers.
4. **In Review**: All issues that are ready for review. These issues are ready to be merged into the master branch but still need feedback and quick changes.
5. **Feature**: All issues that are completed and merged into the master branch.

### Starting a new Issue for development

A new issue ticket can only be picked up, when you have reviewed all open Pull requests and changes in the review bucket.
A new issue ticket should always be taken from the top of the **_Ready for Development_** bucket.

The issue tickets meta-data should always be added when the ticket is picked up.

### Branches

When a new issue is picked up, a new branch should be created from the master branch.
This should always be done via GitHub with the following workflow:
1. Go to the project issueboard
2. Select the issue ticket
2. Select the title of the ticket
2. Select the **Create branch** button in the right side bar
3. Name the branch according to the **Branch naming conventions** in **C001-git**
4. Add the necessary metadata to the issue ticket
4. Select **Create branch**

### Pull Requests and reviews

When a branch is ready for review, a pull request should be created.
A pull request should also be created when feedback is needed on a branch.
The sooner feedback is requested, the better the quality will be of the developed code and the easier a review will be.

A pull request should always be created via the GitHub interface.
This should be done with the following workflow:
1. Go to the project issueboard
2. Select the issue ticket
3. Navigate to the issue in the repository by clicking the title
3. Select the **Create pull request** button in the right side bar
4. Add the necessary metadata to the pull request template
   5. Do not add the project as meta-data
6. Select **Create pull request**

If a specific member should review, you can add them as a reviewer.

The name of the pull request should always be the same as the issue ticket.
And should start with the issue number.

### Merging

When a branch is finished and ready for merging and the pull request is approved, the branch should be merged into the master branch.
This should always be done via the GitHub interface.

The following steps may only be taken by the project owner or the creator of the branch.

The following workflow should be used:
1. Go to the project issueboard
2. Select the pull request number on the card of the issue ticket
3. Check if all requirements are met
4. Select **Merge pull request**
5. Select **Confirm merge**
6. Select **Delete branch**

## Definitions

Later in the project life, the following definitions will be added to the documentation:
- Ready for development
- Ready for release