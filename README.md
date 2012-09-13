# lineqs
**lineqs** is a simple application for solving systems of *X* linear equations
with *X* variables. It's written in [Clojure](http://clojure.org/) what is
a dialect of LISP running on JRE. It runs from the command line.

## Requirements
- Java Runtime Environment ([link](http://www.oracle.com/technetwork/java/javase/downloads/jre7u7-downloads-1836441.html))

## Usage
First prepare a matrix of the equations you want to solve in your text
editor and save it. Open your command your command line, go to the folder
with lineqs.jar and run the following command:

  user@computer$ java -jar lineqs.jar [filename]
  (e.g. java -jar lineqs.jar examples/eq2.txt)

## Format of the equations file
- Plain text
- The number of variables must be equal to the number of equations
- One equations per line
- No blank line
- No written variablies (e.g. x, z.)
- The numbers must be divided by 1 or more whitespaces (i.e. everything except [-/0123456789])
- The minus must not be separated from the number (e.g -6, NOT - 6)
- There must be no zeroes on the main diagonal
- See examples

## Known issues
- If there's a zero on the main diagonal, the application fails to solve
the system.

## License
Copyright (c) 2012, Gandalf
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

- Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
- Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
