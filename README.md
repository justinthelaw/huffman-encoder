# Program Execution Instructions

## PROJECT 03: Huffman Encoder, Binary Tree

## Usage Instructions

The source code in this assignment can be compiled with JDK 17+ from the command line into a `project-03.jar`.

To run the program as an encoder, enter: `java -jar project-03 [input frequency table file] [input clear text file] [output encoded file]`.

To run the program as a decoder, enter: `java -jar project-03 [input frequency table file] [input coded text file] [output decoded file]`.

This program was written in VSCode v1.71.2 in WSL 2.0, Ubuntu 20.04.4 LTS, with OpenJDK 17.0.3.

## Example based on `FreqTable.txt`

Hello World

1101101000010001111100011111101000000101100

## Input Formatting

### [input frequency table file]

#### Example Good Input

```txt
A - 19
B - 16
C - 17
```

#### Example Bad Input

```txt
A19B33-Dfjf
001000111111101011111011001111111000100011111000001010000001110010111
Sally sells seashells by the seashore.
```

### [input clear text file]

#### Example Good Input

```txt
Sally sells seashells by the seashore.
Peter Piper picked a peck of pickled peppers a peck of pickled peppers Peter Piper picked.
Houston, the Eagle has landed.
Is that your final answer?
```

#### Example Bad Input

```txt
&&&&&*****%%%!^^
10110000101010011011101101100010110010101100010111000110111
11111110001000111111101011111011001111111000100011111000001010000001110010111
```

### [input coded text file]

#### Example Good Input

```txt
01011001010110011111011011
10110000101010011011101101100010110010101100010111000110111
11111110001000111111101011111011001111111000100011111000001010000001110010111

```

#### Example Bad Input

```txt
20000039373821
10101010101010101010101010101
&&&&&*****%%%!^^
```
