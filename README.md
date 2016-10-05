## Description
a basic example of geb in grails for functional testing
follow the commits from the beginning to see what was done

### commit [2301e](https://github.com/basejump/grails3-geb-example/commit/5916b63560ab314a0bcfa66ff54e31de8102301e)
ran ```grails create-app grails3-geb-example```
stock

### commit [393f](https://github.com/basejump/grails3-geb-example/commit/563595e091d7445751cf8cd31492aadb21b1393f)
`grails create-domain-class geb.Skydive` and `grails create-scaffold-controller geb.Skydive` . can do a run-app now fo
- removed the spec test created for the domain
- added gitignore and readme

### commit [8af4](https://github.com/basejump/grails3-geb-example/commit/178dacdba3cc11b25efd79e3956cb357c1c58af4)
`create-functional-test geb.Skydive` and `test-app -integration` works with a single test against the app using the st

### commit [4b0c](https://github.com/basejump/grails3-geb-example/commit/1f70919784d57f2d974e25b0fecb6d26c68f4b0c)
added GebConfig and deps with build.grade tweaks to pass system properties. `grails -Dgeb.env= phantom test-app` ... w
Environments setup for
* phantom - `-Dgeb.env=phantom test-app`
* chrome - `-Dgeb.env=chrome test-app`
* ie - `-Dgeb.env=ie test-app`
* htmlunit - default but can be run with cli params
see comments in gebconfig about firefox mess

### commit 28837
segregating running test-app by types : keep all get functional tests in the geb package folder and add others in the
now we can run `test-app geb* -integration` for geb functionals assuming we keep them all under the geb package.
and `test-app org.* -integration` for standard grail integration tests

### commit bef291
Setup for GebReportingSpec and screen shots. More advanced testing examples
- extending from GebReportingSpec vs GebSpec will have screenshots and output captured after each test
- reportsDir setup in gebconfig
- shows examples of filling out forms, looking up domains, etc..

