# Testing Rules

| Date       | Status   | Decided By     | Description     |
|------------|----------|----------------|-----------------|
| 14/12/2023 | Accepted | - Nick Bauters | Initial version |

## Testing

### Unit tests

The entire codebase should be covered by unit tests.
We prefer UseCase based testing over component based testing.

Our unit tests should be the first examples on how to use our library.

## When should tests run

1. After every change, the test suite should be run locally
2. After every push, the test suite should be run on the CI
3. With every pull request, the test suite should be run on the CI