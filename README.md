# Minimum proof-of-concept reproducible PIT-based mutation testing project

Goal of this repo is to learn, how mutation testing works, based on [PIT framework](https://pitest.org/). Instructions
for Maven users are briefly discussed [here](https://pitest.org/quickstart/maven).

It turns out, that `pitest` plugin is __very__ picky. If you run this goal in isolation, for example as
in `mvn pitest:mutationCoverage`, it might happily pass, or utterly fail, depending on some as-yet-unknown state. In
order to achieve any level of reproducibility, I have to always run it as:

`mvn clean compile test pitest:mutationCoverage`

Couple of words about PIT terminology and configuration:

`Killed` mutant means "test failed when code was mutated", i.e. this mutation has "mutation coverage" => GOOD.

`Survived` means "test PASSED" when the code was mutated, i.e. test does not assert for effect of this specific line of
code, meaning this line has no coverage => BAD (for mutation coverage)

`No Coverage` means "no test has been executed, that would cover this line of code at all" => BAD (for mutation
coverage). For me, this seems to only happen when I run `pitest` after `clean compile` goals, but without running `test`
goal first.

And finally, `pitest` produces HTML reports under `target/pit-reports`, which highlight all lines and mutations it tried
to apply. 