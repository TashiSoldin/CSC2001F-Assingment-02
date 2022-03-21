# CSC2001F Assignment 02

## Overview
This assignment aims to compare the operation of an AVL tree when dealing with the same dataset but randomized to different degrees.
A dataset of 9919 enties is randomized using a randomize function within the AVLExperiment class to a specified degree X. 
The dataset is then inserted into an AVL tree and the number of insert-related operations is counted, stored and displayed.
A search fucntion is then performed on the AVL tree and the number of search-related operations is counted, stored and displayed.

## Makefile
The following commands can be used to run the code by using the Makefile.

- **make** - compile all relevant Java files for both the array and BST methods
- **make run X** - run the AVLExperiment function to randomized data to the degree of X 
                and execute an AVL insert and search algorithm
- **make clean** - delete all class files from the *bin* folder
