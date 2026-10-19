# Software Testing

Coursework for **Software Testing**, Master's Degree in Computer Engineering, University of Naples Federico II.

## Esercitazioni — Lab Exercises

My own solutions to the course's practical assignments, each paired with its assignment sheet:

- [`FontInfoExercize`](Esercitazioni/FontInfoExercize) — unit testing a font-info utility class.
- [`IteratorExercize`](Esercitazioni/IteratorExercize) — the same iterator exercise implemented twice, once with JUnit 4 and once with JUnit 5.
- [`SmellGame`](Esercitazioni/SmellGame) — identifying test smells in given subject code (FTPFile, SubjectParser, TimeStamp), each with the class under analysis, the generated shell/test code, and the results.
- [`SubjectParserExercize`](Esercitazioni/SubjectParserExercize) — coverage-based testing experiment on a parser class, including the measured coverage report.
- [`TestGioco`](Esercitazioni/TestGioco) — automated test generation (EvoSuite and Randoop) at three difficulty levels on four subject classes (FTPFile, HSLColor, OutputFormat, TimeStamp), with the generated tests and coverage screenshots for each run.

## Example

[`Example/`](Example) collects the course's own progressive teaching examples (plain JUnit 3/4/5, parameterized tests, exception testing, black-box testing, theories) built around a simple Calculator class — not my own work, kept here as reference material alongside the exercises above, cleaned of IDE/build artifacts.
