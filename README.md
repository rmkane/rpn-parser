# RPN Expression Parser and Evaluator

This is an infix expression parser and Reverse Polish notation (RPN) evaluator.

Based off of [*Mathematical Expression Parsers in Java and C++*][1] over at technical-recipes.com.

## Logging

Configure the main class to use the log4j2.json file:

    -Dlog4j.configurationFile=src/main/resources/rpn/calculator/core/log4j2.json 

In Eclipse, under *Run Configurations*, the argument above should be pasted in the VM arguments section.

## Contributing

Submit a pull request, after forking and modifying.

  [1]: http://www.technical-recipes.com/2011/a-mathematical-expression-parser-in-java-and-cpp/